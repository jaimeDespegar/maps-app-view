package presentacion.vista;

import views.PanelConfiguration;
import views.View;
import javax.swing.*;

public class MainView implements View {

	private JFrame frame;
	private JButton btnSearch, btnSettings;
	private JTextField textFromX, textFromY, textToX, textToY;
    private JTextArea textArea;
	private JPanel panel;
	private ViewConfiguration viewConfiguration;
	private PanelConfiguration panelConfiguration;

	public MainView(PanelConfiguration panelConfig) {
		super();
		initialize();
		this.panelConfiguration = panelConfig;
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

        JLabel lblFrom = new JLabel("Arrival");
        lblFrom.setBounds(20, 26, 113, 14);
        panel.add(lblFrom);

		textFromX = new JTextField();
		textFromX.setBounds(110, 26, 50, 19);
		panel.add(textFromX);
		textFromX.setColumns(10);

		textFromY = new JTextField();
		textFromY.setBounds(170, 26, 50, 19);
		panel.add(textFromY);
		textFromY.setColumns(10);

        JLabel lblTo = new JLabel("Departure");
        lblTo.setBounds(20, 57, 113, 14);
        panel.add(lblTo);

		textToX = new JTextField();
		textToX.setBounds(110, 57, 50, 19);
		panel.add(textToX);
		textToX.setColumns(10);

		textToY = new JTextField();
		textToY.setBounds(170, 57, 50, 19);
		panel.add(textToY);
		textToY.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(230, 53, 89, 23);
		panel.add(btnSearch);

        btnSettings = new JButton("Settings");
        btnSettings.setBounds(325, 53, 100, 23);
        panel.add(btnSettings);

		textArea = new JTextArea();
		textArea.setBounds(110, 90, 314, 160);
		textArea.setColumns(20);
		panel.add(textArea);
	}

    public JTextField getTextFromX() {
        return textFromX;
    }

    public JTextField getTextFromY() {
        return textFromY;
    }

    public JTextField getTextToX() {
        return textToX;
    }

    public JTextField getTextToY() {
        return textToY;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnSettings() {
        return btnSettings;
    }

    @Override
	public void openViewConfiguration() {
		this.viewConfiguration = new ViewConfiguration(this, this.panelConfiguration);
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

}