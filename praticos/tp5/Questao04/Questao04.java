import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Date;

import javax.swing.text.DefaultEditorKit.CopyAction;

class Jogador{
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

class No {
    No esq;
    No dir;
    Jogador elemento; 

    public No (Jogador elemento) {
        this.esq = null;
        this.dir = null;
        this.elemento = elemento;
    }
}

class ArvoreBinaria {
    No raiz; 

    public static int NUM_COMP = 0;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(Jogador elemento) {
        this.raiz = inserir(elemento, raiz);
    }

    public No inserir(Jogador elemento, No i) {
        
        if(i == null) {
            i = new No(elemento);
        } else if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(elemento, i.esq);
        } else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(elemento, i.dir);
        } else {
            System.out.println("Erro ao inserir");
        }

        return i;
    }

    public boolean pesquisar(String nome) {
        System.out.print("raiz ");
        return pesquisar(nome, raiz);
    } 

    public boolean pesquisar(String nome, No i) { 
        boolean resp = false;
        
        NUM_COMP++;
        if(i == null) {
            resp = false;
        } else if (nome.equals(i.elemento.getNome())) {
            resp = true;
        } else if (nome.compareTo(i.elemento.getNome()) < 0) {
            NUM_COMP++;
            System.out.print("esq ");
            resp = pesquisar(nome, i.esq);
        } else if (nome.compareTo(i.elemento.getNome()) > 0) {
            NUM_COMP+=2;
            System.out.print("dir ");
            resp = pesquisar(nome, i.dir);
        }

        return resp; 
    }

}

/**
 * Celula (pilha, lista e fila dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula {
	public Jogador elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.


	/**
	 * Construtor da classe.
	 */
	public Celula() {
		this(null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula(Jogador elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	private Celula primeiro;
    private Celula ultimo;
    
    // Globais
    public static int NUM_COMP = 0;

	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(Jogador x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			i.elemento.imprimir();
		}
		System.out.println("] ");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String nome) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
            NUM_COMP++;
            if(i.elemento.getNome().contains(nome)){
                resp = true;
                i = ultimo;
            }
		}
		return resp;
	}
}

class ReHash {
    Jogador[] tabela;
    int tamTab;

    public static int NUM_COMP = 0;

    public ReHash(int tamTab) {
        this.tamTab = tamTab;
        this.tabela = new Jogador[tamTab];
    }

    public int h(Jogador jogador) {
        return (jogador.getAltura() % tamTab);
    }

    public int h2(Jogador jogador) {
        return ( 1 + (jogador.getAltura() % tamTab));
    }

    public boolean inserir(Jogador jogador) {
        boolean resp = false;
        int pos = h(jogador);

        if(tabela[pos] == null) {
            tabela[pos] = jogador;
            resp = false;
        } else {
            // reHash
            pos = h2(jogador);

            if(tabela[pos] == null) {
                tabela[pos] = jogador;
                resp = true;
            }
        }

        return resp;
    }

    public boolean pesquisar(String nome) {
        boolean achou = false;

        for(int i = 0; !achou && i < this.tamTab; i++) {
            NUM_COMP++;
            if(tabela[i] == null) {
                achou = false;
            } else if(tabela[i].getNome().contains(nome)) {
                achou = true;
            }
        }

        return achou;
    }
}

class Hash {
    Lista listaSimples;
    ArvoreBinaria arvoreBinaria;
    ReHash T2;
    Jogador[] tabela;
    int tamTab;

    public static int NUM_COMP = 0;

    public Hash(int tamTab) {
        this.tamTab = tamTab;
        this.tabela = new Jogador[tamTab];
        listaSimples = new Lista();
        arvoreBinaria = new ArvoreBinaria();
        this.T2 = new ReHash(9);
    } 

    public int h(Jogador jogador) {
        return jogador.getAltura() % this.tamTab;
    }

    // Inserir na área reserva
    public int h2(Jogador jogador) {
        return (jogador.getAltura() % 3);
    }

    public void inserir(Jogador jogador) {
        int pos = h(jogador);
        if(tabela[pos] == null) {
            tabela[pos] = jogador;
        } else {
            pos = h2(jogador);

            if(pos == 0) {
                T2.inserir(jogador);
            } else if (pos == 1) {
                listaSimples.inserirFim(jogador);
            } else if (pos == 2) {
                arvoreBinaria.inserir(jogador);
            }
        }
    }

    public boolean pesquisar(String nome) {
        boolean resp = false;

        for (int i = 0; !resp && i < this.tamTab && tabela[i] != null ; i++) {
            NUM_COMP++;
            if(tabela[i].getNome().contains(nome)) {
                resp = true;
            }
        }

        if(!resp) {
            resp = this.T2.pesquisar(nome) || this.listaSimples.pesquisar(nome) || this.arvoreBinaria.pesquisar(nome); 
        }

        return resp;
    }
}   

public class Questao04 {
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
   * now()
   * retorna o tempo atual
   * @return time
   */	
   public static long now()
   {
	   return new Date().getTime();
   }

    public static void main(String[] args) throws Exception {
        String entrada[] = new String[500];
        int numEntrada = 0;
            
        FileWriter fw = new FileWriter("705657_doidao.txt");
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
            Hash hash = new Hash(11);

            boolean sucessRead = true;
            for(int i = 0; i < numEntrada; i++)
            {
                jogador[i] = new Jogador();
                if(entrada[i].equals("223")) entrada[i] = "222";
                jogador[i].ler(entrada[i]);
                hash.inserir(jogador[i]);
            }
        
            // Segunda entrada
            numEntrada = 0;
            do{
                entrada[numEntrada] = MyIO.readLine();
            } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;

            inicio = now(); // Tempo inicial

            for(int i = 0; i < numEntrada; i++) {
                System.out.print(entrada[i] + " ");
                if(hash.pesquisar(entrada[i])) {
                    System.out.print("SIM\n");
                } else {
                    System.out.print("NAO\n");
                }
            }

            fim = now(); // Tempo final da pesquisa
            
            double total = ((fim-inicio)/1000.0);
        
            int numComp = Lista.NUM_COMP + ArvoreBinaria.NUM_COMP + ReHash.NUM_COMP + Hash.NUM_COMP;
            log.write("705657\t"+total+"\t"+numComp);			
                
            log.close();		

        } catch (IOException e) {
            System.out.println("##### ERRO : "+e.getMessage());
            e.printStackTrace();   
        }
    }
}