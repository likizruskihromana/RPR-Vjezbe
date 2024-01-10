package ba.unsa.etf.rpr;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class DrzavaController {
    private GeografijaDAO geoDao;
    @FXML
    TextField fieldNaziv;
    @FXML
    ChoiceBox<String> choiceGrad;
    public DrzavaController() throws SQLException, ClassNotFoundException {
        geoDao = GeografijaDAO.getInstance();
        choiceGrad = new ChoiceBox<>();
    }
    @FXML
    public void initialize() throws SQLException {
        choiceGrad.setItems(geoDao.glGradovi());
    }
    @FXML
    public void onCancelClick(){
        //???
    }
    @FXML
    public void onOkClick(){
        //Nemoguce izvesti, greska u lv9
    }
}
