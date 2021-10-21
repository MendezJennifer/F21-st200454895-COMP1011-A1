package Utilities;

import com.example.f21st200454895comp1011a1.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class SceneChanger {

    //Take title of the scene to change views
    public static void changeScenes(ActionEvent event, String filePath, String title) throws IOException
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(filePath));
        Parent parent=loader.load();

        Scene scene=new Scene(parent);

        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
