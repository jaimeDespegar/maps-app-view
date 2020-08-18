package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import core.Service;
import model.Coordinate;
import presentacion.vista.MainView;
import javax.swing.*;

public class Controlador implements ActionListener
{
	private MainView mainView;
	private Service service;

	public Controlador(MainView mainView, Service service)
	{
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
				Integer fromX = Integer.valueOf(this.mainView.getTextFromX().getText());
				Integer fromY = Integer.valueOf(this.mainView.getTextFromY().getText());
				Integer toX = Integer.valueOf(this.mainView.getTextToX().getText());
				Integer toY = Integer.valueOf(this.mainView.getTextToY().getText());
				Coordinate arrival = new Coordinate(fromX, fromY);
				Coordinate departure = new Coordinate(toX, toY);
				List<Coordinate> road = this.service.getRoad(arrival, departure);
				if (road.isEmpty()) {
					this.showMessage("No se encontro un camino para la ruta seleccionada");
				} else {
					this.mainView.getTextArea().setText(road.stream().map(c -> c.getX()+" - "+c.getY()+"\n").collect(Collectors.joining()));
				}
			} catch (NumberFormatException nfe) {
				this.showMessage("Las coordenadas ingresadas no son correctas");
			}
		}
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}