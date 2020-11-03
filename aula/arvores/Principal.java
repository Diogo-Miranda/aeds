/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
   public static void main(String[] args) throws Exception {
      ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
      ArvoreBinaria arvoreBinaria2 = new ArvoreBinaria();

      /*arvoreBinaria.inserir(3);
      arvoreBinaria.inserir(5);
      arvoreBinaria.inserir(1);
      arvoreBinaria.inserir(8);
      arvoreBinaria.inserir(2);
      arvoreBinaria.inserir(4);
      arvoreBinaria.inserir(7);
      arvoreBinaria.inserir(6);*/

      arvoreBinaria2.inserir(3);
      arvoreBinaria2.inserir(5);
      arvoreBinaria2.inserir(1);
      arvoreBinaria2.inserir(8);
      arvoreBinaria2.inserir(2);
      arvoreBinaria2.inserir(4);
      arvoreBinaria2.inserir(7);
      arvoreBinaria2.inserir(6);

      boolean isIgual = ArvoreBinaria.isIgual(arvoreBinaria, arvoreBinaria2);
      System.out.println(isIgual);
   }
}
