package ba.unsa.etf.rpr;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String ispisiGradove(GeografijaDAO geoDao) throws SQLException {
        ObservableList<Grad> gradovi = geoDao.gradovi();
        StringBuilder stringBuilder = new StringBuilder();

        for(Grad value : gradovi){
            stringBuilder.append(value.getNaziv() + "(" + value.getDrzava() + ") - " + value.getBroj_stanovnika() + "\n");
        }

        String gradLista = stringBuilder.toString();
        return gradLista;
    }
    static void glavniGrad(GeografijaDAO geoDao) throws SQLException {
        System.out.println("Unesite naziv drzave: ");
        Scanner input = new Scanner(System.in);
        String drzava = input.next();
        Grad grad = geoDao.glavniGrad(drzava);
        if(grad == null){
            System.out.println("Nepostojeca drzava");
            return;
        }
        System.out.println("Glavni grad drzave " + drzava + " je " + grad.getNaziv());
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GeografijaDAO geoDao = GeografijaDAO.getInstance();
        geoDao.generisi();
        System.out.println(ispisiGradove(geoDao));
        glavniGrad(geoDao);
        geoDao.vratiNaDefault();
    }
}
