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
