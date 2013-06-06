package bucketsort;

import java.util.ArrayList;

public class BucketSort {

    public static void main(String[] args) {
        ArrayList<Integer> listaPrincipal = new ArrayList();
        listaPrincipal.add(1);
        listaPrincipal.add(5);
        listaPrincipal.add(16);
        listaPrincipal.add(6);
        listaPrincipal.add(81);
        listaPrincipal.add(2);
        listaPrincipal.add(7);
        listaPrincipal.add(35);
        listaPrincipal.add(3);
        listaPrincipal.add(13);


        Ordenar.BucketSort(listaPrincipal);

        System.out.println("Conjunto ordenado: " + listaPrincipal);
    }
}
