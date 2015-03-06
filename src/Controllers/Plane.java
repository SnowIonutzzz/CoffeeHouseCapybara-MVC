package Controllers;

import Models.PlaneModel;

public class Plane {
	private PlaneModel myModel;
	
	public Plane(Double blastDistance){
		myModel = new PlaneModel();
		myModel.setBlastDistance(blastDistance);
	}
	
	public Double getBlastDistance(){
		return myModel.getBlastDistance();
	}
}
