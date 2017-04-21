package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.commands.AddCityPointCommand;
import gui.commands.GraphicCommand;

public class PointControlPanel extends JPanel implements ActionListener {
	private final JButton addPoint = new JButton("Add Point");
	private final JTextField pointLocationX = new JTextField();
	private final JTextField pointLocationY = new JTextField();
	
	private JPanel graphic;

	public PointControlPanel(JPanel graphic) {
		super();
		this.graphic = graphic;
		initUI();
	}

	private void initUI() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(addPoint);
		this.add(pointLocationX);
		this.add(pointLocationY);
		
		this.addPoint.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addPoint)) {
			GraphicCommand command = new AddCityPointCommand(new Point(5, 5));
			command.setGraphic(graphic.getGraphics());
			command.execute();
		}

	}

}
