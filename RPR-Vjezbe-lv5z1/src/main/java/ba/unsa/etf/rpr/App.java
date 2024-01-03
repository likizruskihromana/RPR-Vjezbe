package ba.unsa.etf.rpr;

public class App {
    public static void main(String[] args) {
        Laptop l=new LaptopBuilder("MacBook", "7").cijena(2000).velicinaEkrana(20).build();
        System.out.println(l);
    }
}
