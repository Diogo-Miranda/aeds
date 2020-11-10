import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Date;

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
        MyIO.println("["+this.id +" ## "
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

class Cedula 
{
	public Jogador jogador;
	public Cedula prox;
	public Cedula ant;
	public int indice;

	Cedula(Jogador jogador, int indice)
	{
		this.jogador = jogador;
		this.prox = null;
		this.ant = null;
		this.indice = indice;
	}
}

class ListaDupla 
{
	public Cedula primeiro;
	public Cedula ultimo;
	public int qntIndice;

	ListaDupla()
	{
		Jogador cabeca = new Jogador();
		this.primeiro = new Cedula(cabeca, -1);
		this.ultimo = primeiro;
		int qntIndice = 0;
	}	

	public void inserirInicio(Jogador jogador) 
	{
		int indice = qntIndice++;
		Cedula nova = new Cedula(jogador, indice);
		nova.prox = primeiro.prox;
		primeiro.prox = nova;
		nova.ant = primeiro;

		if(primeiro == ultimo) {
			ultimo = nova;
		} else {
			nova.prox.ant = nova;
		}	
	}

	public void inserirFim(Jogador jogador)
	{
		int indice = qntIndice++;
		Cedula nova = new Cedula(jogador, indice);
		ultimo.prox = nova;
		nova.ant = ultimo;
		ultimo = nova;
	}

	public void mostrar() 
	{
		for(Cedula aux = primeiro.prox; aux != ultimo.prox; aux = aux.prox)
			aux.jogador.imprimir();
	}
}

public class Questao11
{
	public static int NUM_COMP = 0;
	public static int NUM_MOV = 0;

	public static boolean isFim(String entrada)
	{
		return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
	}

	public static long now() 
	{
		return new Date().getTime();
	}

	public static Jogador getPivo(Cedula esq, Cedula dir)
	{
		Cedula resp = esq;

		int meio = (esq.indice+dir.indice) / 2;

		while(resp.indice != meio)
			resp = resp.prox;

		return resp.jogador;
	}

	public static boolean comparar(Jogador tmp, Jogador atual) 
	{
		boolean resp = false;
	
		NUM_COMP++;
		if(tmp.getEstadoNascimento().equals(atual.getEstadoNascimento())) {
			NUM_COMP++;
			resp = tmp.getNome().compareTo(atual.getNome()) > 0;
		} else {
			NUM_COMP++;
			resp = tmp.getEstadoNascimento().compareTo(atual.getEstadoNascimento()) > 0;
		}

		return resp;
	}

	public static void swap(Cedula i, Cedula j)
	{
		Jogador aux = i.jogador.clone();
		NUM_MOV++;
		i.jogador = j.jogador.clone();
		NUM_MOV++;
		j.jogador = aux.clone();
		NUM_MOV++;
	}

	public static void quicksort(Cedula esq, Cedula dir) 
	{
		Cedula i = esq;
		Cedula j = dir;

		Jogador pivo = getPivo(esq, dir);
	
		while(i.indice <= j.indice) {
			while(comparar(pivo, i.jogador)) i = i.prox;
			while(comparar(j.jogador, pivo)) j = j.ant;
			
			if(i.indice <= j.indice) {
				swap(i, j);
				i = i.prox; j = j.ant;
			}
		}
	
		if(j.indice > esq.indice) quicksort(esq, j);
		if(dir.indice > i.indice) quicksort(i, dir);
	}

	public static void quicksort(ListaDupla listaDupla)
	{
		quicksort(listaDupla.primeiro.prox, listaDupla.ultimo);
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
		
		ListaDupla listaDupla = new ListaDupla();

		Jogador tmp;
		for(int i = 0; i < numEntrada; i++) {
			tmp = new Jogador();
			if(entrada[i].equals("223")) entrada[i] = "222";
			tmp.ler(entrada[i]);
			listaDupla.inserirFim(tmp);	
		}
	
		FileWriter fw = new FileWriter("705657_quicksort2.txt");
		BufferedWriter log = new BufferedWriter(fw);

		double inicio;
		double fim;

		inicio = now();

		quicksort(listaDupla);

		fim = now();

		double total = (fim-inicio)/1000.0;

		log.write("705657\t"+total+"\t"+NUM_COMP+"\t"+NUM_MOV);
		log.close();

		listaDupla.mostrar();
	}	
}
