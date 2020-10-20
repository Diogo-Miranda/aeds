class questao28 {

    public static void main (String[] args)
    {
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, x = 0, numSub = 0;
        
        int n = 2;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int m = 0; m < n; m++)
                {
                    for(int k = 0; k < n; k++)
                    {
                        a--;b--;c--;d--;e--;f--;g--;h--;x--;
                        numSub += 9;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                a--;b--;c--;d--;e--;
                numSub += 5;
            }
        }
            

        for(int i = n; i > 1; i /= 2)
        {
            a--;
            numSub++;
        }

        System.out.println(numSub);

        
    }
}
