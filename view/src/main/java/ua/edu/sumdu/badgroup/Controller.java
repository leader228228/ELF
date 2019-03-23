package ua.edu.sumdu.badgroup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Controller {

    @FXML
    private Button btnNew;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnExit;

    public void pressNew(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("../../../../b.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage currentStage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(homePageScene);
        currentStage.show();
    }
}
