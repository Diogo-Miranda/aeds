import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

class Principal
{
    /**
     * isFim(String in)
     * Determinar o fim de uma leitura
     * @param String in - String de entrada
     * @return boolean - retorna se a entrada é igual a "FIM"
     */
    public static boolean isFim(String in)
    {
        return (in.length() >= 3 && in.charAt(0) == 'F' && in.charAt(1) == 'I' && in.charAt(2) == 'M');
    }

    public static void main (String[] args) throws IOException
    {
        Jogador[] jogador = new Jogador[40];
        String entrada[] = new String[41];
        int numEntrada = 0;

        try {
            do {
                entrada[numEntrada] = MyIO.readString();
            } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;

            for(int i = 0; i < numEntrada; i++)
            {
                jogador[i] = new Jogador();
                jogador[i].ler(entrada[i]);
                jogador[i].imprimir();
            }

        } catch (IOException e) {
                System.out.println("##### ERRO : "+e.getMessage());
                e.printStackTrace();   
        }
    }
}
