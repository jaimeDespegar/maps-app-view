package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import core.Service;
import model.Coordinate;
import presentacion.vista.MainView;
import javax.swing.*;

public class Controlador implements ActionListener {
	private MainView mainView;
	private Service service;

	public Controlador(MainView mainView, Service service) {
		this.mainView = mainView;
		this.mainView.getBtnSearch().addActionListener(this);
		this.service = service;
	}

	public void inicializar() {
		this.mainView.show();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.mainView.getBtnSearch())
		{
			try {
				Coordinate arrival = this.buildCoordinate(this.mainView.getTextFromX(), this.mainView.getTextFromY());
				Coordinate departure = this.buildCoordinate(this.mainView.getTextToX(), this.mainView.getTextToY());
				List<Coordinate> road = this.service.getRoad(arrival, departure);
				if (road.isEmpty()) {
					this.showMessage("No se encontro un camino para la ruta seleccionada");
				} else {
					String roadFormated = road.stream().map(c -> c.getX()+" - "+c.getY()+"\n").collect(Collectors.joining());
					this.mainView.getTextArea().setText(roadFormated);
				}
			} catch (NumberFormatException nfe) {
				this.showMessage("Las coordenadas ingresadas no son validas");
			}
		}
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private Coordinate buildCoordinate(JTextField textX, JTextField textY) {
		Integer coordinateX = Integer.valueOf(textX.getText());
		Integer coordinateY = Integer.valueOf(textY.getText());
		return new Coordinate(coordinateX, coordinateY);
	}

}