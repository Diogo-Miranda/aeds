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
     * efetuaLeitura(String s, int i)
     * Ler um dado específico na String informada
     * @param String s - string de entrada
     * @param int i - posição de leitura na string
     * @return String out - dado lido na String
    */
    private String efetuaLeitura(String s, int i)
    {
        String out = "";
        while(i < s.length() && s.charAt(i) != ',')
        {
            out += s.charAt(i);
            i++;
        }
        return out;
    }

    /**
     * ler(String id)
     * ler um jogador pelo seu id Informado
     * @param String id - id informado
    */
    public void ler(String id) throws IOException
    {
        File f = new File("/tmp/players.csv");

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            
            String auxId = ""; // id auxiliar para pesquisa
            boolean isJogador = false; 
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
                    {
                        auxId += s.charAt(i); 
                    }       
                }
                isVirgula = false; 
                
                // Verificar se o ahcou o jogador
                isJogador = auxId.equals(id);
            }     

            // String para guardar valores temp
            String auxString = "";
            // Verifica qual nível de leitura do dado o código está
            int flag = 0; 
            // Criar o jogador
            for(int i = 0; i < s.length(); i++) 
            {
                // Efetua a leitura do dado
                auxString = efetuaLeitura(s, i);
                
                // Verifica qual dado esta entrando pela flag
                switch (flag) {
                // Leitura do Id
                case 0 :
                    // Mudar a posicao do i na String
                    i += auxString.length();
                    // Muda a flag para o nome;
                    flag = 1;
                    // Atribuir o Id
                    this.id = Integer.parseInt(auxString);
                    break;
                // Leitura do nome
                case 1 :
                    i += auxString.length();
                    // Muda a flag para a altura
                    flag = 2;
                    this.nome = auxString;
                    break; 
                // Leitura da altura
                case 2 :
                    i += auxString.length();
                    // Muda a flag para o peso
                    flag = 3;
                    this.altura = Integer.parseInt(auxString);
                    break;
                // Leitura do Peso
                case 3 : 
                    i += auxString.length();
                    // Muda a flag para a faculdade
                    flag = 4;
                    this.peso = Integer.parseInt(auxString);
                    break;
                // Leitura da faculdade
                case 4 :
                    i += auxString.length();
                    // Muda a flag para leitura do ano de nascimento
                    flag = 5;
                    if(auxString == "") 
                        this.universidade = "nao informado";
                    else 
                        this.universidade = auxString;

                    break;
                case 5 :
                    i += auxString.length();
                    // Muda a flag para a leitura da cidade de nascimento
                    flag = 6;
                    this.anoNascimento = auxString;
                    break;
                case 6 :
                    i += auxString.length();
                    // Muda a flag para a leitura do estado de nascimento
                    flag = 7;
                    if(auxString == "")
                        this.cidadeNascimento = "nao informado";
                    else
                        this.cidadeNascimento = auxString;

                    break;
                case 7 :
                    i += auxString.length();
                    // Muda a flag para o fim da leitura
                    flag = 8;
                    if(auxString == "")
                        this.estadoNascimento = "nao informado";
                    else
                        this.estadoNascimento = auxString;
                    break;
                default :
                    
                    break;
                    
                }    
            }
            
            // Verificar se o ultimo dado foi lido
            if(this.estadoNascimento == null)
            {
                this.estadoNascimento = "nao informado";
            }

            br.close();
        } catch (IOException e) {
            System.out.println("##### ERRO : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

class Q1
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
