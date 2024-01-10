package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private Connection conn;
    private GeografijaDAO() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baza.db");
    }
    public static GeografijaDAO getInstance() throws SQLException, ClassNotFoundException {
        if(instance == null) instance = new GeografijaDAO();
        return instance;
    }
    public static void removeInstance() throws SQLException {
        instance.conn.close();
        instance = null;
    }
    public ObservableList<Grad> gradovi() throws SQLException {
        ObservableList<Grad> gradovi = FXCollections.observableArrayList();

        String sql = "SELECT id, naziv, broj_stanovnika, drzava FROM grad ORDER BY broj_stanovnika DESC";

        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String naziv = resultSet.getString("naziv");
            int broj_stanovnika = resultSet.getInt("broj_stanovnika");
            int drzava = resultSet.getInt("drzava");

            Grad grad = new Grad(id, naziv, broj_stanovnika, drzava);
            gradovi.add(grad);
        }

        return gradovi;
    }

    private void regenerisiBazu() throws SQLException{
        // SQL naredbe za unos podataka o gradovima i državama
        String unosGradovaQuery = "INSERT INTO grad (naziv, broj_stanovnika, drzava) VALUES (?, ?, ?)";
        String unosDrzavaQuery = "INSERT INTO drzava (naziv, glavni_grad) VALUES (?, ?)";
        // Unos podataka
        PreparedStatement unosGradovaStatement = conn.prepareStatement(unosGradovaQuery);
        PreparedStatement unosDrzavaStatement = conn.prepareStatement(unosDrzavaQuery);

        //Pariz
        unosDrzavaStatement.setString(1, "Francuska");
        unosDrzavaStatement.setInt(2, 1);
        unosDrzavaStatement.executeUpdate();

        int gradId;
        ResultSet resultSet = unosGradovaStatement.getGeneratedKeys();
        resultSet.next();
        gradId = resultSet.getInt(1);

        unosGradovaStatement.setString(1, "Pariz");
        unosGradovaStatement.setInt(2, 2200000);
        unosGradovaStatement.setInt(3, gradId);
        unosGradovaStatement.executeUpdate();

        //London
        unosGradovaStatement.setString(1, "London");
        unosGradovaStatement.setInt(2, 8900000);
        unosGradovaStatement.setInt(3, 2);
        unosGradovaStatement.executeUpdate();

        ResultSet resultSet1 = unosGradovaStatement.getGeneratedKeys();
        resultSet.next();
        gradId = resultSet1.getInt(1);

        unosDrzavaStatement.setString(1, "Velika Britanija");
        unosDrzavaStatement.setInt(2, gradId);
        unosDrzavaStatement.executeUpdate();

        //Beč
        unosGradovaStatement.setString(1, "Beč");
        unosGradovaStatement.setInt(2, 1890000);
        unosGradovaStatement.setInt(3, 3);
        unosGradovaStatement.executeUpdate();

        ResultSet resultSet2 = unosGradovaStatement.getGeneratedKeys();
        resultSet.next();
        gradId = resultSet2.getInt(1);

        unosDrzavaStatement.setString(1, "Austrija");
        unosDrzavaStatement.setInt(2, gradId);
        unosDrzavaStatement.executeUpdate();
        //Mančester
        unosGradovaStatement.setString(1, "Mančester");
        unosGradovaStatement.setInt(2, 547627);
        unosGradovaStatement.setInt(3, 2);
        unosGradovaStatement.executeUpdate();

        //Graz
        unosGradovaStatement.setString(1, "Graz");
        unosGradovaStatement.setInt(2, 288806);
        unosGradovaStatement.setInt(3, 3);
        unosGradovaStatement.executeUpdate();

    }
    public void generisi() throws SQLException {
        regenerisiBazu();
    }

    public Grad glavniGrad(String drzava) throws SQLException{
        String glavniGradQuery = "SELECT glavni_grad FROM drzava WHERE naziv LIKE ?";
        PreparedStatement glavniGradStatement = conn.prepareStatement(glavniGradQuery);
        glavniGradStatement.setString(1, drzava);

        ResultSet result = glavniGradStatement.executeQuery();

        if(!result.next()){
            return null;
        }

        int grad = result.getInt("glavni_grad");

        ObservableList<Grad> gradovi = gradovi();

        for (Grad value : gradovi) {
            if (Objects.equals(value.getId(), grad)) {
                return value;
            }
        }

        return null;
    }

    public void obrisiDrzavu(String drzava) throws SQLException{
        String nadjiIdDrzaveQuery = "SELECT id FROM drzava WHERE naziv LIKE ?";
        PreparedStatement idDrzaveStatement = conn.prepareStatement(nadjiIdDrzaveQuery);
        idDrzaveStatement.setString(1, drzava);
        ResultSet result = idDrzaveStatement.executeQuery();
        int idDrzave = result.getInt("id");


        String obrisiGradoveQuery = "DELETE FROM grad WHERE drzava = ?";
        PreparedStatement obrisiGradoveStatement = conn.prepareStatement(obrisiGradoveQuery);
        obrisiGradoveStatement.setInt(1,idDrzave);
        obrisiGradoveStatement.executeUpdate();


        String obrisiDrzaveQuery = "DELETE FROM drzava WHERE naziv LIKE ?";
        PreparedStatement obrisiDrzaveStatement = conn.prepareStatement(obrisiDrzaveQuery);
        obrisiDrzaveStatement.setString(1, drzava);
        obrisiDrzaveStatement.executeUpdate();
    }

    public void dodajGrad(Grad grad) throws SQLException{
        String dodajGradQuery = "INSERT INTO grad (naziv, broj_stanovnika, drzava) VALUES (?, ?, ?)";
        PreparedStatement dodajGradStatement = conn.prepareStatement(dodajGradQuery);
        dodajGradStatement.setString(1, grad.getNaziv());
        dodajGradStatement.setInt(2,grad.getBroj_stanovnika());
        dodajGradStatement.setInt(3,grad.getDrzava());
        dodajGradStatement.executeUpdate();
    }

    public void dodajDrzavu(Drzava drzava) throws SQLException{
        String dodajDrzavuQuery = "INSERT INTO drzava (naziv,glavni_grad) VALUES (?,?)";
        PreparedStatement dodajDrzavuStatement = conn.prepareStatement(dodajDrzavuQuery);
        dodajDrzavuStatement.setString(1, drzava.getNaziv());
        dodajDrzavuStatement.setInt(2, drzava.getGlavni_grad());
        dodajDrzavuStatement.executeUpdate();
    }

    public void izmijeniGrad(Grad grad) throws SQLException{
        String izmijeniGradQuery = "UPDATE grad SET broj_stanovnika = ?,drzava = ? WHERE naziv LIKE ?";
        PreparedStatement izmijeniGradStatement = conn.prepareStatement(izmijeniGradQuery);
        izmijeniGradStatement.setInt(1, grad.getBroj_stanovnika());
        izmijeniGradStatement.setInt(2, grad.getDrzava());
        izmijeniGradStatement.setString(3, grad.getNaziv());
        izmijeniGradStatement.executeUpdate();
    }
    public Drzava nadjiDrzavu(String drzava) throws SQLException{
        String nadjiDrzavuQuery = "SELECT * FROM drzava WHERE naziv LIKE ?";
        PreparedStatement nadjiDrzavuStatement = conn.prepareStatement(nadjiDrzavuQuery);
        nadjiDrzavuStatement.setString(1,drzava);
        ResultSet result = nadjiDrzavuStatement.executeQuery();
        Drzava drzavaObjekat = new Drzava();
        drzavaObjekat.setId(result.getInt("id"));
        drzavaObjekat.setNaziv(result.getString("naziv"));
        drzavaObjekat.setGlavni_grad(result.getInt("glavni_grad"));

        return drzavaObjekat;
    }

    public Drzava nadjiDrzavu(int drzava) throws SQLException{
        String nadjiDrzavuQuery = "SELECT * FROM drzava WHERE id = ?";
        PreparedStatement nadjiDrzavuStatement = conn.prepareStatement(nadjiDrzavuQuery);
        nadjiDrzavuStatement.setInt(1,drzava);
        ResultSet result = nadjiDrzavuStatement.executeQuery();
        Drzava drzavaObjekat = new Drzava();
        drzavaObjekat.setId(result.getInt("id"));
        drzavaObjekat.setNaziv(result.getString("naziv"));
        drzavaObjekat.setGlavni_grad(result.getInt("glavni_grad"));

        return drzavaObjekat;
    }

    public void vratiNaDefault() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM grad");
        stmt.executeUpdate("DELETE FROM drzava");
    }

    public ObservableList<String> glGradovi() throws SQLException {
        ObservableList<String> glGradovi = FXCollections.observableArrayList();

        glGradovi.add("Sarajevo");
        glGradovi.add("Zagreb");
        glGradovi.add("Beograd");
        glGradovi.add("Madrid");
        glGradovi.add("Berlin");
        glGradovi.add("Varšava");
        glGradovi.add("Prag");
        glGradovi.add("Ljubljana");
        glGradovi.add("Ankara");
        glGradovi.add("Atina");
        glGradovi.add("Vašington");
        glGradovi.add("Brisel");

        return glGradovi;
    }

    public ObservableList<String> drzave() throws SQLException {
        ObservableList<String> drzave = FXCollections.observableArrayList();

        String sql = "SELECT naziv FROM drzava";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            String drzava = resultSet.getString("naziv");
            drzave.add(drzava);
        }

        return drzave;
    }
}
