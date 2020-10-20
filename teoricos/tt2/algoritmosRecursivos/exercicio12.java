class exercicio12 {
    
    public static int T(int n)
    {
        int resp = 0;

        if(n == 0) {
            resp = 1;
        } else if(n == 1) {
            resp = 2;
        } else {
            resp = T(n-1)*T(n-2)-T(n-1);
        }
        
        return resp;
    }
    
    public static void main (String[] args)
    {
        System.out.println("T(2) = " + T(30));
    }
}
