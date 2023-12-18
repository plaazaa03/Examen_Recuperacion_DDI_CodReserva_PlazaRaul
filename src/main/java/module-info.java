module es.ieslosmontecillos.codreserva_plazaraul {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.codreserva_plazaraul to javafx.fxml;
    exports es.ieslosmontecillos.codreserva_plazaraul;
}