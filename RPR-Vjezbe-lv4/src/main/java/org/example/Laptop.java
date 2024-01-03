package org.example;

import java.io.Serializable;

public class Laptop implements Serializable {
    private String brend, model, procesor, grafickaKartica;
    private int ram, hdd, ssd;
    private double cijena, velicinaEkrana;
    public Laptop() {};

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

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
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
