class exercicio02 {
    public static void main (String[] args)
    {
        String nomeArquivo = MyIO.readLine("Informe o nome do arquivo: ");

        Arq.openRead(nomeArquivo + ".txt");

        while(Arq.hasNext()) {
            MyIO.println(Arq.readLine());
        }

        Arq.close();
    }
}
