package matematicadiscreta;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class TipoConjunto {

    public static boolean ehReflexiva(int tam, String[][] matriz) {
        for (int i = 1; i < tam; i++) {
            if (matriz[i][i].equals("0")) {
                return false;
            }
        }
        return true;
    }

    // Não Reflexiva
    public static boolean ehIrreflexiva(int tam, String[][] matriz) {
        for (int i = 1; i < tam; i++) {
            if (matriz[i][i].equals("1")) {
                return false;
            }
        }
        return true;
    }

    public static boolean ehSimetrica(int tam, String[][] matriz) {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (i != j) {
                    if (!matriz[i][j].equals(matriz[j][i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean ehTransitiva(int tam, String[][] matriz, ArrayList<SubConjunto> endorrelacao) {
        for (int i = 0; i >= tam; i++) {
            for (int j = 0; j >= tam; j++) {
                if (endorrelacao.get(i).getA().toString().equals(endorrelacao.get(j).getB().toString())) {
                    if (matriz[i][j].equals("0")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void ehTransitivaImp(ArrayList<SubConjunto> endorrelacao) {
        if (endorrelacao.isEmpty()) {
            System.err.println("vazia");
//            return true;
        } else {
            int tamEndo = endorrelacao.size();
            if (tamEndo >= 2 && tamEndo < 4) {
                ArrayList<String> arrAux = new ArrayList();
                String conjInverso = new String();
                int posConj = 0;
                for (int i = 0; i < tamEndo; i++) {
                    String A = endorrelacao.get(i).getA().toString();
                    String B = endorrelacao.get(i).getB().toString();
                    if (!A.equals(B)) {
                        conjInverso = B + "," + A;
                        posConj = i;
                    }
                    String conjAux = A + "," + B;
                    arrAux.add(conjAux);
                }
                for (int i = 0; i < tamEndo; i++) {
                    if (posConj != i) {
                        if (arrAux.get(i).equals(conjInverso)) {
                            System.out.println("falso");
                        }
                    }
                }
            }
        }
        System.err.println("truE, ultimo");
//        return true;
    }
}
