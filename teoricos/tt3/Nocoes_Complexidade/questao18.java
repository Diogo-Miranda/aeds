class questao18 {

    public static void main (String[] args)
    {
        int n = 2;
        int a = 2;
        int numMult = 0;

        for(int i = n+4; i > 0; i >>= 1)
        { 
            a *= 2;
            numMult++;
        }

        System.out.println(numMult);
    }
}
