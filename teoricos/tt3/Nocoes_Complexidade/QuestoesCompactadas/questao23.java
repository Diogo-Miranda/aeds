class questao23 {

    public static void main (String[] args)
    {
        int n = 5;
        int a = 2;

        int numMult = 0;

        for(int i = 1; i < n; i*=2)
        {
            a *= 2;
            numMult++;
        }
            
        System.out.println(numMult);
    }
}
