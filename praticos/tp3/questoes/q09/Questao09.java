class Celula {
    public Celula prox;
    public Celula ant;
    public Celula sup;
    public Celula inf;
    public int elemento;

    public Celula() {
        this(0);
    }
    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.ant = null;
        this.sup = null;
        this.inf = null;
    }
}
class MatrizFlexivel {
    public int numLinha;
    public int numColuna;
    public Celula inicio;

    // Construtor da Matriz
    public MatrizFlexivel(int numLinha, int numColuna) {
        this.numLinha = numLinha;
        this.numColuna = numColuna;
        this.inicio = new Celula();

        // Gerar primeira Linha
        Celula tmp = inicio;
        for(int i = 1; i < numColuna; i++) {
            Celula nova = new Celula();
            tmp.prox = nova;
            nova.ant = tmp;
            tmp = tmp.prox;
        }
        tmp = null;

        // Gerar restante das Linhas
        Celula ref = inicio;
        for(int i = 0; i < numLinha; i++) {
            // Percorrer a linha anterior
            Celula atual = ref; // Auxiliar para percorrer linha anterior
            for(int j = 0; j < numColuna; j++) {
                Celula nova = new Celula();

                // Ponteiro superior
                nova.sup = atual;

                // Verificar se está na borda esquerda
                if(atual.ant != null) {
                    nova.ant = atual.ant.inf; // Pega o anterior do inferior da linha superior
                    atual.ant.inf.prox = nova; // O próximo do anterior aponta para a linha nova
                }

                atual.inf = nova;
                
                // Mudar coluna de referência
                if(atual.prox != null) { // Verificar se ta na borda direita
                    atual = atual.prox;
                }
            }
            // Mudar para a proxima linha de referência
            ref = ref.inf;  
        }
    }

    public void inserir(int numLinha, int numColuna, int elemento) throws Exception {
        if(numLinha < 0 || numLinha > this.numLinha || numColuna < 0 || numColuna > this.numColuna) {
            throw new Exception ("ERRO");
        }

        Celula ref = inicio;
        Celula atual = ref;
        // CAminhar até a celula a ser inserido o valor
        for(int i = 0; i <= numLinha; i++) {
            atual = ref;
            for(int j = 0; j < numColuna; j++) {
                if(atual.prox != null) {
                    atual = atual.prox;
                }
            }
            ref = ref.inf;
        }

        // Inserir o valor
        atual.elemento = elemento;
        atual = null;
        ref = null;
    }

    public int[] getDiagonalPri() {
        int[] diagonalPrincipal = new int[numLinha];             
        
        // Percorrer Matriz
        Celula ref = inicio;
        for(int i = 0; i < numLinha; i++) {
            // Salvar Diagonal Principal
            diagonalPrincipal[i] = ref.elemento;
            if(ref.prox != null) 
                ref = ref.prox.inf;
        }

        return diagonalPrincipal;
    }

    public int[] getDiagonalSec() {
        int[] diagonalSecundaria = new int[numLinha];

        // Percorrer matriz
        Celula ref;
        // Ir para o fim da primeira linha
        for(ref = inicio; ref.prox != null; ref = ref.prox);

        // Pegar a diagonal propriamente dita
        for(int i = 0; i < numLinha; i++) {
            // Salvar diagonal secundaria
            diagonalSecundaria[i] = ref.elemento;
            if(ref.ant != null)
                ref = ref.ant.inf;
        }
        
        return diagonalSecundaria;
    }

    public static MatrizFlexivel somar(MatrizFlexivel primeiraMatriz, MatrizFlexivel segundaMatriz) throws Exception {

        if(!MatrizFlexivel.hasMesmoTamanho(primeiraMatriz, segundaMatriz)) {
            throw new Exception ("Matrizes não possuem o mesmo tamanho!");
        }

        MatrizFlexivel matrizSoma = new MatrizFlexivel(primeiraMatriz.numLinha, primeiraMatriz.numColuna);

        // Percorrer as matrizes
        Celula primeiraRef = primeiraMatriz.inicio;
        Celula segundaRef = segundaMatriz.inicio;
        Celula primeiraAtual;
        Celula segundaAtual;
        for(int i = 0; i < primeiraMatriz.numLinha; i++) {
            primeiraAtual = primeiraRef;
            segundaAtual = segundaRef;
            for(int j = 0; j < segundaMatriz.numColuna; j++) {
                // Salvar elemento propriamente dito
                matrizSoma.inserir( i, j, (primeiraAtual.elemento + segundaAtual.elemento));
                // Ir para o próximo
                if(primeiraAtual.prox != null) {
                    primeiraAtual = primeiraAtual.prox;
                    segundaAtual = segundaAtual.prox;
                }
            }
            // Mudar a referência
            primeiraRef = primeiraRef.inf;
            segundaRef = segundaRef.inf;
        }

        return matrizSoma;
    }

