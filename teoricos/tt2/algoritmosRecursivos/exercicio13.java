class exercicio13 {
    
    public static int T(int n)
    {
        int resp = 0;
        
        if(n == 0)
        {     
            resp = 1;
        } else {
            resp = T(n-1) * T(n-1);
        }

        return resp;
    }

    public static void main (String[] args)
    {
        System.out.println("T(n) = "+ T(5));
    }
} 
