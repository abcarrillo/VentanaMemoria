package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Config {

	private String pathDirectorio;
	private String pathFichero;
	private DoubleProperty red;
	private DoubleProperty blue;
	private DoubleProperty green;
	private DoubleProperty height;
	private DoubleProperty width;
	private DoubleProperty locationX;
	private DoubleProperty locationY;

	public Config() {
		pathDirectorio = System.getProperty("user.home") + File.separator + ".VentanaConMemoria";
		pathFichero = pathDirectorio + File.separator + "ventana.config";

		red = new SimpleDoubleProperty();
		blue = new SimpleDoubleProperty();
		green = new SimpleDoubleProperty();
		height = new SimpleDoubleProperty();
		width = new SimpleDoubleProperty();
		locationX = new SimpleDoubleProperty();
		locationY = new SimpleDoubleProperty();
	}

	public void cargarFichero() {
		try {

			File directorio = new File(pathDirectorio);
			directorio.mkdir();

			File config = new File(pathFichero);
			boolean creacion = config.createNewFile();

			if (creacion) {
				try (OutputStream output = new FileOutputStream(config.getPath())) {
					Properties prop = new Properties();

					prop.setProperty("background.red", "0");
					prop.setProperty("background.blue", "0");
					prop.setProperty("background.green", "0");
					prop.setProperty("size.width", "428");
					prop.setProperty("size.height", "278");
					prop.setProperty("location.x", "440");
					prop.setProperty("location.y", "244");

					prop.store(output, null);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			try (InputStream input = new FileInputStream(pathFichero)) {

				Properties prop = new Properties();

				// load a properties file
				prop.load(input);

				red.set(Double.parseDouble(prop.getProperty("background.red")));
				blue.set(Double.parseDouble(prop.getProperty("background.blue")));
				green.set(Double.parseDouble(prop.getProperty("background.green")));
				width.set(Double.parseDouble(prop.getProperty("size.width")));
				height.set(Double.parseDouble(prop.getProperty("size.height")));
				locationX.set(Double.parseDouble(prop.getProperty("location.x")));
				locationY.set(Double.parseDouble(prop.getProperty("location.y")));

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void guardarFichero() {
		try (OutputStream output = new FileOutputStream(pathFichero)) {
			Properties prop = new Properties();

			prop.setProperty("background.red", red.get() + "");
			prop.setProperty("background.blue", blue.get() + "");
			prop.setProperty("background.green", green.get() + "");
			prop.setProperty("size.width", width.get() + "");
			prop.setProperty("size.height", height.get() + "");
			prop.setProperty("location.x", locationX.get() + "");
			prop.setProperty("location.y", locationY.get() + "");

			prop.store(output, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final DoubleProperty redProperty() {
		return this.red;
	}

	public final double getRed() {
		return this.redProperty().get();
	}

	public final void setRed(final double red) {
		this.redProperty().set(red);
	}

	public final DoubleProperty blueProperty() {
		return this.blue;
	}

	public final double getBlue() {
		return this.blueProperty().get();
	}

	public final void setBlue(final double blue) {
		this.blueProperty().set(blue);
	}

	public final DoubleProperty greenProperty() {
		return this.green;
	}

	public final double getGreen() {
		return this.greenProperty().get();
	}

	public final void setGreen(final double green) {
		this.greenProperty().set(green);
	}

	public final DoubleProperty heightProperty() {
		return this.height;
	}

	public final double getHeight() {
		return this.heightProperty().get();
	}

	public final void setHeight(final double height) {
		this.heightProperty().set(height);
	}

	public final DoubleProperty widthProperty() {
		return this.width;
	}

	public final double getWidth() {
		return this.widthProperty().get();
	}

	public final void setWidth(final double width) {
		this.widthProperty().set(width);
	}

	public final DoubleProperty locationXProperty() {
		return this.locationX;
	}

	public final double getLocationX() {
		return this.locationXProperty().get();
	}

	public final void setLocationX(final double locationX) {
		this.locationXProperty().set(locationX);
	}

	public final DoubleProperty locationYProperty() {
		return this.locationY;
	}

	public final double getLocationY() {
		return this.locationYProperty().get();
	}

	public final void setLocationY(final double locationY) {
		this.locationYProperty().set(locationY);
	}

}
