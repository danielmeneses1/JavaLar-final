package Control;
import model.JavalarDAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscreverDadosNoArquivo {

    private JavalarDAO dao;

    public EscreverDadosNoArquivo(JavalarDAO dao) {
        this.dao = dao;
    }

    public void chamarTodosOsMetodosDeEscrita(String nomeArquivo){
        escreverEstudanteComMaisEnvios(nomeArquivo);
        EscreverPlanetaComMaisVida(nomeArquivo);
        EscreverPlanetasQueMaisMorreram(nomeArquivo);
        EscreverQuadranteComMaisBugs(nomeArquivo);
        EscreverQuadranteComMaisDevs(nomeArquivo);
        EscreverTotalDeInstantesAnalizados(nomeArquivo);
        escreverVelocidadeMediaDosPlanetas(nomeArquivo);
        EscreverTotaldeBugsEncontrados(nomeArquivo);
        EscreverTotalDeDevsEncontrados(nomeArquivo);
        EscreverTotalDeHorasPassadas(nomeArquivo);
        EscreverTotalDeAnosPassados(nomeArquivo);
        System.out.println("Relatório gerado com sucesso!");
    }

    public void escreverEstudanteComMaisEnvios(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            Estudante estudante = dao.EstudantesComMaisEnvios();
            if (estudante != null) {
                writer.println("Estudante com mais envios: " + estudante.getNome() + ", Matrícula: " + estudante.getMatricula());
            } else {
                writer.println("Nenhum estudante encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverPlanetasQueMaisMorreram(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String planetas = dao.PlanetasQueMaisMorreram();
            if (!planetas.isEmpty()) {
                writer.println("Planetas que mais morreram: " + planetas);
            } else {
                writer.println("Nenhum planeta encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverPlanetaComMaisVida(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String planetas = dao.PlanetaComMaisVida();
            if (!planetas.isEmpty()) {
                writer.println("Planeta com mais vida: " + planetas);
            } else {
                writer.println("Nenhum planeta encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverQuadranteComMaisBugs(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String quadrante = String.valueOf(dao.quadranteComMaisBugs());
            if (!quadrante.isEmpty()) {
                writer.println("Quadrante com mais bugs: " + quadrante);
            } else {
                writer.println("Nenhum quadrante encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverQuadranteComMaisDevs(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String quadrante = String.valueOf(dao.quadranteComMaisDevs());
            if (!quadrante.isEmpty()) {
                writer.println("Quadrante com mais devs: " + quadrante);
            } else {
                writer.println("Nenhum quadrante encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverTotalDeInstantesAnalizados(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String total = String.valueOf(dao.TotalDeInstantesAnalizados());
            if (!total.isEmpty()) {
                writer.println("Total de instantes analizados: " + total);
            } else {
                writer.println("Nenhum instante encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void escreverVelocidadeMediaDosPlanetas(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            double[] velocidadeMedia = dao.VelocidadeMediaDosPlanetas();
            writer.println("Velocidade Média dos Planetas:");

            String[] planetas = {"Python", "JavaScript", "Ruby", "PHP", "C#", "C++", "C"};
            for (int i = 0; i < velocidadeMedia.length; i++) {
                writer.println(planetas[i] + ": " + velocidadeMedia[i]);
            }
            writer.println();  // Adiciona uma linha em branco para separar os resultados.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverTotaldeBugsEncontrados(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String total = String.valueOf(dao.TotalDeBugsEncontrados());
            if (!total.isEmpty()) {
                writer.println("Total de bugs encontrados: " + total);
            } else {
                writer.println("Nenhum bug encontrado.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EscreverTotalDeDevsEncontrados(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String total = String.valueOf(dao.TotalDeDevsEncontrados());
            if (!total.isEmpty()) {
                writer.println("Total de devs encontrados: " + total);
            } else {
                writer.println("Nenhum dev encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void EscreverTotalDeHorasPassadas(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String total = String.valueOf(dao.TotalDeHorasPassadas());
            if (!total.isEmpty()) {
                writer.println("Total de horas passadas: " + total);
            } else {
                writer.println("Nenhuma hora encontrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void EscreverTotalDeAnosPassados(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String total = String.valueOf(dao.TotalDeAnosPassados());
            if (!total.isEmpty()) {
                writer.println("Total de anos passados: " + total);
            } else {
                writer.println("Nenhum ano encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}