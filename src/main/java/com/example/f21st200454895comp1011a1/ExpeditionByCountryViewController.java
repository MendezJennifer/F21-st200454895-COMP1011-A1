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

public class ExpeditionByCountryViewController implements Initializable
{
    @FXML
    private Button yearSuccessRate;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis countryAxis;

    @FXML
    private NumberAxis climbAxis;

    //Switch to expeditions by year view
    public void yearSuccessRatePushed(ActionEvent event) throws IOException {
        //SceneChanger sChange=new SceneChanger();
        //sChange.changeScenes(event,"expeditions-by-year-view.fxml","Everest Expeditions 2000-2020 (Year)");
        Parent yearViewParent= FXMLLoader.load(getClass().getResource("expeditions-by-year-view.fxml"));
        Scene countryViewScene=new Scene(yearViewParent);

        Stage scene=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene.setScene((countryViewScene));
        scene.setTitle("Everest Expeditions 2000-2020 (Year)");
        scene.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        barChart.getData().addAll(DBUtility.getSuccessClimbDataCountry());

        climbAxis.setLabel("Expeditions");
        countryAxis.setLabel("Country");
        barChart.setLegendVisible(false);
    }
}
