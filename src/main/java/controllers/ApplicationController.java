package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ApplicationController implements Initializable {

	@FXML
	private Label closeLabel;

	@FXML
	private Label minimizeLabel;

	@FXML
	private Label maximizeLabel;

	@FXML
	private GridPane gridTitle;

	private static double xOffset = 0;
	private static double yOffset = 0;
	private boolean maximize = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Cerrar ventana
		closeLabel.setOnMouseClicked((e) -> {
			Stage stage = (Stage) closeLabel.getScene().getWindow();
			stage.close();
		});

		// Mover ventana
		gridTitle.setOnMousePressed((event) -> {
			if (!maximize) {
				Stage stage = (Stage) closeLabel.getScene().getWindow();
				xOffset = stage.getX() - event.getScreenX();
				yOffset = stage.getY() - event.getScreenY();
			}
		});

		// Mover ventana
		gridTitle.setOnMouseDragged((event) -> {
			if (!maximize) {
				Stage stage = (Stage) closeLabel.getScene().getWindow();
				stage.setX(event.getScreenX() + xOffset);
				stage.setY(event.getScreenY() + yOffset);
			}
		});

		// Maximizar
		maximizeLabel.setOnMouseClicked((e) -> {
			Stage stage = (Stage) closeLabel.getScene().getWindow();
			Screen screen = Screen.getPrimary();

			if (!maximize) {
				Rectangle2D bounds = screen.getVisualBounds();
				stage.setX(bounds.getMinX());
				stage.setY(bounds.getMinY());
				stage.setWidth(bounds.getWidth());
				stage.setHeight(bounds.getHeight());
				maximize = true;
			} else {
				stage.setWidth(1280);
				stage.setHeight(720);
				maximize = false;
			}
			;
		});
	}

}
