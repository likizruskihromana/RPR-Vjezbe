package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class GlavnaController {
    private GeografijaDAO geoDao;
    @FXML
    private TableView<Grad> tableViewGradovi;
    @FXML
    private Button btnDodajGrad;

    public GlavnaController() throws SQLException, ClassNotFoundException {
        geoDao = GeografijaDAO.getInstance();
        geoDao.generisi();
        tableViewGradovi = new TableView<Grad>();
    }
    @FXML
    public void initialize() throws SQLException {
        tableViewGradovi.setItems(geoDao.gradovi());

        TableColumn<Grad, SimpleIntegerProperty> colGradId = new TableColumn<>("ID");
        colGradId.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn<Grad, SimpleStringProperty> colGradNaziv = new TableColumn<>("Naziv");
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));

        TableColumn<Grad, SimpleIntegerProperty> colGradStanovnika = new TableColumn<>("Broj Stanovnika");
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("broj_stanovnika"));

        TableColumn<Grad, SimpleIntegerProperty> colGradDrzava = new TableColumn<>("Drzava");
        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        tableViewGradovi.getColumns().setAll(colGradId, colGradNaziv, colGradStanovnika, colGradDrzava);
    }
    @FXML
    public void onDodajGradClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("grad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 275, 200);
        stage.setTitle("Grad");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onDodajDrzavuClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("drzava.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 150);
        stage.setTitle("Drzava");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onIzmijeniGradClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("grad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 275, 200);
        stage.setTitle("Grad");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onObrisiGradClick(){

    }
}