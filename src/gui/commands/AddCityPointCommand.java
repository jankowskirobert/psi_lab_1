package gui.commands;

import java.awt.Graphics;
import java.awt.Point;

public class AddCityPointCommand implements GraphicCommand {

	private Point point;
	private Graphics graph;

	public AddCityPointCommand(Point point) {
		super();
		this.point = point;
	}

	@Override
	public void execute() {
		graph.drawOval(point.x, point.y, 3, 3);
	}

	@Override
	public void setGraphic(Graphics gr) {
		this.graph = gr;
	}

}
