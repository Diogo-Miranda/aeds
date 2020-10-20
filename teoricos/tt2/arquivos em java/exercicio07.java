
/*
 *
 * Esta classe tem a função de codificar uma entrada a partir
 * do ciframento de César e também decifra-la
*/
class exercicio07 {
    
    /*
     * Este método tem função de decifrar um caractere
     * @param char c - caractere a ser decifrado
     * @return char - caractere decifrado
    */
    public static char decifrarChar(char c)
    {
        return (char)(c - 3);
    }
    
    /*
     * Este método tem função de decifrar uma string
     * @param String s - string a ser decifrada
     * @return String stringDecifrada - string após decifrar
    */
    public static String decifrarString(String s)
    {
        String stringDecifrada = "";

        for(int i = 0; i < s.length(); i++)
        {
            stringDecifrada += decifrarChar(s.charAt(i));
        }

        return stringDecifrada;
    }
    
    /*
     * Este método tem função de cifrrar um caractere
     * @param char c - caractere a ser cifrado
     * @return char - caractere decifrad
    */
    public static char cifrarChar(char c)
    {
        return (char)(c + 3); 
    }
    
    /*
     * Este método tem função de cifrar uma String
     * @param String s - string a ser cifrada
     * @return stringCifrada - string cifrada
    */
    public static String cifrarString(String s)
    {
        String stringCifrada = "";

        for(int i = 0; i < s.length(); i++)
        {
            stringCifrada += cifrarChar(s.charAt(i));
        }

        return stringCifrada;
    }   

    public static void main (String[] args)
    {
        String nomePrimeiroArq = MyIO.readLine();
        Arq primeiroArq = new Arq();

        primeiroArq.openRead(nomePrimeiroArq + ".txt");
        
        String conteudo = "";
        while(primeiroArq.hasNext())
        {
            conteudo = conteudo + cifrarString(primeiroArq.readLine()) + "\n";
        }
        MyIO.println("Cifrando...");
        MyIO.println(conteudo);
        
        primeiroArq.close();
        
        String nomeSegundoArq = MyIO.readLine();
        Arq segundoArq = new Arq();

        segundoArq.openWrite(nomeSegundoArq + ".txt");
        
        MyIO.println("Salvado...");
        segundoArq.println(conteudo);
        
        segundoArq.close();
        
        segundoArq.openRead(nomeSegundoArq + ".txt");

        conteudo = "";
        while(segundoArq.hasNext())
        {
            conteudo = conteudo + decifrarString(primeiroArq.readLine()) + "\n"; 
        }
        
        MyIO.println("Decifrando...");
        MyIO.println(conteudo);

        primeiroArq.close();
    }
}