    public static MatrizFlexivel multiplicar(MatrizFlexivel primeiraMatriz, MatrizFlexivel segundaMatriz) throws Exception {
        if(primeiraMatriz.numColuna != segundaMatriz.numLinha) {
            throw new Exception ("Não é possível realizar a multiplicação!");
        }

        MatrizFlexivel matrizMultiplicacao = new MatrizFlexivel(primeiraMatriz.numLinha, segundaMatriz.numColuna);

        // Percorrer a matriz
        Celula primeiraRef = primeiraMatriz.inicio;
        Celula segundaRef = segundaMatriz.inicio;
        Celula primeiraAtual;
        Celula segundaAtual;
        int mult = 0;
        for(int i = 0; i < primeiraMatriz.numLinha; i++) {
            segundaAtual = segundaRef;
            for(int j = 0; j < segundaMatriz.numColuna; j++) {       
                primeiraAtual = primeiraRef;       
                for(int k = 0; k < segundaMatriz.numLinha; k++) {
                    mult += primeiraAtual.elemento * segundaAtual.elemento;
                    primeiraAtual = primeiraAtual.prox;
                    segundaAtual = segundaAtual.inf;
                }
                matrizMultiplicacao.inserir(i, j, mult);
                segundaAtual = segundaRef.prox;
                mult = 0;
            }
            primeiraRef = primeiraRef.inf;
        }

        return matrizMultiplicacao;
    }

    public void mostrar() {
        Celula ref = inicio;
        Celula atual;
        for(int i = 0; i < numLinha; i++) {
            atual = ref;
            for(int j = 0; j < numColuna; j++) {
                System.out.print(atual.elemento + " ");
                atual = atual.prox;
            }
            System.out.print("\n");
            ref = ref.inf;
        }
        ref = null;
        atual = null;
    }

    public static boolean hasMesmoTamanho(MatrizFlexivel primeiraMatriz, MatrizFlexivel segundaMatriz) {
        return (primeiraMatriz.numLinha == segundaMatriz.numLinha && primeiraMatriz.numColuna == segundaMatriz.numColuna);
    }
}

public class Questao09
{   
    public static MatrizFlexivel lerMatriz() throws Exception {
        // Ler o número de linhas da matriz
        int numLinha = MyIO.readInt();

        // Ler número de colunas da matriz
        int numColuna = MyIO.readInt();

        // Criar a matriz propriamente dita
        MatrizFlexivel matriz = new MatrizFlexivel(numLinha, numColuna);

        // Ler os valores da matriz;
        String[] linhaLeitura = new String[numLinha];
        String[] valoresSplit= new String[numColuna]; // Temporaria para dar Split
        int[][] valoresMatriz = new int[numLinha][numColuna];
        for(int i = 0; i < numLinha; i++) {
            linhaLeitura[i] =  MyIO.readLine();
            valoresSplit = linhaLeitura[i].split(" ");
            // Salvar os valores por coluna 
            for(int j = 0; j < numColuna; j++) {
                // Salvar os valores a serem inseridos
                valoresMatriz[i][j] = Integer.parseInt(valoresSplit[j]);
            }
        }

        // Ler valores da matriz propriamente dita
        for(int i = 0; i < numLinha; i++) {
            for(int j = 0; j < numColuna; j++) {
                matriz.inserir(i, j, valoresMatriz[i][j]);
            }
        }

        return matriz;
    }

	public static void main (String[] args) throws Exception 
	{
        // Ler número de casos teste
        int numTestes = MyIO.readInt();

        // Ler as matrizes
        for(int numMatrizes = 0; numMatrizes < numTestes; numMatrizes++) {
            MatrizFlexivel primeiraMatriz = lerMatriz();
            MatrizFlexivel segundaMatriz = lerMatriz();

            // Calcular diagonal principal
            int[] diagonalPrincipal = primeiraMatriz.getDiagonalPri();

            // Mostrar diagonal secundaria
            for(int i = 0; i < diagonalPrincipal.length; i++) {
                System.out.print(diagonalPrincipal[i] + " ");
            }
            System.out.print("\n");

            // Calcular Diagonal secundaria
            int[] diagonalSecundaria = primeiraMatriz.getDiagonalSec();

            // Mostrar diagonal secundaria
            for(int i = 0; i < diagonalSecundaria.length; i++) {
                System.out.print(diagonalSecundaria[i] + " ");
            }
            System.out.print("\n");

            // Calcular soma das matrizes
            MatrizFlexivel matrizSoma = MatrizFlexivel.somar(primeiraMatriz, segundaMatriz);
            // Mostrar a soma
            matrizSoma.mostrar();

            // Calcular multiplicacao
            MatrizFlexivel matrizMultiplicacao = MatrizFlexivel.multiplicar(primeiraMatriz, segundaMatriz)  ;
            // Mostrar multiplicacao 
            matrizMultiplicacao.mostrar();        
        }
	}	
}