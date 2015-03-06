	package Controllers;

import Views.*;
import Models.*;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Views.GUI;

public class Main {

	public static void main(String[] args) {

		try {
			// Set system Look and Feel:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RunwayArea runway = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
				runway.setPlaneTakingOff(new Plane(250.0));
				
				Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1000.0, 4.0, 0.0);
				runway.addObstruction(o);
				// runway.redeclareForLandingFromLeft();

				GUI gui = new GUI(runway);
				gui.init();
			}
		});
	}
}