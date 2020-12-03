package ListaSimples;

public class ListaSimples {
    public CedulaSimples primeiro;
    public CedulaSimples ultimo;

    public ListaSimples() {
        this.primeiro = new CedulaSimples();
        this.ultimo = primeiro;
    }

    public int getNumElementos() {
        int numElementos = 0;

        for(CedulaSimples i = primeiro.prox; i != null; i = i.prox) {
            numElementos++;
        }

        return numElementos;
    }

    public void inserirInicio(int elemento) {   
        CedulaSimples nova = new CedulaSimples(elemento);
        nova.prox = primeiro.prox;
        primeiro.prox = nova;

        if(primeiro == ultimo) {
            ultimo = nova;
        }

        nova = null;
    }

    public void inserirFim(int elemento) {
        CedulaSimples nova = new CedulaSimples(elemento);
        ultimo.prox = nova;
        ultimo = nova;

        nova = null;
    }

    public void inserir(int elemento, int pos) throws Exception {
        int numElementos = getNumElementos();
        if(pos > numElementos || pos < 0) {
            throw new Exception("ERRO");
        } else if(pos == 0) {
            inserirInicio(elemento);
        } else if (pos == numElementos) {
            inserirFim(elemento);
        } else {
            // Percorrer até a cedula á ser inserida
            CedulaSimples i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);

            CedulaSimples nova = new CedulaSimples(elemento);
            nova.prox = i.prox;
            i.prox = nova;

            nova = null;
            i = null;
        }
    }

    public int removerInicio() throws Exception {
        int resp = 0;
        if(primeiro == ultimo) {
            throw new Exception("Erro!");
        } else {
            resp = primeiro.prox.elemento;
            primeiro.prox = primeiro.prox.prox;
        }

        return resp;
    }

    public int removerFim() throws Exception {
        int resp  =0;
        if(primeiro == ultimo) {
            throw new Exception("Erro!");
        } else {
            CedulaSimples i;
            for(i = primeiro; i.prox != ultimo; i = i.prox);

            resp = ultimo.elemento;
            ultimo = i;
            i = ultimo.prox = null;
        }
        return resp;
    }

    public int remover(int pos) throws Exception {
        int resp = 0;
        int numElementos = getNumElementos();
        if(pos < 0 || pos >= numElementos || ultimo == primeiro) {
            throw new Exception("Erro!");
        } else if(pos == 0) {
            resp = removerInicio();
        } else if (pos == numElementos-1) {
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            CedulaSimples i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
            
            CedulaSimples tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
        return resp;
    }

    public void mostrar() {
        System.out.print("[ ");
        for(CedulaSimples i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.print("]\n");
    }
}
