package JogoVelha;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class JogoDaVelha {

    public static void main(String[] args) {
        String[][] velha = new String[3][3];
        imprimirJogo(velha);

        String jogador = "X";
        while (true) {
            if (!terminou(velha)) {
                try {
                    int l = Integer.parseInt(JOptionPane.showInputDialog("Digite -1 para sair\nJogador: " + jogador + "\nLinha:"));
                    if (l == -1) {
                        break;
                    }
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Coluna:"));
                    if (velha[l][c] != null) {
                        JOptionPane.showMessageDialog(null, "Campo já preenchido!");
                    } else {
                        try {
                            velha[l][c] = jogador;
                            if (jogador.equals("X")) {
                                jogador = "O";
                            } else {
                                jogador = "X";
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Campo não existente! " + ex);
                            System.err.println("Campo não existente!" + ex);
                        }

                        imprimirJogo(velha);
                        imprimirPossibilidades(velha, jogador);

                        String venceu = jaVenceu(velha);
                        if (!venceu.equals("falso")) {
                            JOptionPane.showMessageDialog(null, "Jogador: " + venceu + " Venceu!\nO Jogo será reiniciado!");
                            reiniciarJogo(velha);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Posição não existente!");
                    System.out.println("Posição não existente!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "FIM DE JOGO!");
                System.out.println("Fim de Jogo!");
                break;
            }
        }
    }

    public static void reiniciarJogo(String[][] velha) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                velha[i][j] = null;
            }
        }
    }

    public static String jaVenceu(String[][] velha) {
        int tam = velha.length;

        //checa as colunas
        for (int i = 0; i < tam; i++) {
            //checa as colunas 
            if (velha[0][i] != null && velha[0][i].equals(velha[1][i]) && velha[0][i].equals(velha[2][i])) {
                return velha[0][i];
            }

            //checa as linhas
            if (velha[i][0] != null && velha[i][0].equals(velha[i][1]) && velha[i][0].equals(velha[i][2])) {
                return velha[i][0];
            }
        }

        //checa as diagonal esq para dir
        if (velha[1][1] != null && velha[1][1].equals(velha[2][2]) && velha[1][1].equals(velha[2][2])) {
            return velha[1][1];
        }

        //checa as diagonal dir para esq
        if (velha[0][2] != null && velha[0][2].equals(velha[1][1]) && velha[1][1].equals(velha[2][0])) {
            return velha[1][1];
        }

        return "falso";
    }

    public static boolean terminou(String[][] velha) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (velha[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimirPossibilidades(String[][] velha, String jogador) {
        System.out.print("\nJogadas Possíveis para " + jogador + ": \n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (velha[i][j] == null) {
                    System.out.print("[" + i + "] [" + j + "]\n");
                }
            }
        }
    }

    public static void imprimirJogo(String[][] velha) {
        System.out.print("\nMatriz: \n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(velha[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}