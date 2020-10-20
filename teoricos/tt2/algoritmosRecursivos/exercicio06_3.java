class exercicio06_3 {

    public static int multiplicacao(int a, int b, int i)
    {
        int resp = 0;
        if (i < b) {
            resp = a + multiplicacao(a, b, i+1);
        }
        return resp;
    }

    public static int multiplicacao(int a, int b)
    {
        return multiplicacao(a, b, 0);
    }

    public static void main (String[] args)
    {
        System.out.println(multiplicacao(4, 3));
    }
}
