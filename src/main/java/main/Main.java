package main;

import core.ClassFactory;
import core.Service;
import factory.ClassLoaderFactory;
import factory.LocationServiceFactory;
import model.Coordinate;
import model.LocationConnector;
import presentacion.controlador.Controlador;
import presentacion.vista.MainView;
import views.PanelConfiguration;

public class Main 
{

	public static void main(String[] args) 
	{
		String path = "/home/jaimequispe/ungs/pp2/jars";
		String classProvider = "implementation.LocationCalculatorConnector"; // LocationCalculatorConnector   ApiLocationMock
		String classPanel = "implementation.view.ColorViewPanel"; // CalculatorViewPanel  ColorViewPanel

		ClassFactory loaderFactory = new ClassLoaderFactory();
		LocationConnector connector = loaderFactory.build(path, classProvider);
		Service service = new LocationServiceFactory().build(connector);
		PanelConfiguration panelConfiguration = loaderFactory.build(path, classPanel);

		MainView mainView = new MainView(panelConfiguration);
		Controlador controlador = new Controlador(mainView, service);
		service.getRoad(new Coordinate(11, 22), new Coordinate(33, 44)).forEach(System.out::println);
		controlador.inicializar();
	}

}