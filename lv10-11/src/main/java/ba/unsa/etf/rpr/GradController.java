package ba.unsa.etf.rpr;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class GradController {
    private GeografijaDAO geoDao;
    @FXML
    private ChoiceBox<String> choiceDrzava;
    @FXML
    TextField fieldBrojStanovnika;
    @FXML
    TextField fieldNaziv;
    public GradController() throws SQLException, ClassNotFoundException {
        geoDao = GeografijaDAO.getInstance();
        choiceDrzava = new ChoiceBox<>();
    }
    @FXML
    public void initialize() throws SQLException {
        choiceDrzava.setItems(geoDao.drzave());
    }
    @FXML
    public void onOkClick(){
        //Nemoguce implementirati zbog greske u lv9
    }
    @FXML
    public void onCancelClick(){

    }
}
