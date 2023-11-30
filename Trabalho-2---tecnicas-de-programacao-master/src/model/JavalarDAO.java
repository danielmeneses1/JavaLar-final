package model;

import Control.Estudante;
import Control.Plano.Plano;
import Control.planetas.Planeta;
import View.PainelJogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavalarDAO {
    private DbConnector conexao;
    private PainelJogo painelJogo = new PainelJogo(new Plano());
    private Plano plano;


    public JavalarDAO(Plano plano, List<Planeta>planetas, PainelJogo painelJogo) {
       this.painelJogo = painelJogo;
    }

    public void inserirDados(Plano plano, List<Planeta> planetas){
        try{
            Connection conexao = new DbConnector().conectar();
            PreparedStatement insert = conexao.prepareStatement("INSERT INTO javalar (nome, matricula, nome_arquivo, "
                    + "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, "
                    + "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
                    + "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
                    + "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
                    + "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
                    + "bug_q1, bug_q2, bug_q3, bug_q4, " + "dev_q1, dev_q2, dev_q3, dev_q4) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");insert.setString(1, plano.getNome());
            insert.setString(2, plano.getMatricula()+"");
            insert.setString(3, "AE_10.csv");
            int i = 4;
            for (Planeta planeta : planetas) {
                if (planeta.getNome().equals("Java") == false) {
                    insert.setInt(i, planeta.getColisoesBugs());
                    i++;
                }
            }
            for (Planeta planeta : planetas) {
                if (planeta.getNome().equals("Java") == false) {
                    insert.setInt(i, planeta.getColisoesDevs());
                    i++;
                }
            }
            for (Planeta planeta : planetas) {
                if (planeta.getNome().equals("Java") == false) {
                    insert.setInt(i, (int) planeta.getTranslacao());
                    i++;
                }
            }
            for (Planeta planeta : planetas) {
                if (planeta.getNome().equals("Java") == false) {
                    insert.setInt(i, (int) planeta.getRotacao());
                    i++;
                }
            }
            for (Planeta planeta : planetas) {
                if (planeta.getNome().equals("Java") == false) {
                    insert.setInt(i, planeta.getAnoJavalar());
                    i++;
                }
            }

            insert.setInt(39, plano.getQuadrante1Bugs());
            insert.setInt(40, plano.getQuadrante2Bugs());
            insert.setInt(41, plano.getQuadrante3Bugs());
            insert.setInt(42, plano.getQuadrante4Bugs());
            insert.setInt(43, plano.getQuadrante1Devs());
            insert.setInt(44, plano.getQuadrante2Devs());
            insert.setInt(45, plano.getQuadrante3Devs());
            insert.setInt(46, plano.getQuadrante4Devs());

            insert.execute();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getData(){
        try {
            Connection conexao = new DbConnector().conectar();
            String sql = "SELECT * FROM javalar";
            return conexao.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            System.out.println("Não foi possível obter os dados");
            e.printStackTrace();
        }
        return null;
    }

    public Estudante EstudantesComMaisEnvios() {
        ArrayList<Estudante> estudantes = new ArrayList<>();
        String sql = "SELECT * FROM javalar";
        try {
            Connection conexao = new DbConnector().conectar();

            ResultSet resultSet = conexao.prepareStatement(sql).executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int matricula = resultSet.getInt("matricula");
                estudantes.add(new Estudante(nome, matricula));
            }
            conexao.close();
        } catch (Exception e) {
            System.out.println("Não foi possível obter os dados");
            e.printStackTrace();
        }
        Map<Estudante, Integer> estudantesComEnvios = new HashMap<>();

        Estudante estudanteComMaisEnvios = null;
        int maiorNumeroDeEnvios = 0;

        for(Map.Entry<Estudante, Integer> enntry : estudantesComEnvios.entrySet()){
            if(enntry.getValue() > maiorNumeroDeEnvios){
                estudanteComMaisEnvios = enntry.getKey();
                maiorNumeroDeEnvios = enntry.getValue();
            }
        }
        return estudanteComMaisEnvios;
    }

    public String PlanetasQueMaisMorreram(){
        ArrayList<String> planetasMorridos = new ArrayList<>();
        try{
            ResultSet resultado = getData();

            while(resultado.next()){
                if(resultado.getInt("v_python") == 0){
                    planetasMorridos.add("Python");
                }
                if(resultado.getInt("v_javascript") == 0){
                    planetasMorridos.add("Javascript");
                }
                if(resultado.getInt("v_ruby") == 0){
                    planetasMorridos.add("Ruby");
                }
                if(resultado.getInt("v_php") == 0){
                    planetasMorridos.add("PHP");
                }
                if(resultado.getInt("v_csharp") == 0){
                    planetasMorridos.add("C#");
                }
                if(resultado.getInt("v_cmais") == 0){
                    planetasMorridos.add("C++");
                }
                if(resultado.getInt("v_c") == 0){
                    planetasMorridos.add("C");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Integer> map = new HashMap<>();
        for(String planeta : planetasMorridos){
            Integer count = map.get(planeta);
            map.put(planeta, (count == null) ? 1 : count + 1);
        }
        String planetas = "";
        int maiorNumeroDeMortes = 0;

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > maiorNumeroDeMortes){
                planetas = entry.getKey();
                maiorNumeroDeMortes = entry.getValue();
            }
        }
        return planetas;
    }

    public String PlanetaComMaisVida() {
        try {
            ResultSet results = getData();

            int[] planets = { 0, 0, 0, 0, 0, 0, 0 };

            while (results.next()) {
                planets[0] += results.getInt("v_python");
                planets[1] += results.getInt("v_javascript");
                planets[2] += results.getInt("v_ruby");
                planets[3] += results.getInt("v_php");
                planets[4] += results.getInt("v_csharp");
                planets[5] += results.getInt("v_cmais");
                planets[6] += results.getInt("v_c");
            }

            int maxValue = 0;
            int planet = 0;

            for (int i = 0; i < planets.length; i++) {
                if (planets[i] > maxValue) {
                    maxValue = planets[i];
                    planet = i + 1;
                }
            }

            switch (planet) {
                case 1:
                    return "Python";
                case 2:
                    return "JavaScript";
                case 3:
                    return "Ruby On Rails";
                case 4:
                    return "PHP";
                case 5:
                    return "C#";
                case 6:
                    return "C++";
                case 7:
                    return "C";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public int quadranteComMaisBugs() {

        int[] quadrante = { 0, 0, 0, 0 };

        try {

            ResultSet results = getData();
            while (results.next()) {
                quadrante[0] += results.getInt("bug_q1");
                quadrante[1] += results.getInt("bug_q2");
                quadrante[2] += results.getInt("bug_q3");
                quadrante[3] += results.getInt("bug_q4");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int maxValue = 0;
        int quadrant = 0;

        for (int i = 0; i < quadrante.length; i++) {
            if (quadrante[i] > maxValue) {
                maxValue = quadrante[i];
                quadrant = i + 1;
            }
        }

        return quadrant;
    }

    public int quadranteComMaisDevs() {

        int[] quadrantes = { 0, 0, 0, 0 };

        try {

            ResultSet results = getData();
            while (results.next()) {
                quadrantes[0] += results.getInt("dev_q1");
                quadrantes[1] += results.getInt("dev_q2");
                quadrantes[2] += results.getInt("dev_q3");
                quadrantes[3] += results.getInt("dev_q4");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int maxValue = 0;
        int quadrant = 0;

        for (int i = 0; i < quadrantes.length; i++) {
            if (quadrantes[i] > maxValue) {
                maxValue = quadrantes[i];
                quadrant = i + 1;
            }
        }

        return quadrant;
    }

    public int TotalDeInstantesAnalizados() {
        try {
            ResultSet results = getData();

            int amountOfInstants = 0;

            while (results.next()) {
                amountOfInstants++;
            }

            return amountOfInstants;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public double[] VelocidadeMediaDosPlanetas() {

        int[] totaldeVelocidade = { 0, 0, 0, 0, 0, 0, 0 };
        int totaDeOcorrencias = TotalDeInstantesAnalizados();

        try {
            ResultSet results = getData();

            while (results.next()) {
                totaldeVelocidade[0] += results.getInt("v_python");
                totaldeVelocidade[1] += results.getInt("v_javascript");
                totaldeVelocidade[2] += results.getInt("v_ruby");
                totaldeVelocidade[3] += results.getInt("v_php");
                totaldeVelocidade[4] += results.getInt("v_csharp");
                totaldeVelocidade[5] += results.getInt("v_cmais");
                totaldeVelocidade[6] += results.getInt("v_c");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        double[] avarageVelocity = new double[totaldeVelocidade.length];

        for (int i = 0; i < totaldeVelocidade.length; i++) {
            avarageVelocity[i] = totaldeVelocidade[i] / (double) totaDeOcorrencias;
        }

        return avarageVelocity;
    }

    public int TotalDeBugsEncontrados() {
        try {
            ResultSet results = getData();

            int amountOfBugs = 0;

            while (results.next()) {
                amountOfBugs += results.getInt("bug_python");
                amountOfBugs += results.getInt("bug_javascript");
                amountOfBugs += results.getInt("bug_ruby");
                amountOfBugs += results.getInt("bug_php");
                amountOfBugs += results.getInt("bug_csharp");
                amountOfBugs += results.getInt("bug_cmais");
                amountOfBugs += results.getInt("bug_c");
            }

            return amountOfBugs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int TotalDeDevsEncontrados() {
        try {
            ResultSet results = getData();

            int totalDeDevs = 0;

            while (results.next()) {
                totalDeDevs += results.getInt("dev_python");
                totalDeDevs += results.getInt("dev_javascript");
                totalDeDevs += results.getInt("dev_ruby");
                totalDeDevs += results.getInt("dev_php");
                totalDeDevs += results.getInt("dev_csharp");
                totalDeDevs += results.getInt("dev_cmais");
                totalDeDevs += results.getInt("dev_c");
            }

            return totalDeDevs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int TotalDeHorasPassadas() {
        try {
            ResultSet results = getData();

            int amountOfHours = 0;

            while (results.next()) {
                amountOfHours += results.getInt("d_python");
                amountOfHours += results.getInt("d_javascript");
                amountOfHours += results.getInt("d_ruby");
                amountOfHours += results.getInt("d_php");
                amountOfHours += results.getInt("d_csharp");
                amountOfHours += results.getInt("d_cmais");
                amountOfHours += results.getInt("d_c");
            }

            return amountOfHours;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int TotalDeAnosPassados() {
        try {
            ResultSet results = getData();

            int amountOfYears = 0;

            while (results.next()) {
                amountOfYears += results.getInt("a_python");
                amountOfYears += results.getInt("a_javascript");
                amountOfYears += results.getInt("a_ruby");
                amountOfYears += results.getInt("a_php");
                amountOfYears += results.getInt("a_csharp");
                amountOfYears += results.getInt("a_cmais");
                amountOfYears += results.getInt("a_c");
            }

            return amountOfYears;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}





