class Consoante {
    
    public static char toUpper(char c)
    {
        return (c >= 'a' && c <= 'z') ? ((char)(c-32)) : c;
    }

    public static boolean isVogal(char c) 
    {
        c = toUpper(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static boolean isNaN(char c) 
    {
        return c < '0' || c > '9';
    }

    public static void mostra(boolean resp)
    {
        if(resp) {
            System.out.println("Consoante");
        } else
        {
            System.out.println("Vogal");
        }
    }

    public static boolean isConsoante(String s, int n)
    {
        boolean resp = true;
        if(n == (s.length()) - 1)
        {
            if(isNaN(s.charAt(n)))
            {
                if(isVogal(s.charAt(n))) 
                {
                    resp = false;
                }
            }
        } else {
            resp = isConsoante(s, n+1);
            mostra(resp);
        }
        return resp;
    }

    public static void main (String[] args)
    {
        String s = "Diogo";
        boolean resp = isConsoante(s, 0);
       
    }
}
