package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import core.Service;
import presentacion.vista.MainView;

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
			this.mainView.openViewConfiguration();
		}
	}

}