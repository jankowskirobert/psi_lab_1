package gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.commands.AddCityPointCommand;
import gui.commands.GraphicCommand;

public class Window extends JFrame {
	private final JPanel graphic = new GraphicPanel();
	private final JPanel graphicOptions = new PointControlPanel(graphic);

	public Window() throws HeadlessException {
		super();
		initUI();
	}

	private void initUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.add(graphic, BorderLayout.CENTER);
		this.add(graphicOptions, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		new Window();
	}

}
