package matematicadiscreta;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class OpSobreArray1 {
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

    // adiciona as endorrelações no array endorrelações
    public static void addEndorrelacoes(ArrayList a, ArrayList<ArrayList<SubConjunto>> endorrelacoes) {
        /*
         * ArrayList a -> contem todos os elementos
         * ArrayList c -> vai receber todas as endorrelacoes
         */
        ArrayList<SubConjunto> b = new ArrayList();
        endorrelacoes.add(b);
        endorrelacoes.add(new ArrayList<SubConjunto>());
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                b.add(new SubConjunto(a.get(i), a.get(j)));
                ArrayList<SubConjunto> x = new ArrayList();
                x.add(new SubConjunto(a.get(i), a.get(j)));
                endorrelacoes.add(x);
            }
        }
        for (int i = 0; i < b.size(); i++) {
            ArrayList<SubConjunto> x = new ArrayList(b);
            x.remove(x.get(i));
            endorrelacoes.add(x);
        }
        for (int i = 0; i < b.size() - 1; i++) {
            int aux = i + 1;
            for (int j = i; j < b.size(); j++) {
                if (aux < b.size()) {
                    ArrayList<SubConjunto> x = new ArrayList();
                    System.out.print("HAHAHA\t" + b.get(i).getA() + " " + b.get(aux).getB() + "\n");
                    x.add(b.get(i));
                    x.add(b.get(aux));
                    endorrelacoes.add(x);
                    aux++;
                } else {
                    break;
                }
            }
        }
    }

    // retorna os tipo de uma relação informada
    public static ArrayList<String> GerarTipo(ArrayList<SubConjunto> endorrelacao, ArrayList conj) {
        ArrayList<String> tipo = new ArrayList();
        int tam = conj.size() + 1;
        String[][] matriz = new String[tam][tam];
        matriz[0][0] = "CONJ";
        System.out.print("\n");

        // preenche as extremidades da matriz[linhas][colunas] com os elementos do conjunto
        for (int i = 0; i < tam; i++) {
            if (i != tam - 1) {
                matriz[0][i + 1] = conj.get(i).toString();
                matriz[i + 1][0] = conj.get(i).toString();
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
                String conjAux = "<" + matriz[0][i] + "," + matriz[j][0] + ">";
                if (conjEndo.contains(conjAux)) {
                    matriz[i][j] = "1";
                } else {
                    matriz[i][j] = "0";
                }
            }
        }

        // inserindo os tipos ------ INICIO --------------
        // reflexiva
        if (TipoConjunto.ehReflexiva(tam, matriz)) {
            tipo.add("Reflexiva");
//            tipo.add("Transitiva");
        } else {
            // irreflexiva
            if (TipoConjunto.ehIrreflexiva(tam, matriz)) {
                tipo.add("Irreflexiva");
            }
        }

        // simetrica
        if (TipoConjunto.ehSimetrica(tam, matriz)) {
            tipo.add("Simétrica");
        } else {
            tipo.add("Assimétrica");

        }

        // transitiva, código incompleto
//        TipoConjunto.ehTransitivaImp(endorrelacao);
        if (TipoConjunto.ehTransitiva(tam, matriz, endorrelacao)) {
            tipo.add("Transitiva");
        } else {
            tipo.add("Não Transitiva");
        }
        // inserindo os tipos ---- FIM -------------------

        // imprime endorelacao informada


//        System.out.print("{");
//        for (int j = 0; j < tamRelacao; j++) {
//            //System.out.println("item"+j);
//            System.out.print(" <" + relacao.get(j).getA() + "," + relacao.get(j).getB() + ">");
//        }
//        System.out.print(" }\n");
//
//        // imprime matriz
//        System.out.print("Matriz: \n");
//        for (int i = 0; i < tam; i++) {
//            for (int j = 0; j < tam; j++) {
//                System.out.print(matriz[i][j] + "\t");
//            }
//            System.out.print("\n");
//        }
//
//        System.out.print("\n");
//        

        // retorna o resultado
        if (tipo.isEmpty()) {
            tipo.add("Não há tipo(s)");
            return tipo;
        }
        return tipo;
    }

    public static void imprimirEndorrelacoes(ArrayList<ArrayList<SubConjunto>> endorrelacoes) {
        System.out.println("Endorrelações:");
        for (int i = 0; i < endorrelacoes.size(); i++) {
            System.out.print("\tR" + (i + 1) + ": {");
            for (int j = 0; j < endorrelacoes.get(i).size(); j++) {
                //System.out.println("item"+j);
                System.out.print(" <" + endorrelacoes.get(i).get(j).getA() + "," + endorrelacoes.get(i).get(j).getB() + ">");
            }
            System.out.print(" }\n");
        }
        System.out.print("\n");
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
}
