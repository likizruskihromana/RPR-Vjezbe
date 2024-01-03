package ba.unsa.etf.rpr;

public class LaptopBuilder {
    // required
    private final String brend;
    private final String model;
    // optional
    private double cijena = 0;
    private int ram= 0;
    private int hdd= 0;
    private int ssd= 0;
    private String procesor= "...";
    private String grafickaKartica= "...";
    private double velicinaEkrana= 0;

    LaptopBuilder(String brend, String model){
        this.brend = brend;
        this.model = model;
    }

    LaptopBuilder cijena(double cijena){
        this.cijena = cijena;
        return this;
    }

    LaptopBuilder ram(int ram){
        this.ram = ram;
        return this;
    }
    LaptopBuilder hdd(int hdd){
        this.hdd = hdd;
        return this;
    }
    LaptopBuilder ssd(int ssd){
        this.ssd = ssd;
        return this;
    }
    LaptopBuilder procesor(String procesor){
        this.procesor = procesor;
        return this;
    }
    LaptopBuilder grafickaKartica(String grafickaKartica){
        this.grafickaKartica = grafickaKartica;
        return this;
    }
    LaptopBuilder velicinaEkrana(double velicinaEkrana){
        this.velicinaEkrana = velicinaEkrana;
        return this;
    }

    Laptop build(){
        return new Laptop(this);
    }

    public String getBrend() {
        return brend;
    }

    public String getModel() {
        return model;
    }

    public double getCijena() {
        return cijena;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public String getProcesor() {
        return procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }
}
