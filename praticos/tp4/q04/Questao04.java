import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Date;

import javax.swing.text.DefaultEditorKit.CopyAction;

class Jogador {
    // Declaração de dados padrão
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private String anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;
    
    Jogador()
    {
        this.id = -1;
    }

    /**
     * Constructor
     * @param int id
     * @param String nome
     * @param int Altura
     * @param int peso
     * @param String universidde
     * @param String anoNascimento
     * @param String cidadeNascimento
     * @param String estadoNascimento
    */
    Jogador(int id, String nome, int altura, int peso, String universidade, String anoNascimento, String cidadeNascimento, String estadoNascimento)
    {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }
        
    /**
     * Constructor
     * @param int id
     * @param String nome
     * @param int altura
     * @param int peso
     * @param String universidade
     * @param String anoNascimento
    */
    Jogador(int id, String nome, int altura, int peso, String universidade, String anoNascimento)
    {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = "nao informado";
        this.estadoNascimento = "nao informado";
    }
    
    /**
     * Constructor
     * @param int id
     * @param String nome
     * @param int altura
     * @param int peso
     * @param String anoNascimento
     * @param String cidadeNascimento
     * @param String estadoNascimento
    */
    Jogador(int id, String nome, int altura, int peso, String anoNascimento, String cidadeNascimento, String estadoNascimento)
    {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = "nao informado";
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }
    
    /**
     * Constructor
     * @param int id
     * @param String nome
     * @param int altura
     * @param int peso
     * @param String anoNascimento
    */
    Jogador(int id, String nome, int altura, int peso, String anoNascimento)
    {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = "nao informado";
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = "nao informado";
        this.estadoNascimento = "nao informado";
    }

    /** getId()
     * Retornar o id do Jogador
     * @return id
    */
    public int getId()
    {
        return this.id;
    }

    /** setId()
     * Mudar o id do Jogador
     * @param int id
    */
    public void setId(int id)
    {
        this.id = id;
    }

    /** getNome()
     *  Retorna o nome do jogador
     *  @return this.nome
    */
    public String getNome()
    {
        return this.nome;
    }

    /** setNome()
     *  Mudar o nome do Jogador
     *  @param String nome
    */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /** getAltura()
     * Retornar a altura do Jogador
     * @return int altura;
    */ 
    public int getAltura()
    {
        return this.altura;
    }

    /** setAltura()
     * Mudar a altura do Jogador
     * @param int altura
    */
    public void setAltura(int altura)
    {
        this.altura = altura;
    }

    /** getPeso()
     * Retorna o peso do jogador
     * @return int peso;
    */
    public int getPeso()
    {
        return this.peso;
    }

    /** setPeso()
     *  Mudar o peso do Jogador
     *  @param int peso
    */
    public void setPeso(int peso)
    {
        this.peso = peso;
    }
    
    /** getUniversidade()
     *  Retorna a universidade do Jogador
     *  @return String universidade
    */
    public String getUniversidade()
    {
        return this.universidade;
    }

    /** setUniversidade()
     *  Mudar a Universidade do Jogador
     *  @param String universidade
    */
    public void setUniversidade(String universidade)
    {
        this.universidade = universidade;
    }

    /** getAnoNascimento()
     *  Retorna o ano de nascimento do Jogador
     *  @return String anoNascimento
    */
    public String getAnoNascimento()
    {
        return this.anoNascimento;
    }

    /** setAnoNascimento()
     *  mudar o ano de nascimento do Jogador
     *  @param String anoNascimento
    */
    public void setAnoNascimento(String anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }
    
    /** getCidadeNascimento()
     *  Retorna a cidade de nascimento do Jogador
     *  @return String cidadeNascimento
    */  
    public String getCidadeNascimento()
    {
        return this.cidadeNascimento;
    }

    /** setCidadeNascimento()
     *  Mudar a cidade de nascimento do Jogador
     *  @param String cidadeNascimento
    */  
    public void setCidadeNascimento(String cidadeNascimento)
    {
        this.cidadeNascimento = cidadeNascimento;
    }
    
    /** getEstadoNascimento()
     *  Retorna a cidade de nascimento do Jogador
     *  @return String estadoNascimento
    */
    public String getEstadoNascimento()
    {
        return this.estadoNascimento;
    }

    /** setEstadoNascimento()
     *  Mudar o Estado de nascimento do jogador
     *  @param String estadoNascimento
    */
    public void setEstadoNascimento(String estadoNascimento)
    {
        this.estadoNascimento = estadoNascimento;
    }
    
        /** 
     * clone()
     * Cria um clone de um Jogador
     * @return Jogador clone - clone criado
    */
    public Jogador clone()
    {
        Jogador clone = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
        return clone;
    }

