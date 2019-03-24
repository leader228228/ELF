package ua.edu.sumdu.badgroup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import ua.edu.sumdu.badgroup.entities.Data;
import ua.edu.sumdu.badgroup.entities.Point;
import ua.edu.sumdu.badgroup.job.DeviateCalculation;
import ua.edu.sumdu.badgroup.math.Formulas;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

public class App extends Application
{

    private Controller controllerA;
    private ControllerB controllerB;
    private ControllerC controllerC;

    private Parent parentA;
    private Parent parentB;
    private Parent parentC;

    private Map<Formulas, Properties> mapFP;
    private Data dataPoints;

    public Data getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(Data dataPoints) {
        this.dataPoints = dataPoints;
    }

    public Map<Formulas, Properties> getMapFP() {
        return mapFP;
    }

    public void setMapFP(Map<Formulas, Properties> mapFP) {
        this.mapFP = mapFP;
    }

    public static void main(String[] args )
    {
        launch(args);
    }

    public Parent getParentA() {
        return parentA;
    }

    public Parent getParentB() {
        return parentB;
    }

    public Parent getParentC() {
        return parentC;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mapFP = new HashMap<>();
        dataPoints = new Data(new LinkedList<Point>());
        FXMLLoader loaderA = new FXMLLoader();
        FXMLLoader loaderB = new FXMLLoader();
        FXMLLoader loaderC = new FXMLLoader();
        controllerA = new Controller(this);
        loaderA.setController(controllerA);
        loaderA.setLocation(Controller.class.getResource("../../../../a.fxml"));
        parentA = loaderA.load();
        controllerB = new ControllerB(this);
        loaderB.setController(controllerB);
        loaderB.setLocation(ControllerB.class.getResource("../../../../b.fxml"));
        parentB = loaderB.load();
        controllerC = new ControllerC(this);
        loaderC.setController(controllerC);
        loaderC.setLocation(ControllerC.class.getResource("../../../../c.fxml"));
        parentC = loaderC.load();

        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(parentA, primaryStage.getWidth(), primaryStage.getHeight()));
       // this.primStage = primaryStage;
        primaryStage.show();
    }
}
