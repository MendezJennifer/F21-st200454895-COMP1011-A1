package Utilities;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {

    //Connection Data
    private static String userName="student";
    private static String pw="student";
    private static String conURL="jdbc:mysql://localhost:3306/everest";

    //Return list of successful Everest expeditions per year
    public static XYChart.Series<String, Integer> getSuccessClimbDataByYear()
    {
        XYChart.Series<String, Integer> successClimbDataYear = new XYChart.Series<>();

        String sql1 = "SELECT year AS 'Expedition Year', COUNT(success) AS 'Successful Climbs'\n" +
                "FROM expeditions\n" +
                "GROUP BY year;";

        //Try with resources
        try (
                Connection conn = DriverManager.getConnection(conURL, userName, pw);
                Statement statement=conn.createStatement();
                ResultSet resultSet=statement.executeQuery(sql1);
        )
        {
            while(resultSet.next())
            {
                //Loop over result set
                successClimbDataYear.getData().add(new XYChart.Data<>(resultSet.getString("Expedition Year"),resultSet.getInt("Successful Climbs")));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return successClimbDataYear;
    }

    //Return list of successful Everest expeditions per country
    public static XYChart.Series<String, Integer> getSuccessClimbDataCountry()
    {
        XYChart.Series<String, Integer> successClimbDataCountry = new XYChart.Series<>();

        String sql2 = "SELECT nation AS 'Country', COUNT(success) AS 'Successful Climbs'\n" +
                "FROM expeditions\n" +
                "GROUP BY nation;";

        //Try with resources
        try (
                Connection conn = DriverManager.getConnection(conURL, userName, pw);
                Statement statement=conn.createStatement();
                ResultSet resultSet=statement.executeQuery(sql2);
        )
        {
            while(resultSet.next())
            {
                //Loop over result set
                successClimbDataCountry.getData().add(new XYChart.Data<>(resultSet.getString("Country"),resultSet.getInt("Successful Climbs")));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return successClimbDataCountry;
    }
}
