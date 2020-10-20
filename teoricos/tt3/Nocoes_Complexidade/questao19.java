class questao19 {

    public static void main (String[] args)
    {
        int n = 8;
        int a = 2;
        int numMult = 0;

        for(int i = n-7; i >= 1; i--)
        {
            for(int j = n - 7; j >= 1; j--)
            {
                a *= 2;
                numMult++;
            }
        }

        System.out.println(numMult);
    }
}
