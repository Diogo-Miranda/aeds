public class questao16 {

    public static void main (String[] args)
    {
        int numMult = 0;
        int a  = 2;
        int n = 8;

        for(int i = n-7; i >= 1; i--) {
            for(int j = 0; j < n; j++) {
                a *= 2;
                numMult++;
            }       
        }
        System.out.println(numMult);
    }
}
