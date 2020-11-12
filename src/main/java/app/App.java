package app;


import controller.RGBController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Config;

public class App extends Application{
	
	private RGBController controller;
	private Config config = new Config();

	@Override
	public void init() throws Exception {
		config.cargarFichero();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new RGBController();
		
		controller.getModel().redProperty().bindBidirectional(config.redProperty());
		controller.getModel().greenProperty().bindBidirectional(config.greenProperty());
		controller.getModel().blueProperty().bindBidirectional(config.blueProperty());

		//Bindeo y set de la localizacion de la ventana en la pantalla
		primaryStage.setX(config.getLocationX());
		primaryStage.setY(config.getLocationY());
		
		config.locationXProperty().bind(primaryStage.xProperty());
		config.locationYProperty().bind(primaryStage.yProperty());

		//Creacion de la escena de la ventana y bindeo de su tama�o
		Scene scene = new Scene(controller.getView(), config.getWidth(), config.getHeight());
		
		config.heightProperty().bind(scene.heightProperty());
		config.widthProperty().bind(scene.widthProperty());
		
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		config.guardarFichero();
	}

	public static void main(String[] args) {
		launch(args);
	}

}