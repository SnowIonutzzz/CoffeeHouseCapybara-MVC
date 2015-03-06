package Controllers;

import java.util.ArrayList;

import Controllers.Plane;
import Models.RunwayAreaModel;
import Models.RunwayParameters;

public class RunwayArea {
	private RunwayAreaModel myModel;
	
	public RunwayArea(int runwayID, Double areaWidth, Double areaLength, Double runwayLength, Double runwayWidth, Double runwayStartX, Double centrelineStartX, Double runwayEndX,
					  Double centrelineEndX, Double runwayCentrelineStartY, Double stopwayLStartX, Double stopwayLEndX, Double stopwayRStartX, Double stopwayREndX) {
		
		// Initialise Variables:
		myModel = new RunwayAreaModel();
		
		myModel.setRunwayID(runwayID);
		myModel.setAreaWidth(areaWidth);
		myModel.setAreaLength(areaLength);
		myModel.setRunwayLength(runwayLength);
		myModel.setRunwayWidth(runwayWidth);
		myModel.setRunwayStartX(runwayStartX);
		myModel.setCentrelineStartX(centrelineStartX);
		myModel.setRunwayEndX(runwayEndX);
		myModel.setCentrelineEndX(centrelineEndX);
		myModel.setRunwayCentrelineStartY(runwayCentrelineStartY);
		myModel.setStopwayLStartX(stopwayLStartX);
		myModel.setStopwayLEndX(stopwayLEndX);
		myModel.setStopwayRStartX(stopwayRStartX);
		myModel.setStopwayREndX(stopwayREndX);

		myModel.declareOriginalParameters();
	}

	public boolean isDeclaredForRight() {
		return myModel.getParametersApproachFromRightValid();
	}
	

	public boolean getApproachFromLeft(){
		return myModel.getApproachFromLeft();
	}
	
	public Double getAreaLength(){
		return myModel.getAreaLength();
	}
	
	public Double getAreaWidth(){
		return myModel.getAreaWidth();
	}
	
	
	public void setPlaneTakingOff (Plane receivedPlane) {
		myModel.setPlaneTakingOff (receivedPlane);
	}
	
	public void setApproachFromLeft(boolean receivedStatus){
		myModel.setApproachFromLeft(receivedStatus);
	}
	
	
	
	public void redeclareForLandingFromLeft() {
		myModel.redeclareForLandingFromLeft();
	}

	public void redeclareForLandingFromRight() {
		myModel.redeclareForLandingFromRight();
	}

	public void redeclareForTakeOffFromLeft() {
		myModel.redeclareForTakeOffFromLeft();
	}

	public void redeclareForTakeOffFromRight() {
		myModel.redeclareForTakeOffFromRight();
	}
	

	
	public Obstruction getFirstObstruction() {
		return myModel.getFirstObstruction();
	}
	
	public void addObstruction(Obstruction obstruction) {
		myModel.addObstruction(obstruction);
	}

	public void removeObstruction(int obstructionID) {
		myModel.removeObstruction(obstructionID);
	}



	public RunwayParameters getOriginalParameters() throws Exception {
		return myModel.getOriginalParameters();
	}

	public RunwayParameters getParametersApproachFromLeft() throws Exception {
		return myModel.getParametersApproachFromLeft();
	}

	public RunwayParameters getParametersApproachFromRight() throws Exception {
		return myModel.getParametersApproachFromRight();
	}
	
	public void declareOriginalParameters(){
		myModel.declareOriginalParameters();
	}
}
