class SomatorioPA {
    
    public static double somatorioPA(double a, double b, int n )
    {
        return ( ((2*a + b*n )*(n+1)) / 2);
    }
    
    public static void main (String[] args)
    {
        double a = (double)(args[0]);
        double b = (double)(args[1]);
        int n = Integer.parseInt(args[2]);

        System.out.println("Somatorio PA = "+ somatorioPA(a, b, n));
    }

}
