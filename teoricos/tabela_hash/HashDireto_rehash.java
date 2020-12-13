class ReHash {
    int elemento;
    int[] tabela; 
    int m; // Tamanho total da tabela
    int NULL = -1;
    
    public ReHash() {
        this(13);
    }

    public ReHash(int m) {
        this.m = m;
        tabela = new int[this.m];

        for(int i = 0; i < m; i++) {
            tabela[i] = NULL;
        }
    }

    /**
     * Função de transformação da tabela Hash
     * @param elemento
     * @return
     */
    public int h(int elemento) {
        return elemento % this.m;
    }

    /**
     * Função de transformação da reHash
     * @param elemento
     * @return
     */
    public int h2(int elemento) {
        return ++elemento % this.m;
    } 

    /**
     * Método para inserir na tabela Hash
     * @param elemento
     * @return
     */
    public boolean inserir(int elemento) {
        int pos = h(elemento); // pos = h(elemento) 
        boolean resp = false;  // Resposta que define o sucesos da inserção

        // Se o elemento não for NULO (-1)
        if(elemento != NULL) {
            // Se a posição do hash estiver livre
            if(tabela[pos] == NULL) {
                tabela[pos] = elemento;
                resp = true;
            } else {
                // Se não, realizar o rehash
                pos = h2(elemento);

                // Tentativa de inserção da área de reHash
                if(tabela[pos] == NULL) {
                    tabela[pos] = elemento;
                    resp = true;
                } else {
                    resp = false;
                }
            }
        }

        return resp;
    }

    public void mostrar() {
        System.out.print("{ ");
        for(int i = 0; i < m; i++) {
            System.out.print("[" + i + "/" + tabela[i] + "] ");
        }
        System.out.print("}\n");
    }

    public boolean remover(int elemento) {
        boolean resp = false;
        int pos = h(elemento);

        if(elemento != NULL) {
            if(tabela[pos] == elemento) {
                // Verificar se existe algum elemento na área de reHash
                int auxPos = h2(elemento);
                if(tabela[auxPos] != NULL) {
                    tabela[pos] = tabela[auxPos];
                    tabela[auxPos] = NULL;
                } else {
                    tabela[pos] = NULL;
                }
                resp = true;
            } else {
                pos = h2(elemento);

                if(tabela[pos] == elemento) {
                    tabela[pos] = NULL;
                    resp = true;
                }
            }
        }

        return resp;
    }

    public boolean pesquisar(int elemento) {
        boolean resp = false;

        int pos = h(elemento);

        if(elemento != NULL) {
            if(tabela[pos] == elemento) {
                resp = true;
            } else {
                pos = h2(elemento);

                if(tabela[pos] == elemento) {
                    resp = true;
                }
            }
        }

        return resp;
    }
}

public class HashDireto_rehash {

    public static void main (String[] args) {
        ReHash reHash = new ReHash(6);

        System.out.println("Inserção = " + reHash.inserir(3));
        System.out.println("Inserção = " + reHash.inserir(3));
        System.out.println("Inserção = " + reHash.inserir(7));
        reHash.mostrar();
        /*System.out.println("Inserção = " + reHash.inserir(3));
        System.out.println("Inserção = " + reHash.inserir(3));
        System.out.println("Inserção = " + reHash.inserir(2));
        System.out.println("Inserção = " + reHash.inserir(2));
        System.out.println("Inserção = " + reHash.inserir(7));*/
        System.out.println("Remoção  = " + reHash.remover(3));
        reHash.mostrar();
        System.out.println("Remoção  = " + reHash.remover(3));
        System.out.println("Pesquisar = " + reHash.pesquisar(7));
    }
}