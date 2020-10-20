class exercicio03 {
    
    public static char toUpper(char c)
    {
        if(c >= 'a' && c <='z') // Verifica se ta minúsculo
        {
            c = (char)(c-32);
        }

        return c;
    }

    public static String tratarString(String s)
    {
        String upperString = "";

        for(int i = 0; i < s.length(); i++)
        {
            upperString += toUpper(s.charAt(i));
        }

        return upperString;
    }

    public static void main (String[] args)
    {
        String nomeArquivo = MyIO.readLine("Informe o nome do arquivo: ");

        Arq.openRead(nomeArquivo + ".txt");

        while(Arq.hasNext())
        {
            MyIO.println(tratarString(Arq.readLine()));
        }

        Arq.close();
    }
}
