class Hillstations 
{
    void famousfood() 
    {
        System.out.println("Known for local food");
    }

    void famousfor() 
    {
        System.out.println("Known for natural beauty");
    }
}

class Mahabaleshwar extends Hillstations 
{
    void famousfood() 
    {
        System.out.println("Mahabaleshwar is famous for strawberries and corn");
    }

    void famousfor() 
    {
        System.out.println("Mahabaleshwar is famous for Venna Lake and cool weather");
    }
}

class Lonavala extends Hillstations 
{
    void famousfood() 
    {
        System.out.println("Lonavala is famous for chikki and fudge");
    }

    void famousfor() 
    {
        System.out.println("Lonavala is famous for Bhushi Dam and waterfalls");
    }
}

class Matheran extends Hillstations 
{
    void famousfood() 
    {
        System.out.println("Matheran is famous for chikki and honey");
    }

    void famousfor() 
    {
        System.out.println("Matheran is famous for being a vehicle free hill station");
    }
}

class Main 
{
    public static void main(String args[]) 
    {
        Hillstations h;

        h = new Mahabaleshwar();
        System.out.println("Mahabaleshwar:");
        h.famousfood();
        h.famousfor();

        h = new Lonavala();
        System.out.println("\nLonavala:");
        h.famousfood();
        h.famousfor();

        h = new Matheran();
        System.out.println("\nMatheran:");
        h.famousfood();
        h.famousfor();
    }
}