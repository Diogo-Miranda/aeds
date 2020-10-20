import java.io.*;

class ExemploRAF03Cabecote {

    public static void main (String[] args) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile("teste01.txt", "rw");
        raf.seek(0);
        MyIO.println(raf.readInt());

        raf.seek(12);
        MyIO.println(raf.readChar());

        raf.seek(12);
        raf.writeChar('@');
            
        raf.seek(12);
        MyIO.println(raf.readChar());

        raf.close();

    }
}
