package main;

import core.ClassFactory;
import core.ICircuitBreaker;
import core.Service;
import factory.CircuitBreakerFactory;
import factory.ClassLoaderFactory;
import factory.LocationServiceFactory;
import model.Location;
import presentacion.controlador.Controlador;
import presentacion.vista.MainView;
import views.MyViewComponent;

public class Main 
{

	public static void main(String[] args) 
	{
		String path = "/home/jaimequispe/ungs/pp2/jars";
		String classProvider = "implementation.LocationMock"; // LocationCalculatorConnector   ApiLocationMock
		String classSettings = "implementation.view.LoginComponent"; // ColorComponent 	 LoginComponent

		ClassFactory loaderFactory = new ClassLoaderFactory();
		Location connector = loaderFactory.build(path, classProvider);
		ICircuitBreaker circuitBreaker = new CircuitBreakerFactory().build(connector);
		Service service = new LocationServiceFactory().build(circuitBreaker);
		MyViewComponent loginComponent = loaderFactory.build(path, classSettings);
		System.out.println(loginComponent.toString());
		MainView mainView = new MainView(loginComponent);
		Controlador controlador = new Controlador(mainView, service);
		controlador.inicializar();
	}

}