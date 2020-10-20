class Exemplo01FibonacciRecursivo {
    
    // Calcula Fibonacci até o número informado e imprime em um arquivo fibonacci.txt
    
    public static int fibonacciRecursivo(int i)
    {
        int termo;

        if(i == 1 || i == 0)
        {
            termo = 1;
        } 
        else {
            termo = fibonacciRecursivo(i - 1) + fibonacciRecursivo(i - 2);     
        }

        return termo;
    }

    public static void main (String[] args)
    {
        Arq.openWrite("fibonacci.txt");

        int limite = MyIO.readInt("Informe quantos numeros da sequencia quer salvar: ");
        
        Arq.println("0");
        for(int i = 0; i < limite; i++)
        {
            Arq.println(" " + fibonacciRecursivo(i));
        }       
        
        Arq.close();
        // Mostrar Fibonacci
        Arq.openRead("fibonacci.txt");
        while(Arq.hasNext()) {
            MyIO.println(Arq.readInt());    
        }
        
        Arq.close();
        Arq.openRead("fibonacci.txt");

        // Le e copia pra outro arquivo
        String str = "";
        while(Arq.hasNext()) 
        {
            str = str + Arq.readInt() + "\n";
        }
        Arq.close();

        Arq.openWrite("fibonacciCp.txt");
        Arq.print(str);
        Arq.close();
        
        // Le da copia e print
        MyIO.println("Lendo da copia...");

        Arq.openRead("fibonacciCp.txt");
        while(Arq.hasNext()) {
            MyIO.println(Arq.readInt());
        }
        Arq.close();
    }
}
