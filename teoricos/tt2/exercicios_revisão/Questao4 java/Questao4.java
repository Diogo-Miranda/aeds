class Questao4 {
    
    public static void MostraMaiorEMenorArray(int maior, int menor)
    {
        System.out.println(maior);
        System.out.println(menor);
    }

    // Realiza ao todo 9 comparações !!!
    public static void MaiorEMenorArray(int array[])
    {
        int menor = array[0];
        int maior = array[1];
        
        if(menor > maior) 
        {   
            menor = array[1];
            maior = array[0];
        }

        for(int i = 2; i < array.length; i++)
        {
            if(array[i] < menor) menor = array[i];
                else maior = array[i];   
        }

        MostraMaiorEMenorArray(maior, menor);
    }

    public static void main (String[] args)
    {   
        int array[] = {1,2,3,4,5,6,7,8,9,10};
        MaiorEMenorArray(array);
    }
}
