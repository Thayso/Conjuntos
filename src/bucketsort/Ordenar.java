package bucketsort;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Ordenar {

    public static void BucketSort(ArrayList<Integer> vetor) {
        int maior = 0;
        for (int i = 0; i < vetor.size(); i++) {
            if (vetor.get(i) > maior) {
                maior = vetor.get(i);
            }
        }

        int elementosPorBalde = 3;
        int numBaldes = maior / elementosPorBalde;
        System.out.print("numero de baldes " + numBaldes + "\n");

        ArrayList[] B = new ArrayList[numBaldes];

        for (int i = 0; i < numBaldes; i++) {
            B[i] = new ArrayList<Integer>();
        }

        //Coloca os valores no balde respectivo:
        for (int i = 0; i < vetor.size(); i++) {
            int j = numBaldes - 1;
            while (true) {
                if (j < 0) {
                    break;
                }
                if ((int) vetor.get(i) >= ((j * elementosPorBalde) + 1)) {
                    B[j].add(vetor.get(i));
                    break;
                }
                j--;
            }
        }
//         imprime os valores separados em baldes baldes.
//        for (int i = 0; i < B.length; i++) {
//            System.out.print(B[i] + "\t");
//        }

        //Ordena e atualiza o vetor:
        int indice = 0;
        for (int i = 0; i < numBaldes; i++) {

            int[] aux = new int[B[i].size()];

            //Coloca cada balde num vetor:
            for (int j = 0; j < aux.length; j++) {
                aux[j] = (Integer) B[i].get(j);
            }

            // algoritmo escolhido para ordenação.
            insertionSort(aux);

            // Devolve os valores ao vetor de entrada:
            for (int j = 0; j < aux.length; j++, indice++) {
                vetor.set(indice, aux[j]);
            }
        }
    }

    public static int[] insertionSort(int[] A) {
        int i, j, index;
        for (i = 1; i < A.length; i++) {
            index = A[i];
            j = i;
            while ((j > 0) && (A[j - 1] > index)) {
                A[j] = A[j - 1];
                j = j - 1;
            }
            A[j] = index;
        }
        return A;
    }
}
