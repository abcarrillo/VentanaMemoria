package app;

import controller.RGBController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
		
		//Bindeo y set de la localizacion de la ventana en la pantalla
		primaryStage.setX(controller.getModel().getLocationX().get());
		primaryStage.setY(controller.getModel().getLocationY().get());
		controller.getModel().getLocationX().bind(primaryStage.xProperty());
		controller.getModel().getLocationY().bind(primaryStage.yProperty());
		
		//Creacion de la escena de la ventana y bindeo de su tamaño
		Scene scene = new Scene(controller.getView(), controller.getModel().getWidth().get(), controller.getModel().getHeight().get());
		controller.getModel().getHeight().bind(scene.heightProperty());
		controller.getModel().getWidth().bind(scene.widthProperty());
		
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