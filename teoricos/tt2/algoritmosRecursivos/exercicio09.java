class exercicio09 {
    
    public static char toUpper(char c)
    {
        return (c >= 'a' || c <= 'z' ? (char) (c - 32) : c);
    }
    
    public static boolean isVogal(char c)
    {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static int contaVogais(String s, int tam)
    {
        int count = 0;
        if(tam >= 0) {
            if(isVogal(toUpper(s.charAt(tam))))
                count++;
            count += contaVogais(s, tam-1);
        }
        return count;
    }

    public static int contaVogais(String s)
    {
        return contaVogais(s, s.length()-1);
    }

    public static void main (String[] args)
    {
           System.out.println(contaVogais("diogo")) ;
    }
}
