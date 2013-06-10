package matematicadiscreta;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class OpSobreConj {
    // remove os itens repetidos do array

    public static void removerRepetidos(ArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                if ((i != j) && a.get(i) == a.get(j)) {
                    a.remove(j);
                    j--;
                }
            }
        }
    }

    public static void removerRepetidos(String x, int pos, ArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                if ((i != j) && a.get(i) == a.get(j)) {
                    a.remove(j);
                    j--;
                }
            }
        }
    }

    //  adiciona as endorrelações no array endorrelações
    public static void addEndorrelacoes(ArrayList conjunto, ArrayList endorrelacoes) {
    }

    public static String inverso(String string) {
        String inverso = "";
        char arrayChar[] = string.toCharArray();
        for (int i = arrayChar.length - 1; i >= 0; i--) {
            inverso += String.valueOf(arrayChar[i]);
//            if(string.charAt(i) == '>'){
//            }
        }
        inverso = inverso.replace('>', '<');
        return inverso;
    }

    // retorna os tipo de uma relação informada
    public static ArrayList<String> GerarTipo(ArrayList<SubConjunto> endorrelacao, ArrayList conj) {
        ArrayList<String> tipo = new ArrayList();
        int tam = conj.size() + 1;
        String[][] matrizDoConjunto = new String[tam][tam];
        matrizDoConjunto[0][0] = "CONJ";
        System.out.print("\n");

        // preenche as extremidades da matriz[linhas][colunas] com os elementos do conjunto
        for (int i = 0; i < tam; i++) {
            if (i != tam - 1) {
                matrizDoConjunto[0][i + 1] = conj.get(i).toString();
                matrizDoConjunto[i + 1][0] = conj.get(i).toString();
            }
        }

        int tamRelacao = endorrelacao.size();

        // preenche a matriz em seu centro com valores binarios
        ArrayList conjEndo = new ArrayList();
        for (int j = 0; j < tamRelacao; j++) {
            String aux = "<" + endorrelacao.get(j).getA() + "," + endorrelacao.get(j).getB() + ">";
            conjEndo.add(aux);
        }

        for (int i = 1; i < tam; i++) {
            for (int j = 1; j < tam; j++) {
                String conjAux = "<" + matrizDoConjunto[0][i] + "," + matrizDoConjunto[j][0] + ">";
                if (conjEndo.contains(conjAux)) {
                    matrizDoConjunto[i][j] = "1";
                } else {
                    matrizDoConjunto[i][j] = "0";
                }
            }
        }

        // inserindo os tipos ------ INICIO --------------
        // reflexiva
        if (TipoConjunto.ehReflexiva(tam, matrizDoConjunto)) {
            tipo.add("Reflexiva");
//            tipo.add("Transitiva");
        } else {
            // irreflexiva
            if (TipoConjunto.ehIrreflexiva(tam, matrizDoConjunto)) {
                tipo.add("Irreflexiva");
            }
        }

        // simetrica
        if (TipoConjunto.ehSimetrica(tam, matrizDoConjunto)) {
            tipo.add("Simétrica");
        } else {
            tipo.add("Assimétrica");

        }

        // transitiva, código incompleto -------------------------
        if (TipoConjunto.ehTransitiva(endorrelacao)) {
            tipo.add("Transitiva");
        } else {
            tipo.add("Não Transitiva");
        }

        if (tipo.isEmpty()) {
            tipo.add("Não há tipo(s)");
            return tipo;
        }

        // inserindo os tipos ---- FIM -------------------
        return tipo;
    }

    public static void imprimirEndorrelacoes(ArrayList endorrelacoes) {
        System.out.println("Endorrelações:");
        for (int i = 0; i < endorrelacoes.size(); i++) {
            System.out.print("\tR" + (i + 1) + ": ");
            //System.out.println("item"+j);
            System.out.print(endorrelacoes.get(i).toString());
            System.out.print("\n");
        }
    }

    public static ArrayList<String> conjEndorrelacoes(ArrayList<ArrayList<SubConjunto>> endorrelacoes) {
        ArrayList<String> conjendo = new ArrayList();
        for (int i = 0; i < endorrelacoes.size(); i++) {
            System.out.print("\tR" + (i + 1) + ": {");
            String conj = new String();
            for (int j = 0; j < endorrelacoes.get(i).size(); j++) {
                //System.out.println("item"+j);
                System.out.print(" <" + endorrelacoes.get(i).get(j).getA() + "," + endorrelacoes.get(i).get(j).getB() + ">");
                conj = " <" + endorrelacoes.get(i).get(j).getA() + "," + endorrelacoes.get(i).get(j).getB() + ">";
            }
            System.out.print(" }\n");
        }
        System.out.print("\n");

        return conjendo;
    }

    public static void imprimirConjunto(ArrayList a) {
        // imprime o conjunto total
        System.out.print("Conjunto: \t{");
        String conj = new String();
        for (int i = 0; i < a.size(); i++) {
            conj += a.get(i) + ",";
        }
        conj = conj.substring(0, conj.length() - 1);
        System.out.print(conj);
        System.out.print("}\n");
    }
}
