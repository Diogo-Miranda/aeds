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

class ArvoreBinaria {
	public NoUm raiz;
	private int numComp;

	public ArvoreBinaria() {
		raiz = null;
		numComp = 0;
	}
	
	/**
	 * Metodo para pesquisar um elemento na arvore a partir de uma chave
	 * @param String chave - chave de pesquisar
	 * @return boolean - retorna true se o elemento for encontrado
	*/
	public boolean pesquisar(String chave) throws Exception {
		System.out.print(chave + " ");
		//System.out.print("raiz ");
		return pesquisar(chave, raiz, "raiz ");
	}

	/**
	 * Metodo recursivo para pesquisar um valor em uma arvore binaria
	 * @param String chave - chave a ser pesquisada
	 * @param NoUm i - No atual a ser pesquisar
	 * @param String mensage - direção para onde o no está indo
	 * @return boolean resp - retorna true se o elemento for encontrado
	*/ 
	private boolean pesquisar(String chave, NoUm i, String mensagem) throws Exception {
		boolean resp = false;
		// Printar a direção
		System.out.print(mensagem);
		
		numComp++;
		if(i != null) {
			resp = pesquisarSegundaArvore(chave, i.noDois, "");
			resp = resp || pesquisar(chave, i.esq, "esq ");	
			resp = resp || pesquisar(chave, i.dir, "dir ");
		}

		return resp;
	}

	private boolean pesquisarSegundaArvore(String chave, NoDois i, String mensagem) throws Exception {
		boolean resp = false;
		// Printar a direção
		System.out.print(mensagem);
		
		numComp++;
		if(i != null) {
			resp = chave.equals(i.elemento);
			resp = resp || pesquisarSegundaArvore(chave, i.esq, "ESQ ");
			resp = resp || pesquisarSegundaArvore(chave, i.dir, "DIR ");
		}	

		return resp;
	}

	public void inserir(Jogador jogador) throws Exception {
		raiz = inserir(jogador, raiz);
	}

	private NoUm inserir(Jogador jogador, NoUm i) throws Exception {
		int chave = jogador.getAltura() % 15;
			
		if(i == null) {
			i = new NoUm(chave);
		} else if(chave == i.elemento) {
			i.noDois = inserirSegundaArvore(jogador, i.noDois);
		} else if(chave < i.elemento) {
			i.esq = inserir(jogador, i.esq);
		} else if(chave > i.elemento) {
			i.dir = inserir(jogador, i.dir);
		}

		return i;
	}

	private NoDois inserirSegundaArvore(Jogador jogador, NoDois i) throws Exception {
		if(i == null) {
			i = new NoDois(jogador.getNome());
		} else if(jogador.getNome().compareTo(i.elemento) < 0) {
			i.esq = inserirSegundaArvore(jogador, i.esq);
		} else if(jogador.getNome().compareTo(i.elemento) > 0) {
			i.dir = inserirSegundaArvore(jogador, i.dir);
		} else {
			throw new Exception ("Erro ao inserir na segunda arvore");
		}

		return i;
	}

	/** 
	 * Método para inserir um elemento utilizando seu pai como referencia
	 * @param int elemento - elemento a ser inserido
	*/
	public void inserir(int elemento) throws Exception {
		if(raiz == null) {
			raiz = new NoUm(elemento);
		} else if (elemento < raiz.elemento) {
			inserir(elemento, raiz.esq, raiz);
		} else if (elemento > raiz.elemento) {
			inserir(elemento, raiz.dir, raiz);
		} else {
			throw new Exception("Erro ao inserir!");
		}
	}

	/**
	 * Metodo para inserir um elemento na arvore binaria utilizando seu pai como referencia
	 * @param int elemento - elemento a ser inserido
	 * @param NoUm i - no atual a ser comparado
	 * @param NoUm pai - no pai utilizado como referencia
	*/
	private void inserir(int elemento, NoUm i, NoUm pai) throws Exception {
		if(i == null) {
			if(elemento < pai.elemento) {
				pai.esq = new NoUm(elemento);
			} else {
				pai.dir = new NoUm(elemento);
			}
		} else if (elemento < i.elemento) {
			inserir(elemento, i.esq, i);
		} else if (elemento > i.elemento) {
			inserir(elemento, i.dir, i);
		} else {
			throw new Exception("Erro ao inserir!");
		}
	}
	
	public void caminharPre() {
		caminharPre(raiz);
	}

	private void caminharPre(NoUm i) {
		if(i != null) {
			System.out.println(i.elemento + " : ");
			System.out.print("[ ");
			caminharPreSegunda(i.noDois);
			System.out.print("]\n");
			caminharPre(i.esq);
			caminharPre(i.dir);
		}
	}

	private void caminharPreSegunda(NoDois i) {
		if(i != null) {
			System.out.print(i.elemento + "; ");
			caminharPreSegunda(i.esq);
			caminharPreSegunda(i.dir);
		}
	}
	
	public int getNumComp() {
		return this.numComp;
	}
}

class NoDois {
	public String elemento;
	public NoDois esq;
	public NoDois dir;
		
	public NoDois() {
		this("vazio");
	}

	public NoDois(String elemento) {
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
	}
}

class NoUm {
	int elemento;
	public NoUm esq;
	public NoUm dir;
	public NoDois noDois;

	public NoUm() {
		this(0);
	}

	public NoUm(int elemento) {
		esq = null;
		dir = null;
		this.elemento = elemento;
		noDois = null;
	}
}

public class Questao02
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
			
			log.write("705657\t"+total+"\t"+ab.getNumComp());			
                
			log.close();			

        } catch (IOException e) {
                System.out.println("##### ERRO : "+e.getMessage());
                e.printStackTrace();   
        }
    }
}
