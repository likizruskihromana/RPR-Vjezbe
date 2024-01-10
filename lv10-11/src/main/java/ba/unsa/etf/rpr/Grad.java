package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Grad {
    private SimpleIntegerProperty id;
    private SimpleStringProperty naziv;
    private SimpleIntegerProperty broj_stanovnika;
    private SimpleIntegerProperty drzava;

    public Grad() {
        this.id = new SimpleIntegerProperty(0);
        this.naziv = new SimpleStringProperty("");
        this.broj_stanovnika = new SimpleIntegerProperty(0);
        this.drzava = new SimpleIntegerProperty(0);
    }

    public Grad(int id, String naziv, int brojStanovnika, int drzava) {
        this.id = new SimpleIntegerProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.broj_stanovnika = new SimpleIntegerProperty(brojStanovnika);
        this.drzava = new SimpleIntegerProperty(drzava);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika.get();
    }

    public SimpleIntegerProperty broj_stanovnikaProperty() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika.set(broj_stanovnika);
    }

    public int getDrzava() {
        return drzava.get();
    }

    public SimpleIntegerProperty drzavaProperty() {
        return drzava;
    }

    public void setDrzava(int drzava) {
        this.drzava.set(drzava);
    }
}
