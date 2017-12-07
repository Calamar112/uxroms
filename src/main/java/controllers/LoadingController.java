package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LoadingController implements Initializable {
	
	@FXML
	private Label loadingContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Font.loadFont(getClass().getResource("/fonts/AdventPro-Light.ttf").toExternalForm(), 12);

		Runnable runable1 = () -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Platform.runLater(()-> loadingContent.setText("Esperando conexion..."));
		};
		
		Thread t = new Thread(runable1);
		t.start();
	}
}
