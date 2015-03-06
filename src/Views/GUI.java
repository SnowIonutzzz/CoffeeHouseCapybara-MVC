/**
 * Created by Mark on 16/02/2015.
 */
package Views;

import Controllers.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.*;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private Visualisation vis;
	RunwayArea runway;
	JTextArea informationTextArea;

	public GUI(RunwayArea runway) {
		this.runway = runway;
	}

	public void init() {
		setTitle("Runway Re-Declaration Tool");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		JPanel content = new JPanel();
		container.add(content);
		content.setLayout(new BorderLayout(0, 0));

		// use this panel for all your GUI stuff
		JPanel panel = new JPanel();
		content.add(panel, BorderLayout.EAST);

		panel.setLayout(new BorderLayout());

		JPanel visPanel = new JPanel();
		visPanel.setLayout(new BorderLayout(0, 0));
		content.add(visPanel, BorderLayout.WEST);

		vis = new Visualisation(runway);
		LwjglAWTCanvas canvas = new LwjglAWTCanvas(vis);
		vis.resize(900, 1024);
		visPanel.setPreferredSize(new Dimension(900, 1024));
		visPanel.add(canvas.getCanvas(), BorderLayout.CENTER);
		this.setVisible(true);
		this.setSize(1280, 1024);

		// Right-Hand Panel Stuff (Swing)
		// ////////////////////////////////////////////
		JPanel calculationsOutputPanel = new JPanel(new GridBagLayout());
		panel.add(calculationsOutputPanel, BorderLayout.CENTER);

		JButton addObButton = new JButton("Set Obstruction");
		addObButton.addMouseListener(new AddListener());
		informationTextArea = new JTextArea();
		informationTextArea.setWrapStyleWord(true);
		// info.setBackground(new Color(50,50,250));
		informationTextArea.setEditable(false);
		GridBagConstraints gbc = new GridBagConstraints();

		int spacing = 1;
		gbc.insets = new Insets(spacing, spacing, spacing, spacing);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 2;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.BOTH;
		calculationsOutputPanel.add(addObButton, gbc);
		gbc.gridy = 1;
		gbc.weighty = 1;
		calculationsOutputPanel.add(informationTextArea, gbc);
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridheight = 3;
		gbc.gridx = 1;
		gbc.gridy = 0;
		calculationsOutputPanel.add(Box.createHorizontalStrut(20), gbc);

		try {
			informationTextArea.setText("Original Runway Parameters:" + "\nRESA: " + runway.getOriginalParameters().resa + "\nLDA: " + runway.getOriginalParameters().lda + "\nTODA: "
					+ runway.getOriginalParameters().toda + "\nTORA: " + runway.getOriginalParameters().tora + "\nASDA: " + runway.getOriginalParameters().asda);
		} catch (Exception e) {
			informationTextArea.setText("No Runway Information to Display");
		}

	}

	public class AddListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			NewObstacleGUI no = new NewObstacleGUI(runway, informationTextArea);
		}
	}

}
