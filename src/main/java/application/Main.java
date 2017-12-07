package application;
	
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
			
	@Override
	public void start(Stage primaryStage) throws Exception {		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages_en");

		Parent root = FXMLLoader.load(getClass().getResource("/views/Application.fxml"), resourceBundle);
		Scene scene = new Scene(root);
		
		
		//CSS Styles
		scene.getStylesheets().add("/styles/GridModena.css");

        primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
