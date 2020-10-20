class tempoMedio {
    
    public static char replaceVirgula(char c)
    {
        return (c == ',' ? '.' : c);
    }

    public static String replaceString(String in)
    {
        String out = "";

        for(int i = 0; i < in.length(); i++)
        {
            out += replaceVirgula(in.charAt(i));
        }

        return out;
    }

    public static void main (String[] args)
    {
        Arq file = new Arq();
        
        file.openRead("decrescente10000.txt");

        int count = 0;
        double num = 0,
               media = 0;

        while(file.hasNext())
        {
            num = Double.parseDouble(replaceString(file.readLine()));
            System.out.println(num);
            count++;
            //System.out.println("Media = "+ media);
            media += num;
        }
         
        //System.out.println("Count = "+ count);
        media = media/count;
        System.out.println("Media = "+ media);

        file.close();

    }
}
