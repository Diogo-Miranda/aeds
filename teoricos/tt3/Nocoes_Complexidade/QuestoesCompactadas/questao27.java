class questao27 {

    public static void main (String[] args)
    {
        int a = 0, b = 0;
        int numSub = 0;
        
        int n = 2;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int m = 0; m < n; m++)
                {
                    a--;b--;
                    numSub++;
                }       
            }
        }
            
        numSub *= 2;   

        for(int i = 0; i < 5; i++)
        {
            numSub++;
            a--;
        }

        System.out.println(numSub);
    }
}
