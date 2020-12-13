public class Alvinegra {
    private No raiz;

    public Alvinegra() {
        raiz = null;
    }

    public boolean pesquisar(int elemento) {
        return pesquisar(elemento, raiz);
    }

    public boolean pesquisar(int elemento, No i) {
        boolean resp;

        if(i == null) {
            resp = false;
        } else if (elemento == i.elemento) {
            resp = true;
        } else if (elemento < i.elemento) {
            resp = pesquisar(elemento, i.esq);
        } else {
            resp = pesquisar(elemento, i.dir);
        }

        return resp;
    }

    public void inserir(int elemento) throws Exception {
        // Se a raiz for null, inserir na raiz;
        if(raiz == null) {
            raiz = new No(elemento, false);
            System.out.println("Antes zero elementos. Agora raiz("+raiz.elemento+").");
        
            // Se a arvore tiver apenas um elemento
        } else if (raiz.esq == null && raiz.dir == null) {
            // Se o elemento for maior que a raiz, inserir na esquerda
            if(raiz.elemento > elemento) {
                // Inserir elemento com cor preta
                raiz.esq = new No(elemento, true);
                System.out.println("Antes, um elemento. Agora raiz(" + raiz.elemento + ") e esq("+ raiz.esq.elemento+")");
            // Se o elemento for menor que a raiz, inserir na direita
            } else {
                // Inserir elemento com cor preta
                raiz.dir = new No(elemento, true);
                System.out.println("Antes, um elemento. Agora raiz(" + raiz.elemento + ") e dir("+ raiz.dir.elemento+")");
            }
        // Senão, se árvore tiver dois elementos (raiz e dir)
        } else if (raiz.esq == null) {
            // Se o elemento da raiz for maior 
            if(raiz.elemento > elemento) {
                // Inserir na esquerda
                raiz.esq = new No(elemento);
                System.out.println("Antes, dois elementos na raiz e na direita. Agora raiz(" + raiz.elemento + "), esq(" + raiz.esq.elemento + ") e dir (" + raiz.dir.elemento+").");
            // Se o elemento da raiz, for menor, comparar com o elemento da direita
            } else if (raiz.dir.elemento > elemento) {
                // Rotação dir(pai)-esq(avô) 
                raiz.esq = new No (raiz.elemento);
                raiz.elemento = elemento;
                System.out.println("Antes, dois elementos na raiz e na direita. Rotação dir-esq. raiz(" + raiz.elemento + ")" + " esq (" + raiz.esq.elemento + ")" + "e dir (" + raiz.dir.elemento + ").");
            // Se o elemento na direita da raiz for menor
            } else {
                // Rotação esq
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
                System.out.println("Antes, dois elementos na raiz e na direita. Rotação dir. raiz(" + raiz.elemento + ")" + " esq (" + raiz.esq.elemento + ")" + "e dir (" + raiz.dir.elemento + ").");
            }

            // Cor dos filhos fica branca (juntamente com a raiz)...
            raiz.esq.cor = raiz.dir.cor = false;
        // Senão, se a árvore tiver dois elementos (raiz e esq)
        } else if (raiz.dir == null) {
            // Se o elemento da raiz for menor
            if(raiz.elemento < elemento) {
                // Insere na direita
                raiz.dir = new No(elemento);
                System.out.println("Antes dois elementos, agora raiz(" + raiz.elemento + ") esq(" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ")" ); 
            // Se o elemento da esquerda da raiz for menor
            } else if (raiz.esq.elemento < elemento) {  
                // Rotação esq-dir
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = elemento;
                System.out.println("Antes dois elementos. Rotação esq-dir Agora raiz(" + raiz.elemento + ") esq(" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ")" );
            // Se o elemento da esquerda da raiz for maior 
            } else {
                // Rotação dir
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
                System.out.println("Antes dois elementos. Rotação esq Agora raiz(" + raiz.elemento + ") esq(" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ")" );
            }

            raiz.esq.cor = raiz.dir.cor = false;
        } else {
            System.out.println("Arvore com tres ou mais elementos...");
            inserir(elemento, null, null, null, raiz);
        }
        
        raiz.cor = false;
    }

    private void inserir(int elemento, No bisavo, No avo, No pai, No i) throws Exception {
        if(i == null) {
            if(elemento < pai.elemento) {
                i = pai.esq = new No(elemento, true);
            } else {
                i = pai.dir = new No(elemento, true);
            }

            if(pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            // Quando acha um 4-nó, fragmenta ele
            if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                System.out.println("4-nó entre pai("+i.elemento+"->branco) pai.esq, pai.dir + ("+i.esq.elemento + "," + i.dir.elemento +")->pretos .");
                System.out.println("Agora pai("+i.elemento+"->preto) pai.esq, pai.dir + ("+i.esq.elemento + "," + i.dir.elemento +")->brancos .");
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if(i == raiz) {
                    i.cor = false;
                    System.out.println("Mas pai(" + i.elemento + ")->preta é raiz e sua cor será branca!");
                } else if(pai.cor == true) {
                    // Se o pai e o filho forem pretos
                    balancear(bisavo, avo, pai, i);
                }
            }
            // inserir na esquerda
            if (elemento < i.elemento) {
                inserir(elemento, avo, pai, i, i.esq);
            // Senão, inserir na direita
            } else if(elemento > i.elemento) {
                inserir(elemento, avo, pai, i, i.dir);
            } else {
                throw new Exception ("Erro ao inserir, elemento repetido!");
            }
        }
    }

    private void balancear(No bisavo, No avo, No pai, No i) {
        // Se o pai tambem for preto, deve-se reequilibrar a arvore rotacionando o avo
        if(pai.cor == true) {
            /* 4 Tipos de reequilibrios */

            // Rotação para a esquerda ou direita esquerda
            if (pai.elemento > avo.elemento) {
                avo = rotacaoEsq(avo);
            } else {
                avo = rotacaoDirEsq(avo);
            }
        // Rotacao a direita ou esquerda-direita
        } else {         
            if(i.elemento < pai.elemento) {
                avo = rotacaoDir(avo);
            } else {
                avo = rotacaoEsqDir(avo);
            }
        }

        if(bisavo == null) {
            raiz = avo;
        } else {
            if(avo.elemento < bisavo.elemento) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
        }

        // Reestabelecer as cores apos as rotacoes
        avo.cor = false;
        avo.esq.cor = avo.dir.cor = true;
        System.out.println("Reestabelecer cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir("+avo.esq.elemento + "," + avo.dir.elemento + "->pretos)");
    
    }

    private No rotacaoDir(No no) {
        System.out.println("Rotação DIR(" + no.elemento +")");
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private No rotacaoEsq(No no) {
        System.out.println("Rotacao ESQ(" + no.elemento + ")");
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;
    }

    private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }
    
    private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    public void mostrarPre() {
        System.out.print("[ ");
        mostrarPre(raiz);
        System.out.print("]");
    }

    private void mostrarPre(No i) {
        System.out.println(i.elemento + " ");
        mostrarPre(i.esq);
        mostrarPre(i.dir);
    }
}
