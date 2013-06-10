Conjuntos
=========

Operações sobre conjuntos

A API OperaçõesSobreConjuntos foi elaborada por Diego Dias Tainha e Thayso Henrique Capuchinho Camargo com a 
finalidade de facilitar as operações feitas com conjuntos.

A classe OperacoesSobreConjuntos é a classe main do projeto, onde são chamados os métodos que foram implementados em
outras classes.

Abra a classe ***OperacoesSobreConjuntos.java*** e faça como abaixo:

***Exemplo***

    public static void main(String[] args) {

        ArrayList a = new ArrayList();
        a.add(1);
        a.add(7);
        a.add(3);
        a.add(5);
        a.add(10);

        ArrayList b = new ArrayList();
        b.add(1);
        b.add(3);
        b.add(5);
        b.add(7);
        b.add(9);

        System.out.println("\nPertinência:");
        System.out.println("Conjunto 'A' pertence a 'B'?\n" + Pertinencia.Pertence(a, b));
        // o resultado é false
    }
   Como podemos observar, dentro do método main de OperacoesSobreConjuntos declaramos dois ArrayList que representam
   dois conjuntos distintos, chamamos o método que verifica se o primeiro conjunto que foi passado por parâmetro
   pertence ao outro conjunto, logo nesse caso o resultado será false, pois o conjunto A possui um valor que não
   existe no conjunto B.

###Pertinencia

Todo o código descrito no arquivo Pertinencia realiza verificações de entre conjuntos e elementos informando
se tal elemento ou conjunto pertence ao outro conjunto informado. Para utilizar os métodos da classe Pertinencia é 
necessário que se chame a classe e o método informando os valores por parametro, esses irão representar o tipo de 
método que será realizada.

Abra a classe ***OperacoesSobreConjuntos.java*** e faça como abaixo:

***Exemplo***

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(8);
        a.add(2);
        
        ArrayList b = new ArrayList();
        b.add(6);
        b.add(1);
        b.add(10);
        
        if(!Pertinencia.Pertence(a, b))
        {
            JOptionPane.showMessageDialog("O conjunto A não pertence ao conjunto B");
        }
        else{
            JOptionPane.showMessageDialog("O conjunto A pertence ao conjunto B");
            // positivo nesse caso
        }
    }
    
O código descrito a cima realiza a verificação entre os conjuntos e informa se o conjunto A pertence ao conjunto B.

###Continência

Todo o código descrito no arquivo Continencia realiza verificações de entre conjuntos e elementos informando
se tal elemento ou conjunto está contido no outro conjunto informado. Para utilizar os métodos da classe Continencia é 
necessário que se chame a classe e o método informando os valores por parametro, esses irão representar o tipo de 
método que será realizada.

Abra a classe ***OperacoesSobreConjuntos.java*** e faça como abaixo:

***Exemplo***

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(8);
        a.add(2);
        
        ArrayList b = new ArrayList();
        b.add(6);
        b.add(1);
        b.add(10);
        
        System.out.println("\nContinência entre valor e conjunto:");
        System.out.println("Valor valor está no conjutno?\n" + Continencia.estahContido('a', b));
        //neste caso o conjunto não estará contido
    }

###Outras Operações

Todo o código descrito no arquivo OutrasOperacoes realiza verificações entre conjuntos e elementos de acordo com 
o método chamado. Para utilizar os métodos da classe OutrasOperacoes é necessário que se chame a classe e o método
informando os valores por parametro, esses irão representar o tipo de ação que será realizada.
Métodos existentes na classe OutrasOperacoes:

***retorna true caso o conjunto a for igual ao conjunto b e caso contrario retornará false.***

    public static boolean Igualdade(ArrayList a, ArrayList b)

***retorna um Array com todos os elementos de u que são diferentes dos elementos do conjunto a.***

    public static ArrayList Complemento(ArrayList u, ArrayList a)

***retorna um Array com todos os elementos de a que não se encontram no conjunto b.***

    public static ArrayList Diferenca(ArrayList a, ArrayList b)
    
