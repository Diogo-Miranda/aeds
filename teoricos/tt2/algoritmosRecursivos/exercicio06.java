public class exercicio06{

    public static int multiplicar(int x, int y)
    {
        int resp = x;

        if(y > 1) {
            resp = resp + multiplicar(x, y-1);
        } else {
            resp = x;
        }
        System.out.println(resp);
        return resp;
    }

    public static void main (String[] args)
    {
        System.out.println("5 x 13 = "+ multiplicar(5,13) );
    }

}
