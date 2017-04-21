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

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

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
		  INDArray nd = Nd4j.create(new float[]{1,2},new int[]{1, 2}); //vector as row
	        INDArray nd2 = Nd4j.create(new float[]{3,4},new int[]{2, 1}); //vector as column
	        INDArray nd3 = Nd4j.create(new float[]{1,3,2,4},new int[]{2,2}); //elements arranged column major
	        INDArray nd4 = Nd4j.create(new float[]{3,4,5,7,6,6},new int[]{3, 2});

	        System.out.println(nd);
	        System.out.println(nd2);
	        System.out.println(nd3);
	        System.out.println(nd4);
	        INDArray ndv = nd.mmul(nd2);

	        System.out.println(ndv);

		new Window();
	}

}
