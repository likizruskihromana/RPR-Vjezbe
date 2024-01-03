package ba.unsa.etf.rpr;

public class Student {
    private static final Student INSTANCE=new Student();
    private Student(){
        System.out.println("Inicijalizacija");
    }
    public static Student getInstance(){
        return INSTANCE;
    }
    public void ImePrezime(){
        System.out.println("Ovaj student se zove ...");
    }

}