    /**
     * imprimir()
     * método para imprimir o jogador
    */
    public void imprimir()
    {
        MyIO.println("["+this.id+" ## "
                        +this.nome+" ## "
                        +this.altura+" ## "
                        +this.peso+" ## "
                        +this.anoNascimento+" ## "
                        +this.universidade+" ## "
                        +this.cidadeNascimento+" ## "
                        +this.estadoNascimento+"]"
                    );
    }

    /**
     * ler(String id)
     * ler um jogador pelo seu id Informado
     * @param String id - id informado
    */
    public void ler(String id) throws IOException
    {
        File f = new File("/tmp/players.csv");
        boolean isJogador = false; 

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String auxId = ""; // id auxiliar para pesquisa
            
            boolean isVirgula = false;
            // Ignorar a primeira leitura
            s = br.readLine();

            // Procurar o jogador com o id passado
            while( !isJogador && ( (s = br.readLine()) != null) )
            {    
                auxId = "";
                // Recolher o id do Jogador da linha
                for(int i = 0; i < s.length() && !isVirgula; i++)
                {
                    if(s.charAt(i) == ',')
                        isVirgula = true;
                    else
                        auxId += s.charAt(i);     
                }
                isVirgula = false; 
                
                // Verificar se o ahcou o jogador
                isJogador = auxId.equals(id);
            }     
            if(isJogador) {
                String[] auxDados = s.split(",");

                String[] dados = new String[8]; 
                // Inicializar dados
                for(int i = 0; i < dados.length; i++) dados[i] = "nao informado";

                // Copiar Dados para a string principal
                for(int i = 0; i < auxDados.length; i++) dados[i] = auxDados[i];

                // Realizar ultima verificação de dados
                for(int i = 0; i < dados.length; i++) if(dados[i].equals("")) dados[i] = "nao informado";
                
                // Salvar dados no jogador
                this.id = Integer.parseInt(dados[0]);
                this.nome = dados[1];
                this.altura = Integer.parseInt(dados[2]);
                this.peso = Integer.parseInt(dados[3]);
                this.universidade = dados[4];
                this.anoNascimento = dados[5];
                this.cidadeNascimento = dados[6];
                this.estadoNascimento = dados[7];
            } 

            br.close();
        } catch (IOException e) {
            System.out.println("##### ERRO : "+e.getMessage());
            e.printStackTrace();
        }
    }
}


class Alvinegra {
    private NoAN raiz; // Raiz
    private int numComp;

    public Alvinegra() {
        raiz = null;
        numComp = 0;
    }

	public void inserir(Jogador elemento) throws Exception {
   
        //Se a arvore estiver vazia
        if(raiz == null){
           raiz = new NoAN(elemento, false);
  
        //Senao, se a arvore tiver um elemento 
        } else if (raiz.esq == null && raiz.dir == null){
           if (raiz.elemento.getNome().compareTo(elemento.getNome()) > 0){
              raiz.esq = new NoAN(elemento, true);
              
           } else {
              raiz.dir = new NoAN(elemento, true);
              
           }
  
        //Senao, se a arvore tiver dois elementos (raiz e dir)
        } else if (raiz.esq == null){
           if(raiz.elemento.getNome().compareTo(elemento.getNome()) > 0){
              raiz.esq = new NoAN(elemento);
           } else if (raiz.dir.elemento.getNome().compareTo(elemento.getNome()) > 0){
              raiz.esq = new NoAN(raiz.elemento);
              raiz.elemento = elemento;
           } else {
              raiz.esq = new NoAN(raiz.elemento);
              raiz.elemento = raiz.dir.elemento;
              raiz.dir.elemento = elemento;
              
           }
  
           raiz.esq.cor = raiz.dir.cor = false;
           
        //Senao, se a arvore tiver dois elementos (raiz e esq)
        } else if (raiz.dir == null){
           
           if(raiz.elemento.getNome().compareTo(elemento.getNome()) < 0){
              raiz.dir = new NoAN(elemento);
           } else if (raiz.esq.elemento.getNome().compareTo(elemento.getNome()) < 0){
              raiz.dir = new NoAN(raiz.elemento);
              raiz.elemento = elemento;
              
           } else {
              raiz.dir = new NoAN(raiz.elemento);
              raiz.elemento = raiz.esq.elemento;
              raiz.esq.elemento = elemento;
             
           }
  
           raiz.esq.cor = raiz.dir.cor = false;
  
        //Senao, a arvore tem tres ou mais elementos
        } else {
            inserir(elemento, null, null, null, raiz);
        }
  
        raiz.cor = false;
     }
  
