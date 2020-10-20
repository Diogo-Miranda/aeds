
import java.util.*;

/*
 *
 * Esta classe tem a função de ler um Arquivo e copiar para outro arquivo
*/
class exercicio04 {

    public static void main (String[] args)
    {
        String nomePrimeiroArq = MyIO.readLine("Informe o nome do primeiro arquivo: ");
        Arq arq = new Arq();
        arq.openRead(nomePrimeiroArq + ".txt");
        
        String nomeSegundoArq = MyIO.readLine("Informe o nome do segundo arquivo: ");
                
        String conteudo = "";
        while(arq.hasNext())
        {
           conteudo = conteudo + arq.readLine() + "\n";      
        }
        
        arq.close();

        Arq segundoArq = new Arq();
        segundoArq.openWrite(nomeSegundoArq + ".txt");
        segundoArq.println(conteudo); 

        //arq.close();
        segundoArq.close();
        
   }
}
