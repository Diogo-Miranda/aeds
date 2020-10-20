import java.io.*;

class ExemploRAF02Escrita {

    public static void main (String[] args) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile("teste01.txt", "rw");

        int inteiro = raf.readInt();
        double real = raf.readDouble();
        char caractere = raf.readChar();
        boolean boleano = raf.readBoolean();
        String str = raf.readLine();

        raf.close();
    }
}
