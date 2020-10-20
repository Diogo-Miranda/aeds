class questao26 {

    public static void main (String[] args)
    {
        int a = 0;
        int n = 5;
        int numSub = 0;

        for(int i = 1; i < n; i *= 2)
        {
            numSub++;
            a--;
        }

        for(int i = 0; i < n; i++) 
        {
            numSub++;
            a--;
        }

        System.out.println(numSub);
    }
}
