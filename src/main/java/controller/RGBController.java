package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import model.RGB;

public class RGBController implements Initializable{
	
	@FXML
	private AnchorPane view;
	
	@FXML
    private Slider slRed;
	
	@FXML
    private Slider slGreen;

    @FXML
    private Slider slBlue;
	
	private RGB rgb = new RGB();
	
	public RGBController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public RGB getModel() {
		return rgb;
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		rgb.gestionarFichero();
		
		view.setStyle("-fx-background-color: rgb(" + rgb.getRed().get() + "," + rgb.getGreen().get() + ", " + rgb.getBlue().get() + ");");
		slRed.valueProperty().bindBidirectional(rgb.getRed());
		slBlue.valueProperty().bindBidirectional(rgb.getBlue());
		slGreen.valueProperty().bindBidirectional(rgb.getGreen());
	}
	
	

	public AnchorPane getView() {
		return view;
	}
}
