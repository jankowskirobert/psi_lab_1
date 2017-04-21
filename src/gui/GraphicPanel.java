package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphicPanel extends JPanel {

	private final Dimension PANE_SIZE = new Dimension(300, 600);

	public GraphicPanel() {
		super();
		initUI();
	}

	private void initUI() {
		this.setMinimumSize(PANE_SIZE);
		this.setPreferredSize(PANE_SIZE);
		this.setMaximumSize(PANE_SIZE);
	}

	@Override
	public void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawRect(0, 0, 300, 600);
		arg0.setColor(Color.BLUE);
	}

}
