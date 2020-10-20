import java.io.*;

class ExemploRAFfibonacci {
    
    public static int fibonacci(int i)
    {
        int termo; 

        if(i == 1 || i == 0)
        {
            termo = 1;
        } else {
            termo = fibonacci(i - 1) + fibonacci(i - 2);
        }

        return termo;
    }

    public static void main (String[] args) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile("fibonacci.txt", "rw");
        
        int quantidadeTermos = MyIO.readInt("Informe a quantidade de termos fibonacci: ");
        
        raf.writeInt(0);
        for(int i = 0; i < quantidadeTermos; i++)
        {
            raf.writeInt(fibonacci(i));
        }

        raf.close();
        
        raf = new RandomAccessFile("fibonacci.txt", "r");
        
        RandomAccessFile rafcp = new RandomAccessFile("fibonaccicp.txt", "rw");

        int posSeek = 0;
        raf.seek(posSeek);
        
        
        try
        {
            while(true)
            {
                raf.seek(posSeek);
                rafcp.writeInt(raf.readInt());
                posSeek += 4; // Anda 1 int por vez
            }        
        }
        catch (EOFException e)
        {
            
        }
        finally
        {
           rafcp.close();
           raf.close();
        }    
        
        // Mostrar o conteúdo da cópia e o original: 
        
        raf = new RandomAccessFile("fibonacci.txt", "r");
        rafcp = new RandomAccessFile("fibonaccicp.txt", "r");
        
        posSeek = 0;
        raf.seek(posSeek);
        try 
        {
            while(true)
            {
                MyIO.println(raf.readInt());
                posSeek += 4;
                raf.seek(posSeek);
            }
        }    
        catch (EOFException e)
        {

        }
        finally
        {
            raf.close();
            rafcp.close();
        } 
    }
}
