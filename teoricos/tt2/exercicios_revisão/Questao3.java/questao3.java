class questao3 {    

    public static void mostraMaiorEMenor(int array[])
    {  
           int menor = array[0];
           int maior = 0;
   
           for(int i = 0; i < array.length; i++)
           {
               if(array[i] < menor) menor = array[i];
               if(array[i] > maior) maior = array[i];
           }
   
           System.out.println(maior);
           System.out.println(menor);
    }   
   
       public static void main (String[] args) {
           int array[] = {1,2,3,4,5,6,7,8,9,10};
           mostraMaiorEMenor(array); 
       }           
   
}
