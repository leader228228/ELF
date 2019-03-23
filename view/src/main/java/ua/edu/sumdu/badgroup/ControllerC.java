package ua.edu.sumdu.badgroup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerC implements Initializable {

    @FXML
    private AnchorPane anchPaneUp;


    public void loadData() {
        anchPaneUp.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(0, 20 , 1);
        xAxis.setLabel("years");
        NumberAxis yAxis = new NumberAxis(-2, 2, 0.1);
        yAxis.setLabel("value");
        LineChart<Number, Number> elfChart = new LineChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < 20; i++) {
            series.getData().add(new XYChart.Data<>(i, function(i)));
        }
        elfChart.getData().add(series);
        elfChart.setMaxWidth(400);
        elfChart.setMaxHeight(250);
        anchPaneUp.getChildren().add(elfChart);
    }

    private double function(int i) {
        return Math.sin(i);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    public void Rebuild(ActionEvent event) {

    }
}
