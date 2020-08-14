package presentacion.vista;

import views.PanelConfiguration;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewConfiguration extends JFrame {

	private JPanel contentPane;

	public ViewConfiguration(MainView mainView, PanelConfiguration panelConfiguration) {
		super();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 380, 343, 183);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.contentPane.add(panelConfiguration.buildPanel(mainView));
		this.setVisible(true);
	}

}