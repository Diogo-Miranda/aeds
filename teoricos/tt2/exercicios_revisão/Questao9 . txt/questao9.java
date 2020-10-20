class questao9 {

    public static void main (String[] args)
    {
        int x = 23, y = 23;
        System.out.println("Valor: " + x);
        System.out.println("Valor em binario: " + Integer.toBinaryString(x));
        x = x >> 1;
        System.out.println("Valor: "+ x);
        System.out.println("Valor em binario: " + Integer.toBinaryString(x));
        
        System.out.println("Valor: "+ y);
        System.out.println("Valor em binario: " + Integer.toBinaryString(y));
        y = y << 1;
        System.out.println("Valor: "+ y);
        System.out.println("Valor em binario: "+ Integer.toBinaryString(y));
    }

}
