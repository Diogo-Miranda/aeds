class exercicio01 {

    public static void main (String[] args)
    {
        String nomeArquivo = MyIO.readLine("Informe o nome do arquivio: ");
        String frase = MyIO.readLine("Informe a frase a ser salva nesse arquivo: ");

        Arq.openWrite(nomeArquivo + ".txt");

        Arq.println(frase);

        Arq.close();
    }
}
