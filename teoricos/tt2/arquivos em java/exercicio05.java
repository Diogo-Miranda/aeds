
/*
 * Autor: Diogo Araujo Miranda
 * Esta classe tem a função de converter o conteúdo de um arquivo em amiúsculo e salvar em outro arquivo
*/
class exercicio05 {
   
    /*
     * Este método tem função de converter um char em maiúsculo
     * @param char c - caractere a ser convertido
     * @return char - retorna um caractere maiusculo
    */
    public static char toUpperChar(char c)
    {
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c;
    }
    
    /*
     * Este método tem função de converter uma String em maiúsculo
     * @param string entrada - string a ser convertida
     * @return string upperString - string maiúsculo
    */
    public static String toUpperString(String entrada)
    {
        String upperString = "";

        for(int i = 0; i < entrada.length(); i++)
        {
            upperString += toUpperChar(entrada.charAt(i));
        }

        return upperString;
    }

    public static void main (String[] args)
    {
        String nomePrimeiroArq = MyIO.readLine();
        Arq primeiroArq = new Arq();
        primeiroArq.openRead(nomePrimeiroArq + ".txt");
        
        String conteudo = "";
        while(primeiroArq.hasNext())
        {
            conteudo = conteudo + toUpperString(primeiroArq.readLine()) + "\n";
        }
        
        primeiroArq.close();
        

        String nomeSegundoArq = MyIO.readLine();
        Arq segundoArq = new Arq();
        segundoArq.openWrite(nomeSegundoArq + ".txt");
        segundoArq.println(conteudo);

        segundoArq.close();
    }
}
