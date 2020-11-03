public class No {
    public Celula primeiro, ultimo;
    public No esq, dir;
    public char letra;

    public No(char letra) {
        this.letra = letra;
        primeiro = ultimo = new Celula();
        esq = dir = null;
    }
}
