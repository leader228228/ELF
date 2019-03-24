package ua.edu.sumdu.badgroup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ua.edu.sumdu.badgroup.job.GettingApproximatedFormula;
import ua.edu.sumdu.badgroup.math.Formula;
import ua.edu.sumdu.badgroup.math.Formulas;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerC implements Initializable {

    @FXML
    private AnchorPane anchPaneUp;
    private Formula currentGenericFormula;


    private App app;

    public ControllerC(App app) {
        this.app = app;
    }

    public void loadData() {
        anchPaneUp.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(0, 50 , 1);
        xAxis.setLabel("years");
        NumberAxis yAxis = new NumberAxis(0, 50, 1);
        yAxis.setLabel("value");
        LineChart<Number, Number> elfChart = new LineChart(xAxis, yAxis);
        elfChart.setStyle(".chart-line-symbol {\n" +
                "    -fx-background-color: #f9d900, white;\n" +
                "    -fx-background-insets: 0, 2;\n" +
                "    -fx-background-radius: 0px;\n" +
                "    -fx-padding: 5px;\n" +
                "}");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < 50; i++) {
            XYChart.Data<Number, Number> point = new XYChart.Data<>((Number) i, (Number)function(i));
            Circle circle = new Circle(1);
            circle.setStyle("-fx-background-radius: 1px;");
            circle.setStyle("-fx-background-color: #f20909;");
            point.setNode(circle);
            series.getData().add(point);
        }
        elfChart.getData().add(series);
        elfChart.setMaxWidth(600);
        elfChart.setMaxHeight(400);
        anchPaneUp.getChildren().add(elfChart);
    }

    private double function(int i) {
        //currentGenericFormula.
        return 1/(0.08254 + 0.021 * Math.log(i) );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GettingApproximatedFormula currentFormula = new GettingApproximatedFormula(Formulas.INVERSE_LOG_SUM,
                app.getDataPoints());
        currentGenericFormula = currentFormula.execute();
        loadData();
    }

    public void Rebuild(ActionEvent event) {

    }

    @FXML
    void pressCancel(ActionEvent event) {
        Parent homePageParent1 = app.getParentA();

        Scene homePageScene1 = homePageParent1.getScene();
        Stage currentStage1 =  (Stage) ( (Node) event.getSource()).getScene().getWindow();
        currentStage1.setScene(homePageScene1);
        currentStage1.show();
    }
}