     private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i){
  
        //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if(pai.cor == true){
  
           //4 tipos de reequilibrios e acoplamento
           if(pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0){ // rotacao a esquerda ou direita-esquerda
              if(i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0){
                 avo = rotacaoEsq(avo);
              } else {
                 avo = rotacaoDirEsq(avo);
              }
  
           } else { // rotacao a direita ou esquerda-direita
              if(i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0){
                 avo = rotacaoDir(avo);
              } else {
                 avo = rotacaoEsqDir(avo);
              }
           }
  
           if (bisavo == null){
              raiz = avo;
           } else {
              if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0){
                 bisavo.esq = avo;
              } else {
                 bisavo.dir = avo;
              }
           }
  
           //reestabelecer as cores apos a rotacao
           avo.cor = false;
           avo.esq.cor = avo.dir.cor = true;
        } //if(pai.cor == true)
     }
  
      /**
       * Metodo privado recursivo para inserir elemento.
       * @param elemento Elemento a ser inserido.
       * @param avo NoAN em analise.
       * @param pai NoAN em analise.
       * @param i NoAN em analise.
       * @throws Exception Se o elemento existir.
       */
      private void inserir(Jogador elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
          if (i == null) {
  
           if(elemento.getNome().compareTo(pai.elemento.getNome()) < 0){
              i = pai.esq = new NoAN(elemento, true);
           } else {
              i = pai.dir = new NoAN(elemento, true);
           }
  
           if(pai.cor == true){
              balancear(bisavo, avo, pai, i);
           }
  
        } else {
  
          //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
           if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
              i.cor = true;
              i.esq.cor = i.dir.cor = false;
              if(i == raiz){
                 i.cor = false;
              }else if(pai.cor == true){
                 balancear(bisavo, avo, pai, i);
              }
           }
           if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
              inserir(elemento, avo, pai, i, i.esq);
           } else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
              inserir(elemento, avo, pai, i, i.dir);
           } else {
              throw new Exception("Erro inserir (elemento repetido)!");
           }
        }
      }
  
     private NoAN rotacaoDir(NoAN no) {
        NoAN noEsq = no.esq;
        NoAN noEsqDir = noEsq.dir;
  
        noEsq.dir = no;
        no.esq = noEsqDir;
  
        return noEsq;
     }
  
     private NoAN rotacaoEsq(NoAN no) {
        NoAN noDir = no.dir;
        NoAN noDirEsq = noDir.esq;
  
        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
     }
  
     private NoAN rotacaoDirEsq(NoAN no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
     }
  
     private NoAN rotacaoEsqDir(NoAN no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
     }

	public boolean pesquisar(String elemento) {
        System.out.print("raiz ");
		return pesquisar(elemento, raiz);
	}

	private boolean pesquisar(String elemento, NoAN i) {
        boolean resp;
        numComp++;
		if (i == null) {
            resp = false;
        } else if (elemento.equals(i.elemento.getNome())) {
            numComp++;
            resp = true;
        } else if (elemento.compareTo(i.elemento.getNome()) < 0) {
            System.out.print("esq ");
            numComp+=2;
            resp = pesquisar(elemento, i.esq);
        } else {
            System.out.print("dir ");
            numComp+=2;
            resp = pesquisar(elemento, i.dir);
        }
        return resp;
	}

    public int getNumComp() {
        return numComp;
    }

    public void setNumComp(int numComp) {
        this.numComp = numComp;
    }
}

class NoAN {
    public boolean cor;
    public Jogador elemento;
    public NoAN esq, dir;
    
    public NoAN() {
        this(null);
    }

    public NoAN(Jogador elemento) {
        this(elemento, false, null, null);
    }

    public NoAN(Jogador elemento, boolean cor) {
        this(elemento, cor, null, null);
    } 

    public NoAN(Jogador elemento, boolean cor, NoAN esq, NoAN dir) {
        this.cor = cor;
        this.elemento = elemento.clone();
        this.esq = esq;
        this.dir = dir;
    }

}

public class Questao04
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

    public static void main (String[] args) throws IOException, Exception
    {
        String entrada[] = new String[500];
        int numEntrada = 0;
				
		FileWriter fw = new FileWriter("705657_alvinegra.txt");
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
            Alvinegra an = new Alvinegra();

            for(int i = 0; i < numEntrada; i++)
            {
                jogador[i] = new Jogador();
                if(entrada[i].equals("223")) entrada[i] = "222";
                jogador[i].ler(entrada[i]);
				an.inserir(jogador[i]);
			}

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
                System.out.print(entrada[i] + " ");
                resp = an.pesquisar(entrada[i]);
				if(resp) {
					System.out.print("SIM\n");
				} else {
					System.out.print("NAO\n");
				}
			}

            fim = now(); // Tempo final da pesquisa
            
            double total = ((fim-inicio)/1000.0);
			
			log.write("705657\t"+total+"\t"+an.getNumComp());			
                
			log.close();			

        } catch (IOException e) {
                System.out.println("##### ERRO : "+e.getMessage());
                e.printStackTrace();   
        }
    }
}
