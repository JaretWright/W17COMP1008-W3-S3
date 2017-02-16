package w17jan25;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author JWright
 */
public class LaunchCreateEmployeeView extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CreateEmployeeView.fxml"));
        
        AnchorPane createEmployeeLayout = loader.load();
        
        Scene createEmployeeScene = new Scene(createEmployeeLayout);
        primaryStage.setScene(createEmployeeScene);
        primaryStage.setTitle("Create new employee");
        primaryStage.show();
        
    }
    
}
