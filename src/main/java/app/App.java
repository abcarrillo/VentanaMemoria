package app;

import controller.RGBController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	private RGBController controller;

	@Override
	public void init() throws Exception {
		controller = new RGBController();
		controller.getModel().gestionarFichero();
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Scene scene = new Scene(controller.getView(), 400, 400);
		
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	@Override
	public void stop() throws Exception {
		controller.getModel().guardarFichero();
	}

	public static void main(String[] args) {
		launch(args);
	}

}