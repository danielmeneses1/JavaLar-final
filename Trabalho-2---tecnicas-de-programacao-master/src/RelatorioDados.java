import Control.Estudante;
import model.JavalarDAO;

public class RelatorioDados {
    private Estudante estudanteComMaisEnvios;
    private String planetasQueMaisMorreram;
    private String planetaComMaisVida;
    private int quadranteComMaisBugs;
    private int quadranteComMaisDevs;
    private int totalDeInstantesAnalizados;
    private double[] velocidadeMediaDosPlanetas;
    private int totalDeBugsEncontrados;
    private int totalDeDevsEncontrados;
    private int totalDeHorasPassadas;
    private int totalDeAnosPassados;

    public RelatorioDados(Estudante estudanteComMaisEnvios, String planetasQueMaisMorreram, String planetaComMaisVida,
                          int quadranteComMaisBugs, int quadranteComMaisDevs, int totalDeInstantesAnalizados,
                          double[] velocidadeMediaDosPlanetas, int totalDeBugsEncontrados, int totalDeDevsEncontrados,
                          int totalDeHorasPassadas, int totalDeAnosPassados) {
        this.estudanteComMaisEnvios = estudanteComMaisEnvios;
        this.planetasQueMaisMorreram = planetasQueMaisMorreram;
        this.planetaComMaisVida = planetaComMaisVida;
        this.quadranteComMaisBugs = quadranteComMaisBugs;
        this.quadranteComMaisDevs = quadranteComMaisDevs;
        this.totalDeInstantesAnalizados = totalDeInstantesAnalizados;
        this.velocidadeMediaDosPlanetas = velocidadeMediaDosPlanetas;
        this.totalDeBugsEncontrados = totalDeBugsEncontrados;
        this.totalDeDevsEncontrados = totalDeDevsEncontrados;
        this.totalDeHorasPassadas = totalDeHorasPassadas;
        this.totalDeAnosPassados = totalDeAnosPassados;
    }

}
