class exercicio11 {
    
    public static void swap(int[] array, int menor, int i)
    {
        int aux = array[i];
        array[i] = array[menor];
        array[menor] = aux;
    }

    // bubblesort recursivo
    public static void ordernar(int[] array, int i, int j, int menor) // i começa em 0
    {
        if(i < (array.length - 1)) // O Ultimo elemento não precisa ser testado
        {
            if(j < array.length)
            {
                if(array[menor] > array[j])
                    menor = j;
                ordernar(array, i, j+1, menor);
            }else {
                swap(array, menor, i);
                ordernar(array, i+1, i+2, i+1); // (array, i+1, j = (i + 1), menor = i)
            }
        }
    }

    public static void ordernar(int[] array)
    {
        ordernar(array, 0, 1, 0);  // ordenar(array, i, i+1, menor = i)
    }

    public static void main (String[] args)
    {
        int[] array = {1,4,1,0};
        ordernar(array);
        
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
