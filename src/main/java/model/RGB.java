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

public class RGB {
	
	private String pathDirectorio;
	private String pathFichero;
	private DoubleProperty red;
	private DoubleProperty blue;
	private DoubleProperty green;
	private DoubleProperty height;
	private DoubleProperty width;
	private DoubleProperty locationX;
	private DoubleProperty locationY;
	
	public RGB() {
		pathDirectorio = System.getProperty("user.home")+ File.separator + ".VentanaConMemoria";
		pathFichero = pathDirectorio + File.separator + "ventana.config";
		
		red = new SimpleDoubleProperty();
		blue = new SimpleDoubleProperty();
		green = new SimpleDoubleProperty();
		height = new SimpleDoubleProperty();
		width = new SimpleDoubleProperty();
		locationX = new SimpleDoubleProperty();
		locationY = new SimpleDoubleProperty();
	}
	
	

	public DoubleProperty getRed() {
		return red;
	}

	public void setRed(DoubleProperty red) {
		this.red = red;
	}

	public DoubleProperty getBlue() {
		return blue;
	}

	public void setBlue(DoubleProperty blue) {
		this.blue = blue;
	}

	public DoubleProperty getGreen() {
		return green;
	}

	public void setGreen(DoubleProperty green) {
		this.green = green;
	}

	public DoubleProperty getHeight() {
		return height;
	}

	public void setHeight(DoubleProperty height) {
		this.height = height;
	}

	public DoubleProperty getWidth() {
		return width;
	}

	public void setWidth(DoubleProperty width) {
		this.width = width;
	}

	public DoubleProperty getLocationX() {
		return locationX;
	}

	public void setLocationX(DoubleProperty locationX) {
		this.locationX = locationX;
	}

	public DoubleProperty getLocationY() {
		return locationY;
	}

	public void setLocationY(DoubleProperty locationY) {
		this.locationY = locationY;
	}
	

	public void gestionarFichero() {
		try {
			
			File directorio = new File(pathDirectorio);
			directorio.mkdir();
			
			File config = new File(pathFichero);
			boolean creacion = config.createNewFile();
			
			if(creacion) {
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
			} else {
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
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarFichero() {
		try (OutputStream output = new FileOutputStream(pathFichero)) {
			Properties prop = new Properties();
			
			prop.setProperty("background.red", red.get()+"");
			prop.setProperty("background.blue", blue.get()+"");
			prop.setProperty("background.green", green.get()+"");
			prop.setProperty("size.width", width.get()+"");
			prop.setProperty("size.height", height.get()+"");
			prop.setProperty("location.x", locationX.get()+"");
			prop.setProperty("location.y", locationY.get()+"");
			
			prop.store(output, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
