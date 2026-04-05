class Shapes 
{
    double result;
    Shapes() 
    {
        result = 0;
    }

    Shapes(double r) 
    {
        result = Math.PI * r * r;
    }
    Shapes(double l, double b) 
    {
        result = l * b;
    }
    Shapes(double b, double h, boolean t) 
    {
        result = 0.5 * b * h;
    }

    double area(double r) 
    {
        return Math.PI * r * r;
    }
    double area(double l, double b) 
    {
        return l * b;
    }
    double area(double b, double h, boolean t) 
    {
        return 0.5 * b * h;
    }
    double area(double a, double b, double c) 
    {
        double s = (a + b + c) / 2;
        double ans = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return ans;
    }

    public static void main(String args[]) 
    {
        Shapes c = new Shapes(7);
        System.out.println("Circle area = " + c.result);

        Shapes r = new Shapes(5, 10);
        System.out.println("Rectangle area = " + r.result);

        Shapes t = new Shapes(6, 8, true);
        System.out.println("Triangle area = " + t.result);

        Shapes s = new Shapes();

        System.out.println("Circle area = " + s.area(5));
        System.out.println("Rectangle area = " + s.area(4, 9));
        System.out.println("Triangle area = " + s.area(3, 4, true));
        System.out.println("Triangle area (3 sides) = " + s.area(3, 4, 5));
    }
}
