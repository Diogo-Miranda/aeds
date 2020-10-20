class questao29 {

    public static void main (String[] args)
    {
        int n = 4;
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int numSub = 0;

        for(int i = n; i > 1; i /= 2)
        {
            a--;
            numSub++;
        }

        for(int i = n; i > 1; i /=2)
        {
            a--;b--;c--;d--;e--;
            numSub += 5;
        }

        System.out.println(numSub);
    }
}
