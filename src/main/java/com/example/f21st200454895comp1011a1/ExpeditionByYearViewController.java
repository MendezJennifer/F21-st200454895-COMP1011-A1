package com.example.f21st200454895comp1011a1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Utilities.DBUtility;
import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExpeditionByYearViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis yearAxis;

    @FXML
    private NumberAxis climbAxis;

    @FXML
    private Button countrySuccessRate;

    //Switch to expeditions by country view
    public void countrySuccessRatePushed(ActionEvent event) throws IOException {
        Parent countryViewParent=FXMLLoader.load(getClass().getResource("expeditions-by-country-view.fxml"));
        Scene countryViewScene=new Scene(countryViewParent);

        Stage scene=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene.setScene((countryViewScene));
        scene.setTitle("Everest Expeditions 2000-2020 (Country)");
        scene.show();
        //SceneChanger.changeScenes(event,"expeditions-by-country-view.fxml","Everest Expeditions 2000-2020 (Country)");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        barChart.getData().addAll(DBUtility.getSuccessClimbDataByYear());

        climbAxis.setLabel("Expeditions");
        yearAxis.setLabel("Year");
        barChart.setLegendVisible(false);
    }
}
