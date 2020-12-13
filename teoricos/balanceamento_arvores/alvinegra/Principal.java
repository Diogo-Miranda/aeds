public class Principal {

    public static void main (String[] args) throws Exception {
        Alvinegra av = new Alvinegra();
        for(int i = 0; i < 20; i++) {
            int num = MyIO.readInt();
            av.inserir(num);
        }
    }

}
