package com.omernaci.smartcard;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage stage;

	private AnchorPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		initRootLayout();
	}

	private void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/com/omernaci/smartcard/view/ui/MainView.fxml"));
			rootLayout = loader.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout, 600, 400);
			stage.setTitle("Smartcard Operation");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
