package main;

import core.Service;
import factory.LocationServiceFactory;
import factory.ProviderFactory;
import model.Coordinate;
import presentacion.controlador.Controlador;
import presentacion.vista.MainView;

public class Main 
{

	public static void main(String[] args) 
	{
		MainView mainView = new MainView();
		Service service = new LocationServiceFactory(new ProviderFactory()).build();
		service.getRoad(new Coordinate(1, 2), new Coordinate(3, 4)).forEach(System.out::println);;
		
		Controlador controlador = new Controlador(mainView, service);
		controlador.inicializar();
	}

}