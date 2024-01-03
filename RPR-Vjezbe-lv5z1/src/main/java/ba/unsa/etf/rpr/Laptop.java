package ba.unsa.etf.rpr;

import java.io.Serializable;

public class Laptop implements Serializable {
    private final String brend;
    private final String model;
    private final double cijena;
    private final int ram;
    private final int hdd;
    private final int ssd;
    private final String procesor;
    private final String grafickaKartica;
    private final double velicinaEkrana;

    public Laptop(String brend, String model, double cijena, int ram, int hdd, int ssd, String procesor, String grafickaKartica, double velicinaEkrana) {
        this.brend = brend;
        this.model = model;
        this.cijena = cijena;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.velicinaEkrana = velicinaEkrana;
    }

    public Laptop(LaptopBuilder lb) {
        this.brend = lb.getBrend();
        this.model = lb.getModel();
        this.cijena = lb.getCijena();
        this.ram = lb.getRam();
        this.hdd = lb.getHdd();
        this.ssd = lb.getSsd();
        this.procesor = lb.getProcesor();
        this.grafickaKartica = lb.getGrafickaKartica();
        this.velicinaEkrana = lb.getVelicinaEkrana();
    }

    @Override
    public String toString() {
        return "LAPTOP {" +
                "brand = '" + brend + '\'' +
                ", model = '" + model + '\'' +
                ", price = " + cijena +
                ", RAM = " + ram +
                ", HDD = " + hdd +
                ", SSD = " + ssd +
                ", CPU = '" + procesor + '\'' +
                ", GPU = '" + grafickaKartica + '\'' +
                ", screen_size = " + velicinaEkrana +
                '}';
    }


}
