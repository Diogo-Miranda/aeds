class exercicio06 {
    
    public static String inverterString(String s)
    {
        String stringInvertida = "";
        int finalString = s.length() - 1;
        for(int i = 0; i < s.length(); i++)
        { 
            stringInvertida += s.charAt(finalString - i); //Decrementando
        }
        
        return stringInvertida;
    }

    public static void main (String[] args)
    {
        String nomePrimeiroArq = MyIO.readLine();
        Arq primeiroArq = new Arq();
        primeiroArq.openRead(nomePrimeiroArq + ".txt");
            
        String conteudo = "";
        while(primeiroArq.hasNext())
        {   
            conteudo = conteudo + inverterString(primeiroArq.readLine()) + "\n";
        }
        
        primeiroArq.close();        
    
        String nomeSegundoArq = MyIO.readLine();
        Arq segundoArq = new Arq();
        segundoArq.openWrite(nomeSegundoArq + ".txt");
        
        segundoArq.println(conteudo);
        
        segundoArq.close();
    }       
}
