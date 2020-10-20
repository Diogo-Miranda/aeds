class Retangulo {
    private double base;
    private double altura;

    public Retangulo()
    {
        this.base = 1;
        this.altura = 1;
    }

    public Retangulo(double base, double altura)
    {
        this.base = base;
        this.altura = altura;
    }

    public double getArea()
    {
        return (base*altura);
    }

    public double getPerimetro()
    {
        return ( (2*base) + (2*altura) );
    }    

    public double getDiagonal()
    {   
        return Math.sqrt( (Math.pow(base, 2)) + (Math.pow(altura, 2)) ) ;
    }
        
}


