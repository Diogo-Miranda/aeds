class exercicio08_1 {
    
    public static boolean isPalindromo(String s) {
        return isPalindromo(s, 0);
    }

    public static boolean isPalindromo(String s, int i){
        boolean resp;
        System.out.println(".");
        if (i >= s.length() / 2) {
            resp = true; 
        } else if (s.charAt(i) != s.charAt(s.length()- 1 - i))
        {
            resp = false;
        } else {
            resp = isPalindromo(s, i + 1);
        }

        return resp;
    }

    public static void main (String[] args)
    {
        System.out.println(isPalindromo("ala"));
    }
}
