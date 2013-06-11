package JogoVelha;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class JogoDaVelha {

    public static void main(String[] args) {
        Velha jogo = new Velha();
        jogo.Velha(0, 0, "X");
        jogo.JogadasDisponiveis();
    }
}
