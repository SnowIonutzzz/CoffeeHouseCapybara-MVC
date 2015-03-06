package Views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controllers.Obstruction;
import Controllers.RunwayArea;
import Models.RunwayParameters;

public class NewObstacleGUI extends JFrame {

	JComboBox preDefinedCombo;
	ArrayList<Obstruction> preDefined;
	ArrayList<String> preDefinedNames;

	RunwayArea runway;
	JTextArea informationTextArea;

	JTextArea info;

	JCheckBox tb1;

	JTextField ta2;
	JTextField ta3;
	JTextField ta4;

	JTextField ta5;
	JTextField ta6;
	JTextField ta7;
	JTextField ta8;
	JTextField ta9;

	public NewObstacleGUI(RunwayArea runway, JTextArea informationTextArea) {
		this.runway = runway;
		this.informationTextArea = informationTextArea;
		preDefined = new ArrayList<Obstruction>();
		preDefinedNames = new ArrayList<String>();
		readPreDefined();
		init();
	}

	public void readPreDefined() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("predefinedObstacles.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitLine = line.split(",");
				try {
					Obstruction o = new Obstruction(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]), Double.parseDouble(splitLine[3]), Double.parseDouble(splitLine[4]),
							Double.parseDouble(splitLine[5]), Double.parseDouble(splitLine[6]), Double.parseDouble(splitLine[7]));
					preDefined.add(o);
					preDefinedNames.add(splitLine[0]);
				} catch (Exception e) {
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void init() {
		JPanel obstacleAddPanel = new JPanel(new GridBagLayout());
		this.setTitle("Set Obstacle");

		preDefinedCombo = new JComboBox(preDefinedNames.toArray());
		preDefinedCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obstruction selected = preDefined.get(preDefinedCombo.getSelectedIndex());
				ta2.setText(selected.getLength().toString());
				ta3.setText(selected.getWidth().toString());
				ta4.setText(selected.getHeight().toString());
				ta5.setText(selected.getPositionX().toString());
				ta6.setText(selected.getPositionY().toString());
				// ta7.setText(selected.rotation.toString());
				ta8.setText(selected.getPositionHighestPointX().toString());
				ta9.setText(selected.getPositionHighestPointY().toString());
			}
		});

		JLabel l2 = new JLabel("Obstacle Length (Cockpit to Tail):");
		JLabel l3 = new JLabel("Obstacle Width (Wingspan):");
		JLabel l4 = new JLabel("Obstacle Height (At highest Point):");

		JLabel l5 = new JLabel("Obstacle Position X:");
		JLabel l6 = new JLabel("Obstacle Position Y:");
		JLabel l7 = new JLabel("Obstacle Rotation:");
		JLabel l8 = new JLabel("Highest PointX");
		JLabel l11 = new JLabel("Highest PointY:");

		JLabel l9 = new JLabel("Approach from Left");

		tb1 = new JCheckBox();

		Obstruction o = runway.getFirstObstruction();
		if (o == null) {
			ta2 = new JTextField(10);
			ta3 = new JTextField(10);
			ta4 = new JTextField(10);

			ta5 = new JTextField(10);
			ta6 = new JTextField(10);
			ta7 = new JTextField(10);
			ta8 = new JTextField(10);
			ta9 = new JTextField(10);
		} else {
			ta2 = new JTextField(o.getLength().toString(), 10);
			ta3 = new JTextField(o.getWidth().toString(), 10);
			ta4 = new JTextField(o.getHeight().toString(), 10);

			ta5 = new JTextField(o.getPositionX().toString(), 10);
			ta6 = new JTextField(o.getPositionY().toString(), 10);
			ta7 = new JTextField("0.0", 10);
			ta8 = new JTextField(o.getPositionHighestPointX().toString(), 10);
			ta9 = new JTextField(o.getPositionHighestPointY().toString(), 10);
		}
		ta7.setEditable(false);
		ta7.setEnabled(false);
		tb1.setSelected(runway.getApproachFromLeft());
		

		JButton createButton = new JButton("Set Obstacle");

		info = new JTextArea("Warning: This will override the existing obstacle.");
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		// info = new JTextArea("Note: This does not update\n" +
		// "the visualisation, it simply\n" + "calculates new values in a\n" +
		// "separate environment / scenario");

		GridBagConstraints gbc = new GridBagConstraints();

		int spacing = 1;
		gbc.insets = new Insets(spacing, spacing, spacing, spacing);
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 15;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		obstacleAddPanel.add(Box.createHorizontalStrut(20), gbc);
		gbc.gridx = 0;
		gbc.weightx = 2;
		obstacleAddPanel.add(Box.createHorizontalStrut(20), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		obstacleAddPanel.add(preDefinedCombo, gbc);
		gbc.gridy = 12;
		obstacleAddPanel.add(createButton, gbc);
		gbc.gridy = 13;
		obstacleAddPanel.add(info, gbc);
		gbc.gridy = 4;

		gbc.weightx = 0;

		obstacleAddPanel.add(Box.createVerticalStrut(3), gbc);
		gbc.gridy = 9;
		obstacleAddPanel.add(Box.createVerticalStrut(3), gbc);
		gbc.gridwidth = 1;

		gbc.gridy = 1;
		obstacleAddPanel.add(l2, gbc);
		gbc.gridy = 2;
		obstacleAddPanel.add(l3, gbc);
		gbc.gridy = 3;
		obstacleAddPanel.add(l4, gbc);

		gbc.gridy = 5;
		obstacleAddPanel.add(l5, gbc);
		gbc.gridy = 6;
		obstacleAddPanel.add(l6, gbc);
		gbc.gridy = 7;
		obstacleAddPanel.add(l7, gbc);
		gbc.gridy = 8;
		obstacleAddPanel.add(l8, gbc);
		gbc.gridy = 9;
		obstacleAddPanel.add(l11, gbc);
		gbc.gridy = 10;
		obstacleAddPanel.add(l9, gbc);

		gbc.gridx = 2;
		gbc.weightx = 3;

		gbc.gridy = 1;
		obstacleAddPanel.add(ta2, gbc);
		gbc.gridy = 2;
		obstacleAddPanel.add(ta3, gbc);
		gbc.gridy = 3;
		obstacleAddPanel.add(ta4, gbc);

		gbc.gridy = 5;
		obstacleAddPanel.add(ta5, gbc);
		gbc.gridy = 6;
		obstacleAddPanel.add(ta6, gbc);
		gbc.gridy = 7;
		obstacleAddPanel.add(ta7, gbc);
		gbc.gridy = 8;
		obstacleAddPanel.add(ta8, gbc);
		gbc.gridy = 9;
		obstacleAddPanel.add(ta9, gbc);
		gbc.gridy = 10;
		obstacleAddPanel.add(tb1, gbc);

		createButton.addMouseListener(new createListener());

		this.setContentPane(obstacleAddPanel);
		this.setSize(280, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public class createListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// info.setText("Note: This does not update\nthe visualisation, it simply\ncalculates new values in a\nseparate environment / scenario");

			try {
				Obstruction o;
				o = new Obstruction(Double.parseDouble(ta3.getText()), Double.parseDouble(ta4.getText()), Double.parseDouble(ta2.getText()), Double.parseDouble(ta5.getText()), Double.parseDouble(ta6
						.getText()), Double.parseDouble(ta8.getText()), Double.parseDouble(ta9.getText()));

				if(tb1.isSelected()){
					runway.setApproachFromLeft(true);
				}else{
					runway.setApproachFromLeft(false);
				}

				runway.addObstruction(o);

				String[] parameterNames = new String[5];
				RunwayParameters[] rp = new RunwayParameters[5];
				int i = 0;

				parameterNames[i] = "Oringal Runway Parameters";
				runway.declareOriginalParameters();
				rp[i] = runway.getOriginalParameters();

				i += 1;
				parameterNames[i] = "Landing Runway Parameters (Left Approach)";
				runway.redeclareForLandingFromLeft();
				rp[i] = runway.getParametersApproachFromLeft().clone();

				i += 1;
				parameterNames[i] = "Landing Runway Parameters (Right Approach)";
				runway.redeclareForLandingFromRight();
				rp[i] = runway.getParametersApproachFromRight().clone();

				i += 1;
				parameterNames[i] = "TakeOff Runway Parameters (Left Approach)";
				runway.redeclareForTakeOffFromLeft();
				rp[i] = runway.getParametersApproachFromLeft().clone();

				i += 1;
				parameterNames[i] = "TakeOff Runway Parameters (Right Approach)";
				runway.redeclareForTakeOffFromRight();
				rp[i] = runway.getParametersApproachFromRight().clone();

				informationTextArea.setText("");

				for (int u = 0; u < parameterNames.length; u += 1) {
					informationTextArea.append(parameterNames[u] + ":");
					RunwayParameters par = rp[u];

					if (par.resa != null) {
						informationTextArea.append("\nRESA: " + par.resa);
					}
					if (par.lda != null) {
						informationTextArea.append("\nLDA: " + par.lda);
					}
					if (par.toda != null) {
						informationTextArea.append("\nTODA: " + par.toda);
					}
					if (par.tora != null) {
						informationTextArea.append("\nTORA: " + par.tora);
					}
					if (par.asda != null) {
						informationTextArea.append("\nASDA: " + par.asda);
					}

					informationTextArea.append("\n\n");

				}

			} catch (Exception e1) {
				info.append("\n\nUNABLE TO PROCESS YOUR REQUEST\nTHE VALUES ENTERED WERE NOT\nVALID REAL NUMBERS");
			}

		}
	}

}
