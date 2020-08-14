package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import core.Service;
import model.Coordinate;
import presentacion.vista.MainView;

public class Controlador implements ActionListener
{
	private MainView mainView;
	private Service service;

	public Controlador(MainView mainView, Service service)
	{
		this.mainView = mainView;
		this.mainView.getBtnSearch().addActionListener(this);
		this.mainView.getBtnSettings().addActionListener(this);
		this.service = service;
	}

	public void inicializar() {
		this.mainView.show();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.mainView.getBtnSearch())
		{
			Integer fromX = Integer.valueOf(this.mainView.getTextFromX().getText());
			Integer fromY = Integer.valueOf(this.mainView.getTextFromY().getText());
			Integer toX = Integer.valueOf(this.mainView.getTextToX().getText());
			Integer toY = Integer.valueOf(this.mainView.getTextToY().getText());
			Coordinate arrival = new Coordinate(fromX, fromY);
			Coordinate departure = new Coordinate(toX, toY);
			List<Coordinate> road = this.service.getRoad(arrival, departure);
			this.mainView.getTextArea().setText(road.stream().map(c -> c.getX()+" - "+c.getY()+"\n").collect(Collectors.joining()));
		}
		if(e.getSource() == this.mainView.getBtnSettings())
		{
			this.mainView.openViewConfiguration();
		}
	}

}