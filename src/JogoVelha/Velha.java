package JogoVelha;

/**
 *
 * @author Diego
 */
public class Velha {

    private String[][] velha = new String[3][3];
    private String ultimoJogador;

    public void Velha(int x, int y, String jogador) {
        this.getVelha()[x][y] = jogador;
        if (jogador.equals("X")) {
            this.setUltimoJogador("O");
        } else {
            this.setUltimoJogador("X");
        }
    }

    public void JogadasDisponiveis() {
        System.out.println("Jogadas Disponíveis para " + this.ultimoJogador);
        buscarJogadas(this.getVelha(), 0, 0);
        System.out.println("Fim!");
    }

    public static void buscarJogadas(String[][] velha, int v, int h) {
        if (velha[v][h] == null) {
            System.out.println("velha[" + v + "][" + h + "]");
            if (h < 3 - 1) {
                buscarJogadas(velha, v, h + 1);
            } else {
                h = 0;
                if (v < 3 - 1) {
                    buscarJogadas(velha, v + 1, h);
                }
            }
        } else {
            if (h < 3 - 1) {
                buscarJogadas(velha, v, h + 1);
            } else {
                h = 0;
                if (v < 3 - 1) {
                    buscarJogadas(velha, v + 1, h);
                } else {
                    System.out.println("Fim!");
                }
            }
        }
    }

    public String getUltimoJogador() {
        return ultimoJogador;
    }
}
