package org.example;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TextField imeID;
    @FXML
    private TextField prezimeID;
    @FXML
    private TextField adresaID;
    @FXML
    private ComboBox<Integer> brzinaComboBox;
    @FXML
    private ComboBox<String> protokComboBox;
    @FXML
    private ComboBox<Integer> trajanje_ugovoraComboBox;
    @FXML
    private Button potvrdiBtn;
    @FXML
    private TableView<InternetPaket> tabelaProdaje;
    @FXML
    private TableColumn<InternetPaket,String> kolonaIme;
    @FXML
     private TableColumn<InternetPaket,String> kolonaPrezime;
    @FXML
    private TableColumn<InternetPaket,String> kolonaAdresa;
    @FXML
    private TableColumn<InternetPaket,Integer> kolonaBrzina;
    @FXML
     private TableColumn<InternetPaket,String> kolonaProtok;
    @FXML
    private TableColumn<InternetPaket,Integer> kolonaTUgovora;
    @FXML
    private Button clearFormBtn;

    InternetPaket ipaket;

    ObservableList<InternetPaket> listaInternetPaketa = FXCollections.observableArrayList();
    public Controller(){}
    @FXML
    private void initialize(){
        ipaket = new InternetPaket();
        imeID.textProperty().bindBidirectional(ipaket.imeProperty());
        prezimeID.textProperty().bindBidirectional(ipaket.prezimeProperty());
        adresaID.textProperty().bindBidirectional(ipaket.adresaProperty());
        brzinaComboBox.valueProperty().bindBidirectional(ipaket.brzineProperty().asObject());
        Bindings.bindBidirectional(protokComboBox.valueProperty(),ipaket.protociProperty());
        Bindings.bindBidirectional(trajanje_ugovoraComboBox.valueProperty(),ipaket.trajanjaUgovoraProperty().asObject());
        kolonaIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        kolonaPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        kolonaAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        kolonaBrzina.setCellValueFactory(new PropertyValueFactory<>("brzine"));
        kolonaProtok.setCellValueFactory(new PropertyValueFactory<>("protoci"));
        kolonaTUgovora.setCellValueFactory(new PropertyValueFactory<>("trajanjaUgovora"));
        tabelaProdaje.setItems(listaInternetPaketa);
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);
    public void save(ActionEvent event) {
        if ((imeID.getText().equals("") || (prezimeID.getText().equals("") || (adresaID.getText().equals("")
                || (brzinaComboBox.getValue() == null)||(protokComboBox.getValue() ==null)|| (trajanje_ugovoraComboBox.getValue() == null))))){
            alert.setTitle("Greska!");
            alert.setHeaderText("Doslo je do greske!");
            alert.setContentText("Niste uneli sve podatke u formu!");
            alert.show();
        }else {
            String ime = imeID.getText();
            String prezime = prezimeID.getText();
            String adresa = adresaID.getText();
            Integer brzina = brzinaComboBox.getValue();
            String protok = protokComboBox.getSelectionModel().getSelectedItem().toString();
            Integer trajanjeUgovora = trajanje_ugovoraComboBox.getValue();
            InternetPaket newInternetPaket = new InternetPaket(brzina,protok,trajanjeUgovora,ime,prezime,adresa);
            listaInternetPaketa.add(newInternetPaket);
        }

    }

    public void clearForm(ActionEvent event) {
        imeID.clear();
        prezimeID.clear();
        adresaID.clear();
        brzinaComboBox.getSelectionModel().clearSelection();
        protokComboBox.getSelectionModel().clearSelection();
        trajanje_ugovoraComboBox.getSelectionModel().clearSelection();
    }

    public void deleteRow(ActionEvent event) {
        if (!tabelaProdaje.getSelectionModel().isEmpty()) {

            int selectedIndex = tabelaProdaje.getSelectionModel().getSelectedIndex();

            listaInternetPaketa.remove(selectedIndex);

            tabelaProdaje.refresh();
        }
    }
}
