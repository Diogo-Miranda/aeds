public class No {
	public int elemento;
	public No esq;
	public No dir;

	public No() {
		this(0);
	}

	public No(int elemento) {
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
	}
}
