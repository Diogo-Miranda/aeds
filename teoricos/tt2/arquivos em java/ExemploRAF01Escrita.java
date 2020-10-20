import java.io.*;

class ExemploRAF01Escrita {

    public static void main (String[] args) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile("teste01.txt", "rw");

        raf.writeInt(1);
        raf.writeBoolean(true);
        raf.writeChar('d');
        raf.writeBytes("Algoritmos");
    }
}
