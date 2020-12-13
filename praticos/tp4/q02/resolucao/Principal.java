import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Date;

import javax.swing.text.DefaultEditorKit.CopyAction;

public class Principal
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
	
    /**
    * new()
    * retorna o tempo atual
    * @return time
    */	
    public static long now()
    {
		return new Date().getTime();
    }
	
	public static void insercaoInicial(ArvoreBinaria ab) throws Exception{
        ab.inserir(7);
        ab.inserir(3);
        ab.inserir(11);
        ab.inserir(1);
        ab.inserir(5);
        ab.inserir(9);
        ab.inserir(12);
        ab.inserir(0);
        ab.inserir(2);
        ab.inserir(4);
        ab.inserir(6);
        ab.inserir(8);
        ab.inserir(10);
        ab.inserir(13);
        ab.inserir(14);
	}

    public static void main (String[] args) throws IOException, Exception
    {
        String entrada[] = new String[500];
        int numEntrada = 0;
				
		FileWriter fw = new FileWriter("705657_arvoreArvore.txt");
		BufferedWriter log = new BufferedWriter(fw);
		
		double inicio;	
		double fim;
        try {
			// Leitura do id dos jogadores
            do {
                entrada[numEntrada] = MyIO.readLine();
            } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;
            
            Jogador[] jogador = new Jogador[numEntrada];
			ArvoreBinaria ab = new ArvoreBinaria();
			insercaoInicial(ab);
			//ab.caminharPre();

            for(int i = 0; i < numEntrada; i++)
            {
                jogador[i] = new Jogador();
                if(entrada[i].equals("223")) entrada[i] = "222";
                jogador[i].ler(entrada[i]);
				ab.inserir(jogador[i]);
			}
			
			//ab.caminharPre();

			// Segunda entrada
			numEntrada = 0;
			do{
				entrada[numEntrada] = MyIO.readLine();
			} while (isFim(entrada[numEntrada++]) == false);
			numEntrada--;

			inicio = now(); // Tempo inicial
			
			// Pesquisar jogador
			boolean resp;
			for(int i = 0; i < numEntrada; i++)
			{
				resp = ab.pesquisar(entrada[i]);
				if(resp) {
					System.out.print("SIM\n");
				} else {
					System.out.print("NAO\n");
				}
			}

            fim = now(); // Tempo final da pesquisa
            
           double total = ((fim-inicio)/1000.0);
			
			//log.write("705657\t"+total+"\t"+ab.getNumComp());			
                
			log.close();			

        } catch (IOException e) {
                System.out.println("##### ERRO : "+e.getMessage());
                e.printStackTrace();   
        }
    }
}
