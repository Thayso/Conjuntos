package matematicadiscreta;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class MatematicaDiscreta {

    public static void main(String[] args) {

        ArrayList conjunto = new ArrayList();

        ArrayList endorrelacoes = new ArrayList();

        // insira aqui os elementos do conjunto - INICIO ---
        conjunto.add(1);
        conjunto.add(5);
        // --- FIM 

//        OpSobreConj.removerRepetidos(conjunto);
//
////        OpSobreConj.imprimirConjunto(conjunto);
//
//        OpSobreConj.addEndorrelacoes(conjunto, endorrelacoes);

        ArrayList<SubConjunto> x = new ArrayList<>();                           // cria um array para receber o conjunto
        x.add(new SubConjunto(1, 1));                                           // adiciona o subconjuto: <1,1> no array
        System.out.print("Tipo(s): " + OpSobreConj.GerarTipo(x, conjunto));
//        OpSobreConj.imprimirEndorrelacoes(endorrelacoes);

        /*
         * na chamada do método abaixo mude apenas o valor inteiro
         * de acordo com a quantidade de endorelações.
         * Ou use o for para imprimir os tipos de todas as endorrelações.
         * */
//        System.out.print("Tipo(s): " + OpSobreConj.GerarTipo(endorrelacoes.get(2), a));

        /*
         System.out.print("\n______________________________________________\n");
         int qnt = endorrelacoes.size() - 1;
         for (int i = 0; i < qnt; i++) {
         System.out.print("\nR" + (i + 1) + ": \t");
         System.out.print(OpSobreConj.GerarTipo(endorrelacoes.get(i), a));
         System.out.print("\n______________________________________________\n");
         }
         */
        System.out.print("\n");
    }
}
