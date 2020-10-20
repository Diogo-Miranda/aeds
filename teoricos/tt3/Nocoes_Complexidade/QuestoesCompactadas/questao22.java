public class questao22 {

    public static void main (String[] args)
    {
        int n = 4;
        int a = 2;

        int numMult = 0;

        for(int i = n; i > 1; i /= 2)
        { 
            a *= 2;
            numMult++;
        }

        System.out.println(numMult);
    }
}
