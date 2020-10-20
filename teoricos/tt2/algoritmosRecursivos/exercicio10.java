class exercicio10 {
    
    public static boolean isUpperLetter(char c)
    {
        return (c >=  'A' && c <= 'Z');
    }

    public static boolean isConsoante(char c)
    {
        return !(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') && isUpperLetter(c);
    }
    
    public static boolean isVogal(char c)
    {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    
    public static int counterNotVogalConsoante(String s, int i) 
    {
        int count = 0;

        if(i >= 0)
        {
            if(!isVogal(s.charAt(i)) && !isConsoante(s.charAt(i)))
                count++;
            count += counterNotVogalConsoante(s, i-1);
        }

        return count;
    }

    public static int counterNotVogalConsoante(String s)
    {
        return counterNotVogalConsoante(s, s.length() - 1);
    }

    public static void main (String[] args)
    {
        System.out.println(counterNotVogalConsoante("DIOGO ARAUJO MIRANDA05") );
    }
}
