import java.util.Formatter;

class exercicio14 {

    public static int hanoi(int i, char origem, char destino, char auxiliar)
    {
        int qntMov = 1;

        if(i == 1) { //Quando chega no primeiro disco
            System.out.printf("%nMover disco %d de %c para %c", i, origem, destino);
        } else {
            qntMov += hanoi(i-1, origem, auxiliar, destino);
            System.out.printf("%nMover disco %d de %c para %c",i, origem, destino);
            qntMov += hanoi(i-1, auxiliar, destino, origem);
        }

        return qntMov;
    }

    public static int hanoi(int n)
    {
        return hanoi(n, 'A', 'B', 'C');
    }

    public static void main (String[] args)
    {
        System.out.println("\nQuantidade de movimentos = "+ hanoi(3));
    }


}
