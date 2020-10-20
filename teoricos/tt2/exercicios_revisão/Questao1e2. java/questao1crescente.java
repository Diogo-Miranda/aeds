class questao1crescente {
    
    public static boolean estaContido(int array[], int num)
    {
        boolean contem = false;
        
        // Levando em consideração que todos os números estão de forma crescendo na array
        int i = 0;
        for(;i < array.length/2; i++)
        {
            if(num == array[i]) 
            {   
                contem = true;
                i = array.length;
            } else {
                if(num > array[i])
                {
                    int j = array.length/2;
                    for(; j < array.length; i++)
                    {
                        if(num == array[j]);
                        j = array.length;
                    }
                }
            }
        
        }

        return contem;
    }

    public static void main (String[] args)
    {
        int array[] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int num = 0;
        boolean contem = estaContido(array, num);
        System.out.println(contem);
        
    }
}
