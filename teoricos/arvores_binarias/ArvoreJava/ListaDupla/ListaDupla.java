package ListaDupla;

public class ListaDupla {
    public CedulaDupla primeiro;
    public CedulaDupla ultimo;

    public ListaDupla() {
        this.primeiro = new CedulaDupla();
        this.ultimo = primeiro;
    }

    public int getNumElementos() {
        int numElementos = 0;

        for(CedulaDupla i = primeiro.prox; i != null; i = i.prox) {
            numElementos++;
        }

        return numElementos;
    }

    public void inserirInicio(int elemento) {   
        CedulaDupla nova = new CedulaDupla(elemento);
        nova.ant = primeiro;
        nova.prox = primeiro.prox;
        primeiro.prox = nova;

        if(ultimo == primeiro) {
            ultimo = nova;
        } else {
            nova.prox.ant = nova;
        }

        nova = null;
    }

    public void inserirFim(int elemento) {
        CedulaDupla nova = new CedulaDupla(elemento);
        ultimo.prox = nova;
        nova.ant = ultimo;
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
            CedulaDupla i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);

            CedulaDupla nova = new CedulaDupla(elemento);
            nova.ant = i;
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
            primeiro.prox.ant = primeiro;
        }

        return resp;
    }

    public int removerFim() throws Exception {
        int resp  =0;
        if(primeiro == ultimo) {
            throw new Exception("Erro!");
        } else {
            resp = ultimo.elemento;
            ultimo = ultimo.ant;
            ultimo.prox = null;
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
            // Mover ponteiro até a pos
            CedulaDupla i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
            
            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            resp = i.elemento;
            i.prox = i.ant = null;
            i = null;
        }
        return resp;
    }

    public void mostrar() {
        System.out.print("[ ");
        for(CedulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.print("]\n");
    }
}
