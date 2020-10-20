class exercicio07 {
    
    public static int determinarMaior(int[] array, int tam)
    {
        int maior;

        if(tam > 0)
        {
            maior = determinarMaior(array, tam-1);
            if(array[tam] > maior)
                maior = array[tam];
        } else {
            maior = array[tam];
        }

        return maior;
    }

    public static int determinarMaior(int[] array)
    {
        return determinarMaior(array, array.length-1);
    }

    public static void main (String[] args)
    {
        int[] array = {1, 6, 7, 20, 2, 50, 1, 0, 100, 102, 2};
        System.out.println("Maior = "+ determinarMaior(array));
    }
}
