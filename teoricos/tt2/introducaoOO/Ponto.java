class Ponto {
    private double x;
    private double y;
    private int id;
    static private int nextID = 0;

    public Ponto() 
    {
        this.x = 0;
        this.y = 0;
        this.id = nextID;
        nextID++;
    }

    public Ponto(double x, double y) 
    {
        this.x = x;
        this.y = y;
        this.id = nextID;
        nextID++; 
    }

    public double getX()
    {
        return this.x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY() 
    {
        return this.y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public int getId()
    {
        return this.id;
    }

    public static int getNextID()
    {
        return nextID;
    }
       
    public double dist(Ponto p)
    {
        double somaDosQuadrados = Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2);
        double dist = Math.sqrt(somaDosQuadrados);

        return dist;
    }

    public double dist(double x, double y)
    {
        double somaDosQuadrados = Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2);
        double dist = Math.sqrt(somaDosQuadrados);

        return dist;
    }
    
    public static double dist(double x, double y, double x1, double y2)
    {
        double somaDosQuadrados = Math.pow(x - x1, 2) + Math.pow(y - y2, 2);
        double dist = Math.sqrt(somaDosQuadrados);

        return dist;
    }

    public static boolean isTriangulo(Ponto p1, Ponto p2, Ponto p3)
    {
        boolean isTriangulo = true; 
        
        double lado1 = p1.dist(p2);
        double lado2 = p2.dist(p3);
        double lado3 = p3.dist(p1);

        if(lado1 > lado2 + lado3)
        {
            isTriangulo = false; 
        } else if (lado2 > lado3 + lado1)
        {
            isTriangulo = false;
        } else if (lado3 > lado2 + lado1)
        {
            isTriangulo = false;
        }
            
        return isTriangulo;
    }
    
    public double getAreaRetangulo(Ponto p)
    {
        double lado = p.dist(this.x, this.y);
        double area = lado*lado;

        return area;
    }
}
