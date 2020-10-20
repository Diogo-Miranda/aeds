/**
  * descrever as celulas 
  * @author: Diogo Araujo Miranda
*/
class Cell {
	public int elemento;
	public Cell prox;
	
	public Cell() {
		this(0);
	}
		
	public Cell(int elemento){
		this.elemento = elemento;
		this.prox = null;
	}	
}
