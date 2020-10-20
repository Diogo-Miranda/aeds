class questao1 {
    
    public static boolean estaContido(int array[],int num)
    {
        boolean contem = false;
        
        int i = 0;
        for(; i < array.length; i++)        
        {
            if(array[i] == num) 
            {             
                contem = true;
                i = array.length;
            }
        } 

        return contem;
    }

    public static void main (String[] args)
    {
        int[] array = {1,2,3,4,5};
        int num = 0;

        boolean contem = estaContido(array, num);
        System.out.println(contem);
    }
}
