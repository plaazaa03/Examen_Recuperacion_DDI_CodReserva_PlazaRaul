package es.ieslosmontecillos.codreserva_plazaraul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CodReserva extends AnchorPane{

    @FXML
    private TextField TextField1;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button button;

    private String numReserva;
    private boolean acceso;

    public CodReserva() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CodReserva.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        button.setOnAction(this::handleButtonAction);
    }

    private void handleButtonAction(ActionEvent event) {
        numReserva = TextField1.getText();
        String pinCode = PasswordField.getText();

        int reservationNumber = 0;
        try {
            reservationNumber = Integer.parseInt(numReserva);
        } catch (NumberFormatException e) {
        }

        if (isValidReservation(reservationNumber) && isValidPin(pinCode)) {
            acceso = true;
            System.out.println("Acceso permitido");
        } else {
            acceso = false;
            System.out.println("Acceso denegado");
        }
    }

    private boolean isValidReservation(int reservationNumber) {
        return reservationNumber >= 10000001 && reservationNumber <= 19999999 && reservationNumber != 12348765;
    }

    private boolean isValidPin(String pinCode) {
        return pinCode.equals("1928");
    }

    public String getNumReserva() {
        return numReserva;
    }

    public boolean isAcceso() {
        return acceso;
    }
}