***retorna um Array contendo todos os elemntos dos conjuntos a e b.***

    public static ArrayList Uniao(ArrayList a, ArrayList b)

***retorna um Array contendo todos os elementos do conjunto a que também pertencem ao conjunto b.***

    public static ArrayList Intersecao(ArrayList a, ArrayList b)

    
***retorna a quantidade de elementos existentes no conjunto.***

    public static int Cardinalidade(ArrayList a)
 
***reotrna um Array contendo elementos em tuplas dos conjuntos a e b.***

    public static ArrayList ProdutoCartesiano(ArrayList a, ArrayList b)

Abra a classe ***OperacoesSobreConjuntos.java*** e faça como abaixo:

***Exemplo***
    
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(7);
        a.add(3);

        ArrayList b = new ArrayList();
        b.add(7);
        b.add(9);

        System.out.println("\nProduto Cartesiano:");
        System.out.println(OutrasOperacoes.ProdutoCartesiano(a, b));
        // resultado: <1,7>,<1,9>,<7,7>,<7,9>,<3,7>,<3,9>
    }

###Gerar tipo de uma endorrelação

Contém os métodos para informar os tipos de uma endorrelação, retornando true ou false.
Os métodos estão dentro da classe TipoConjunto.java, então é preciso acessar como mostrado:

***Reflexiva***

        TipoConjunto.ehReflexiva(tam, matriz);
        
***Irreflexiva***

        TipoConjunto.ehIrreflexiva(tam, matriz);

***Simétrica***

        TipoConjunto.ehSimetrica(tam, matriz);
        
***Transitiva***

        TipoConjunto.ehTransitiva(tam, matrizDoConjunto, endorrelacao)
        
Abra a classe ***MatematicaDiscreta.java*** e faça como abaixo:

***Entradas***
        
        ArrayList<SubConjunto> x = new ArrayList<>();                           // cria um array para receber o conjunto
        x.add(new SubConjunto(1, 1));                                           // adiciona o subconjuto: <1,1> no array
        System.out.print("Tipo(s): " + OpSobreConj.GerarTipo(x, conjunto));     //imprime os tipos do conjunto

***Saída***

        Tipo(s): [Simétrica, Transitiva]

###Bucket Sort

O bucket sort é um algoritmo de ordenação desenvolvido para numeros inteiros positivos.
Nele os elementos são inseridos em baldes de acordo com o seu tamanho e são retirados já ordenados utilizando
outro método de ordenação, como por exemplo o Insertion Sort.

Abra a classe ***BucketSort.java*** e faça como abaixo:

***Entrada***

    ArrayList<Integer> conjunto = new ArrayList();
        conjunto.add(1);
        conjunto.add(5);
        conjunto.add(16);
        conjunto.add(6);
        conjunto.add(81);
        conjunto.add(2);
        conjunto.add(7);
        conjunto.add(35);
        conjunto.add(3);
        
        Ordenar.BucketSort(listaPrincipal);
        System.out.println("Conjunto ordenado: " + listaPrincipal);

***Saída***

    Conjunto ordenado: [1, 2, 3, 5, 6, 7, 13, 16, 35, 81]

###Jogo Da Velha

A API mudou de ramo? 
Não trabalha mais com conjuntos?
Não é isso guys! Apenas estamos descontraindo, e para isso desenvolvemos um algoritmo semelhante ao jogo da velha.
Este algoritmo recebe uma determinada posição de jogada e mostra para o usuário todas as demais possibilidades.

***Abra a classe jogo da velha e execute, obs.: digite os dados requisitados na interface.***
Caso não necessite da interface, remova os métodos JOptionpane, e faça como abaixo:

***Entrada***

    String [][] velha = new String[3][3];                       // deaclara a matriz que receberá os dados.
    velha[0][1] = "X";                                          // insere o jogador X na posição determinada.
    
***Saída***

    Jogadas Possíveis para O: 
    [0] [0]
    [0] [2]
    [1] [0]
    [1] [1]
    [1] [2]
    [2] [0]
    [2] [1]
    [2] [2]
