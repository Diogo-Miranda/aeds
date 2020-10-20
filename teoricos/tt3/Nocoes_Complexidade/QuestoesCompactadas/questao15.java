public class questao15
{

    public static void main (String[] args)
    {
        int numMult = 0;
        int n = 4;
        int a = 2;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n-3; j++)
            {
                a *= 2;
                numMult++;
            }
        }
        System.out.println(numMult);
    }
}
