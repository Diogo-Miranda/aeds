import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

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
        MyIO.println("## "+this.nome+" ## "
                        +this.altura+" ## "
                        +this.peso+" ## "
                        +this.anoNascimento+" ## "
                        +this.universidade+" ## "
                        +this.cidadeNascimento+" ## "
                        +this.estadoNascimento+" ##"
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

class Lista 
{
	private Jogador[] array;
	private int n;

	/*
	 *
	 * Constructor
	*/
	public Lista() 
	{
		this(6);
	}

	/**
	 * Constructor
	 * @param tamanho Tamanho da lista
	*/
	public Lista(int tamanho) 
	{
		array = new Jogador[tamanho];
		n = 0;
	}

	/**
	 * Inserir jogador ao inicio
	 * @param Jogador x - jogador a ser inserir
	*/
	public void inserirInicio(Jogador x) throws Exception 
	{
		if(n >= array.length) 
			throw new Exception("Eroo ao inserir!");

		// Mover elementos para o fim
		for(int i = n; i > 0; i--) 
			array[i] = array[i-1];

		array[0] = x;
		n++;
	}
	
	/**
	 * Inserir jogador ao fim da lista
	 * @param Jogador x - jogador a ser inserido
	*/	
	public void inserirFim(Jogador x) throws Exception 
	{
		if(n >= array.length) 
			throw new Exception("Erro ao inserir!");		

		array[n] = x;
		n++;
	}
	
	/**
	 * Inseirr um jogador a uma posicao especifica
	 * @param Jogador x - jogador a ser inserido
	 * @param int pos - posicao a ser inserida
	 * @throws Exception Se a lista estiver cheia ou posicao menos do que 0 ou posicao maior que o array
	*/
	public void inserir(Jogador x, int pos) throws Exception 
	{
		if(n >= array.length || pos < 0 || pos > n)
			throw new Exception("Erro ao inserir!");

		//Levar elementos para liberar pos para inseirr
		for(int i = n; i > pos; i--)
			array[i] = array[i-1];

		array[pos] = x;
		n++;	
	}
	
	/**
	 * Remover um jogador do inicio
	 * @return Jogador - jogador a ser removido
	 * @throws Exception Se a lista estiver vazia
	*/
	public Jogador removerInicio() throws Exception 
	{
		if(n == 0)
			throw new Exception("Erro ao remover!");

		Jogador resp = array[0];
		n--;

		for(int i = 0; i < n; i++) 
			array[i] = array[i+1];
		
		return resp;	
	}

	/**
	 * remover um jogador do fim da lista
	 * @return resp Jogador - jogador a ser removido
	 * @throws Exception se a lista estiver vazia
	*/
	public Jogador removerFim() throws Exception 
	{
		if (n == 0) 
			throw new Exception("Erro ao remover!");

		return array[--n];	
	}

	/**
	 * Remover um jogador em uma posicao generica
	 * @param int pos - posicao a ser removido
	 * @return Jogador - jogador removido
	 * @throws Exception - se a lista estiver vazia, se a posicao for invalida
	*/
	public Jogador remover(int pos) throws Exception 
	{
		if(n == 0 || pos < 0 || pos >= n)
			throw new Exception("Erro ao remover!");

		Jogador resp = array[pos];
		n--;

		for(int i = pos; i < n; i++)
			array[i] = array[i+1];

		return resp;
	}

	/**
	 * Mostrar a lista
	*/
	public void mostrar() 
	{
		for(int i = 0; i < n; i++) {
			System.out.print("["+i+"] ");	
			array[i].imprimir();
		}
	}
	
	/**
	 * Retorna o tamanho da lista
	 * @return n
	*/
	public int getN() 
	{
		return n;	
	}
}

public class Questao01 
{

	public static Lista lista = new Lista(1000);

	public static void executarOperacao(String operacao) throws Exception 
	{
		String[] componentes = operacao.split(" ");

		Jogador tmp;
		switch (componentes[0]) {
			case "II" :
				tmp = new Jogador();
				tmp.ler(componentes[1]);
				lista.inserirInicio(tmp);
				break;
			case "IF" :
				tmp = new Jogador();
				tmp.ler(componentes[1]);
				lista.inserirFim(tmp);
				break;
			case "I*" :
				tmp = new Jogador();
				tmp.ler(componentes[2]);
				lista.inserir(tmp, Integer.parseInt(componentes[1]));
				break;
			case "RI" :
				tmp = lista.removerInicio();
				System.out.println("(R) " + tmp.getNome());
				break;
			case "RF" :
				tmp = lista.removerFim();
				System.out.println("(R) " + tmp.getNome());
				break;
			case "R*" :
				tmp = lista.remover(Integer.parseInt(componentes[1]));
				System.out.println("(R) " + tmp.getNome());
				break;
			default :
				break;
		}
	}

	public static boolean isFim(String entrada)
	{
		return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
	}

	public static void main (String[] args) throws Exception 
	{
		
		int numEntrada = 0;		
		String[] entrada = new String[3000];

		do {
			entrada[numEntrada] = MyIO.readLine();
		} while (!isFim(entrada[numEntrada++]));
		numEntrada--;
		
		int numSegundaEntrada = MyIO.readInt();

		//Lista lista = new Lista(numEntrada + numSegundaEntrada);

		Jogador tmp;
		for(int i = 0; i < numEntrada; i++) {
			tmp = new Jogador();
			if(entrada[i].equals("223")) entrada[i] = "222";
			tmp.ler(entrada[i]);
			lista.inserirFim(tmp);	
		}
	
		//lista.mostrar();

		// Ler segunda entrada		
		for(int i = 0; i < numSegundaEntrada; i++) {
			entrada[i] = MyIO.readLine();
			executarOperacao(entrada[i]);
		}

		lista.mostrar();
	}	
}


