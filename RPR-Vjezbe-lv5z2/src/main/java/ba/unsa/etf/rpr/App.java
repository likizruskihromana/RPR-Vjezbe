package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ShapeFactory sf=new ShapeFactory();
        Shape o=sf.createShape("Circle");
        o.oblik();

    }
}
