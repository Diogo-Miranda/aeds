class ordenacaSelecao {

    public static void swap(int[] array, int menor, int i)
    {
        int aux = array[i];
        array[i] = array[menor];
        array[menor] = aux;
    } 

    public static void main (String[] args)
    {
        int[] array = {101, 115, 30, 63, 47, 20};
        for(int i = 0; i < array.length; i++)
        {
            MyIO.print(array[i] + " ");
        }
        int mov = 0;

        int n = array.length;
        int menor;
        for(int i = 0; i < n-1; i++)
        {
             menor = i;
             for(int j = i+1; j < n; j++)
             {
                 if(array[menor] > array[j])
                     menor = j;
                 MyIO.println("Menor em i = "+i + " "+ array[menor]);
             }
             swap(array, menor, i);
             mov += 3;
        }
    
        for(int i = 0; i < array.length; i++)
        {
            MyIO.print(array[i] + " ");
        }          

        MyIO.println("Num mov =" + mov);
    }
}
