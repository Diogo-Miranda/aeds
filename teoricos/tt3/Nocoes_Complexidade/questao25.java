class questao25 {

    public static void main (String[] args)
    {
        // 5n + 4n³
        
        int i = 0;
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        
        int numSub = 0;
            
        int n = 2;

        while(i < n)
        {
            i++;
            a--;b--;c--;d--;e--;
            numSub += 5;
        }

        for(i = 0; i < n; i++) 
        {
            for(int j = 0; j < n; j++)
            {
                for(int m = 0; m < n; m++)
                {
                    a--;b--;c--;d--;
                    numSub += 4;
                }
            }
        }

        System.out.println(numSub);
    }
}
