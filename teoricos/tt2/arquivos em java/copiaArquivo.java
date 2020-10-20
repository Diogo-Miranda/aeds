class copiaArquivo {
    
    public static void main (String[] args)
    {
        Arq.openWrite("original.txt");

        for(int i = 0; i < 10; i++)
        {
            Arq.println("oi");
        }

        Arq.close();

        Arq.openRead("original.txt");
        String str = "";
        while(Arq.hasNext())
        {
            str = str + Arq.readLine() + "\n";
        }

        Arq.close();

        Arq.openWrite("copia.txt");
        Arq.print(str);
        Arq.close();
    }

}
