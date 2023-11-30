package Control;

import java.util.ArrayList;

import Control.Plano.Plano;
import View.PainelJogo;
import model.JavalarDAO;

public class ProcessarDadosBanco {

    public ProcessarDadosBanco() {
        estudanteComMaisEnvios = javalarDAO.EstudantesComMaisEnvios();
        planetasQueMaisMorreram = javalarDAO.PlanetasQueMaisMorreram();
        planetaComMaisVida = javalarDAO.PlanetaComMaisVida();
        quadranteComMaisBugs = javalarDAO.quadranteComMaisBugs();
        quadranteComMaisDevs = javalarDAO.quadranteComMaisDevs();
        totalDeInstantesAnalizados = javalarDAO.TotalDeInstantesAnalizados();
        velocidadeMediaDosPlanetas = javalarDAO.VelocidadeMediaDosPlanetas();
        totalDeBugsEncontrados = javalarDAO.TotalDeBugsEncontrados();
        totalDeDevsEncontrados = javalarDAO.TotalDeDevsEncontrados();
        totalDeHorasPassadas = javalarDAO.TotalDeHorasPassadas();
        totalDeAnosPassados = javalarDAO.TotalDeAnosPassados();

    }

    JavalarDAO javalarDAO = new JavalarDAO(new Plano(), new ArrayList<>(), new PainelJogo(new Plano()));

        Estudante estudanteComMaisEnvios = javalarDAO.EstudantesComMaisEnvios();
        String planetasQueMaisMorreram = javalarDAO.PlanetasQueMaisMorreram();
        String planetaComMaisVida = javalarDAO.PlanetaComMaisVida();
        int quadranteComMaisBugs = javalarDAO.quadranteComMaisBugs();
        int quadranteComMaisDevs = javalarDAO.quadranteComMaisDevs();
        int totalDeInstantesAnalizados = javalarDAO.TotalDeInstantesAnalizados();
        double[] velocidadeMediaDosPlanetas = javalarDAO.VelocidadeMediaDosPlanetas();
        int totalDeBugsEncontrados = javalarDAO.TotalDeBugsEncontrados();
        int totalDeDevsEncontrados = javalarDAO.TotalDeDevsEncontrados();
        int totalDeHorasPassadas = javalarDAO.TotalDeHorasPassadas();
        int totalDeAnosPassados = javalarDAO.TotalDeAnosPassados();


    public Estudante getEstudanteComMaisEnvios() {
        return estudanteComMaisEnvios;
    }

    public String getPlanetasQueMaisMorreram() {
        return planetasQueMaisMorreram;
    }

    public String getPlanetaComMaisVida() {
        return planetaComMaisVida;
    }

    public int getQuadranteComMaisBugs() {
        return quadranteComMaisBugs;
    }

    public int getQuadranteComMaisDevs() {
        return quadranteComMaisDevs;
    }

    public int getTotalDeInstantesAnalizados() {
        return totalDeInstantesAnalizados;
    }

    public double[] getVelocidadeMediaDosPlanetas() {
        return velocidadeMediaDosPlanetas;
    }

    public int getTotalDeBugsEncontrados() {
        return totalDeBugsEncontrados;
    }

    public int getTotalDeDevsEncontrados() {
        return totalDeDevsEncontrados;
    }

    public int getTotalDeHorasPassadas() {
        return totalDeHorasPassadas;
    }

    public int getTotalDeAnosPassados() {
        return totalDeAnosPassados;
    }
}


