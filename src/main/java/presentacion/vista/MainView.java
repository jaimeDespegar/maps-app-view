package presentacion.vista;

import core.CustomerClassLoader;
import views.PanelConfiguration;
import views.View;
import javax.swing.*;

public class MainView implements View {

	private JFrame frame;
	private JButton btnSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
	private ViewConfiguration viewConfiguration;

	public MainView() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnSearch = new JButton("Buscar");
		btnSearch.setBounds(190, 227, 89, 23);
		panel.add(btnSearch);

		textField = new JTextField();
		textField.setBounds(110, 166, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 197, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}

	@Override
	public void openViewConfiguration() {
		CustomerClassLoader loader = new CustomerClassLoader(); // ColorViewPanel CalculatorViewPanel
		PanelConfiguration panelConfig = loader.loaded("/home/jaimequispe/ungs/pp2/jars", "implementation.view.CalculatorViewPanel");
		this.viewConfiguration = new ViewConfiguration(this, panelConfig);
	}

	@Override
	public void closeViewConfiguration() {
		this.viewConfiguration.dispose();
	}

	@Override
	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}

	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

	@Override
	public void repaint() {
		this.frame.repaint();
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

}