package Models;

import java.util.ArrayList;

import Controllers.Obstruction;
import Controllers.Plane;

public class RunwayAreaModel {
	// Passed Objects:
	// ////////////////////////////////////////////////////////////////////////////////////
	//	Logs logs = new Logs();

	// Runway Variables: ///// (These are fixed for any given runway)
	// ///////////////////////////////////////
	public Plane planeTakingOff;

	int runwayID;

	private Double areaWidth;
	private Double areaLength;

	private Double runwayLength;
	private Double runwayWidth;

	private Double runwayStartX;
	private Double centrelineStartX;
	private Double runwayEndX;
	private Double centrelineEndX;
	private Double runwayCentrelineStartY;
	private Double stopwayLStartX;
	private Double stopwayLEndX;
	private Double stopwayRStartX;
	private Double stopwayREndX;

	private Double runwayStripLength;
	
	private Boolean approachFromLeft = true;

	// Parameters are valid if no obstacles have been added or removed since
	// last valid.
	private Boolean parametersValid;

	// Runway Parameters:
	// ///////////////////////////////////////////////////////////////////////////////////
	private RunwayParameters originalParameters;
	private RunwayParameters parametersApproachFromLeft;
	private RunwayParameters parametersApproachFromRight;
	private Boolean originalParametersValid = false;
	private Boolean parametersApproachFromLeftValid = false;
	private Boolean parametersApproachFromRightValid = false;

	// Runway Parameters:
	// ///////////////////////////////////////////////////////////////////////////////////
	private int nextObstructionID = 1;
	private ArrayList<Obstruction> obstructions = new ArrayList<Obstruction>();

		
	// Constructor
	public RunwayAreaModel(){
		originalParameters = new RunwayParameters();
		parametersApproachFromLeft = new RunwayParameters();
		parametersApproachFromRight = new RunwayParameters();
	}
	

	// Set Methods
	public void setRunwayID( int receivedRunwayID ){
		this.runwayID = receivedRunwayID;
	}
	
	public void setApproachFromLeft(boolean receivedStatus){
		this.approachFromLeft = receivedStatus;
	}
	
	public void setAreaWidth( Double receivedAreaWidth ){
		this.areaWidth = receivedAreaWidth;
	}
	
	public void setAreaLength( Double receivedAreaLength ){
		this.areaLength = receivedAreaLength;
	}
	
	public void setRunwayLength( Double receivedRunwayLength ){
		this.runwayLength = receivedRunwayLength;
	}
	
	public void setRunwayWidth( Double receivedRunwayWidth ){
		this.runwayWidth = receivedRunwayWidth;
	}
	
	public void setRunwayStartX( Double receivedRunwayStartX ){
		this.runwayStartX = receivedRunwayStartX;
	}
	
	public void setCentrelineStartX( Double receivedCentrelineStartX ){
		this.centrelineStartX = receivedCentrelineStartX;
	}
	
	public void setRunwayEndX( Double receivedRunwayEndX ){
		this.runwayEndX = receivedRunwayEndX;
	}
	
	public void setCentrelineEndX (Double receivedCentrelineEndX){
		this.centrelineEndX = receivedCentrelineEndX;
	}
	
	public void setRunwayCentrelineStartY (Double receivedRunwayCentrelineStartY){
		this.runwayCentrelineStartY = receivedRunwayCentrelineStartY;
	}
	
	public void setStopwayLStartX (Double receivedStopwayLStartX){
		this.stopwayLStartX = receivedStopwayLStartX;
	}
	
	public void setStopwayLEndX (Double receivedStopwayLEndX){
		this.stopwayLEndX = receivedStopwayLEndX;
	}
	
	public void setStopwayRStartX (Double receivedStopwayRStartX){
		this.stopwayRStartX = receivedStopwayRStartX;
	}
	
	public void setStopwayREndX (Double receivedStopwayREndX){
		this.stopwayREndX = receivedStopwayREndX;
	}
	
	public void setPlaneTakingOff(Plane receivedPlane) {
		this.planeTakingOff = receivedPlane;
	}
	
	
	// Get Methods
	public boolean getApproachFromLeft(){
		return this.approachFromLeft;
	}
	
	public int getRunwayID (){
		return this.runwayID;
	}
	
	public Double getAreaWidth (){
		return this.areaWidth;
	}
	
	public Double getAreaLength (){
		return this.areaLength;
	}
	
	public Double getRunwayLength (){
		return this.runwayLength;
	}
	
	public Double getRunwayWidth (){
		return this.runwayWidth;
	}
	
	public Double getRunwayStartX (){
		return this.runwayStartX;
	}
	
	public Double getCentrelineStartX (){
		return this.centrelineStartX;
	}
	
	public Double getRunwayEndX (){
		return this.runwayEndX;
	}
	
	public Double getCentrelineEndX (){
		return this.centrelineEndX;
	}
	
	public Double getRunwayCentrelineStartY (){
		return this.runwayCentrelineStartY;
	}
	
	public Double getStopwayLStartX (){
		return this.stopwayLStartX;
	}
	
	public Double getStopwayLEndX (){
		return this.stopwayLEndX;
	}
	
	public Double getStopwayRStartX (){
		return this.stopwayRStartX;
	}
	
	public Double getStopwayREndX (){
		return this.stopwayREndX;
	}
	
	public boolean getParametersApproachFromRightValid() {
		return parametersApproachFromRightValid;
	}
	
	public RunwayParameters getOriginalParameters() throws Exception {
		if (originalParametersValid) {
			return originalParameters;
		} else {
			throw new Exception("RunwayParametersNotValidException");
		}
	}

	public RunwayParameters getParametersApproachFromLeft() throws Exception {
		if (parametersApproachFromLeftValid) {
			return parametersApproachFromLeft;
		} else {
			throw new Exception("RunwayParametersNotValidException");
		}
	}

	public RunwayParameters getParametersApproachFromRight() throws Exception {
		if (parametersApproachFromRightValid) {
			return parametersApproachFromRight;
		} else {
			throw new Exception("RunwayParametersNotValidException");
		}
	}
	
	
	// Other Methods
	public void declareOriginalParameters() {
		parametersValid = true;
		// No obstacles
		Double runwayLda = runwayEndX - runwayStartX;
		Double runwayToda = runwayLda;
		Double runwayTora = runwayLda;
		Double runwayAsda = stopwayREndX - runwayStartX;
		// Set Values:

		originalParameters.resa = 240.0;
		originalParameters.lda = runwayLda;
		originalParameters.tora = runwayTora;
		originalParameters.toda = runwayToda;
		originalParameters.asda = runwayAsda;
		originalParametersValid = true;
	}
	
	
	// Other Methods
	public void redeclareForLandingFromLeft() {
		parametersApproachFromRightValid = false;
		parametersApproachFromLeft = new RunwayParameters();
		if (obstructions.size() > 0) {
			// new Landing parameters:
			Double newResa;
			Double newLda;

			if (obstacleIsOnLeft()) {
				newResa = 50 * obstructions.get(0).getHeight() - (obstructions.get(0).getLength() * .5 + obstructions.get(0).getPositionHighestPointX());
				if (newResa < 240) {
					newResa = 240.0;
				}
				;
				Double newLdaStart = 60 + newResa + obstructions.get(0).getPositionX() + 0.5 * obstructions.get(0).getLength();

				if (newLdaStart < runwayStartX) {
					newLdaStart = runwayStartX;
				}

				newLda = runwayEndX - newLdaStart;

			} else { // obstacle is on right
				newResa = 240.0;
				Double newLdaEnd = obstructions.get(0).getPositionX() - (60 + newResa + 0.5 * obstructions.get(0).getLength());

				if (newLdaEnd > runwayEndX) {
					newLdaEnd = runwayEndX;
				}

				newLda = newLdaEnd - runwayStartX;

				// new landing Assignations:
				parametersApproachFromLeft.resa = newResa;
				parametersApproachFromLeft.lda = newLda;

			}

			// new landing Assignations:
			// if the obstacle is significantly far from the runway, then it
			// will not be considered
			if (distanceFromRunway(obstructions.get(0).getPositionY()) < (newResa + 60)) {
				parametersApproachFromLeft.resa = newResa;
				parametersApproachFromLeft.lda = newLda;
			} else {
				parametersApproachFromLeft.resa = originalParameters.resa;
				parametersApproachFromLeft.lda = originalParameters.lda;
			}
			parametersApproachFromLeftValid = true;
			parametersApproachFromRightValid = false;
//			logs.appendText("Runway re-declared for Landing from the left.");
		}
	}
	
	public void redeclareForLandingFromRight() {
		parametersApproachFromLeftValid = false;
		parametersApproachFromRight = new RunwayParameters();
		if (obstructions.size() > 0) {
			// new Landing parameters:
			Double newResa;
			Double newLda;

			if (obstacleIsOnLeft()) {
				newResa = 240.0;
				Double newLdaStart = 60 + newResa + obstructions.get(0).getPositionX() + 0.5 * obstructions.get(0).getLength();

				if (newLdaStart < runwayStartX) {
					newLdaStart = runwayStartX;
				}

				newLda = runwayEndX - newLdaStart;

			} else { // obstacle is on right
				newResa = 50 * obstructions.get(0).getHeight() - (obstructions.get(0).getLength() * .5 + obstructions.get(0).getPositionHighestPointX());
				if (newResa < 240) {
					newResa = 240.0;
				}
				;
				Double newLdaEnd = runwayEndX - (60 + newResa + obstructions.get(0).getLength() * .5 + (runwayEndX - obstructions.get(0).getPositionX()));

				if (newLdaEnd > runwayEndX) {
					newLdaEnd = runwayEndX;
				}

				newLda = newLdaEnd - runwayStartX;

			}

			// new landing Assignations:
			// if the obstacle is significantly far from the runway, then it
			// will not be considered
			if (distanceFromRunway(obstructions.get(0).getPositionY()) < (newResa + 60)) {
				parametersApproachFromRight.resa = newResa;
				parametersApproachFromRight.lda = newLda;
			} else {
				parametersApproachFromRight.resa = originalParameters.resa;
				parametersApproachFromRight.lda = originalParameters.lda;
			}
			parametersApproachFromLeftValid = false;
			parametersApproachFromRightValid = true;
//			logs.appendText("Runway re-declared for Landing from the right.");
		}
	}
	
	public void redeclareForTakeOffFromLeft() {
		parametersApproachFromRightValid = false;
		parametersApproachFromLeft = new RunwayParameters();
		if (obstructions.size() > 0) {
			// new TakeOff parameters:
			Double newResa = null;
			Double newTora;
			Double newToda;
			Double newAsda;

			if (obstacleIsOnLeft()) {
				Double newToraTodaStart = this.planeTakingOff.getBlastDistance() + obstructions.get(0).getPositionX() + 0.5 * obstructions.get(0).getLength() + 60;
				Double newAsdaStart = newToraTodaStart;

				if (newAsdaStart < runwayStartX) {
					newAsdaStart = runwayStartX;
				}
				if (newToraTodaStart < runwayStartX) {
					newToraTodaStart = runwayStartX;
				}

				newAsda = stopwayREndX - newAsdaStart;
				newTora = runwayEndX - newToraTodaStart;
				newToda = runwayEndX - newToraTodaStart;

			} else { // obstacle is on right
				newResa = 50 * obstructions.get(0).getHeight() - (obstructions.get(0).getLength() * .5 + obstructions.get(0).getPositionHighestPointX());
				if (newResa < 240) {
					newResa = 240.0;
				}
				;
				Double newToraTodaEnd = obstructions.get(0).getPositionX() - (0.5 * obstructions.get(0).getLength() + obstructions.get(0).getPositionHighestPointX() + newResa + 60);
				Double newAsdaEnd = newToraTodaEnd;

				if (newAsdaEnd > stopwayREndX) {
					newAsdaEnd = stopwayREndX;
				}
				if (newToraTodaEnd > runwayEndX) {
					newToraTodaEnd = runwayEndX;
				}

				newAsda = newAsdaEnd - runwayStartX;
				newTora = newToraTodaEnd - runwayStartX;
				newToda = newToraTodaEnd - runwayStartX;

			}

			// new TakeOff Assignations:
			// if the obstacle is significantly far from the runway, then it
			// will not be considered
			if (distanceFromRunway(obstructions.get(0).getPositionY()) < (getMaximum(this.planeTakingOff.getBlastDistance(), newResa) + 60)) {
				if (newResa != null) {
					parametersApproachFromLeft.resa = newResa;
				}
				parametersApproachFromLeft.asda = newAsda;
				parametersApproachFromLeft.tora = newTora;
				parametersApproachFromLeft.toda = newToda;
			} else {
				parametersApproachFromLeft.resa = originalParameters.resa;
				parametersApproachFromLeft.asda = originalParameters.asda;
				parametersApproachFromLeft.tora = originalParameters.tora;
				parametersApproachFromLeft.toda = originalParameters.toda;
			}
			parametersApproachFromLeftValid = true;
			parametersApproachFromRightValid = false;
//			logs.appendText("Runway re-declared for TakeOff from the left.");
		}
	}
	

	public void redeclareForTakeOffFromRight() {
		parametersApproachFromLeftValid = false;
		parametersApproachFromRight = new RunwayParameters();
		if (obstructions.size() > 0) {
			// new TakeOff parameters:
			Double newResa = null;
			Double newTora;
			Double newToda;
			Double newAsda;

			if (obstacleIsOnLeft()) {
				newResa = 50 * obstructions.get(0).getHeight() - (obstructions.get(0).getLength() * .5 + obstructions.get(0).getPositionHighestPointX());
				if (newResa < 240) {
					newResa = 240.0;
				}
				;
				Double newToraTodaStart = 60 + newResa + obstructions.get(0).getPositionX() + 0.5 * obstructions.get(0).getLength();
				Double newAsdaStart = newToraTodaStart;

				if (newAsdaStart < stopwayLStartX) {
					newAsdaStart = stopwayLStartX;
				}
				if (newToraTodaStart < runwayStartX) {
					newToraTodaStart = runwayStartX;
				}

				newAsda = runwayEndX - newAsdaStart;
				newTora = runwayEndX - newToraTodaStart;
				newToda = runwayEndX - newToraTodaStart;

			} else { // obstacle is on right
				Double newToraTodaEnd = runwayEndX - (this.planeTakingOff.getBlastDistance() + (runwayEndX - obstructions.get(0).getPositionX()) + 0.5 * obstructions.get(0).getLength() + 60);
				Double newAsdaEnd = newToraTodaEnd;

				if (newAsdaEnd > runwayEndX) {
					newAsdaEnd = runwayEndX;
				}
				if (newToraTodaEnd > runwayEndX) {
					newToraTodaEnd = runwayEndX;
				}

				newAsda = newAsdaEnd - stopwayLStartX;
				newTora = newToraTodaEnd - runwayStartX;
				newToda = newToraTodaEnd - runwayStartX;

			}

			// new TakeOff Assignations:
			// if the obstacle is significantly far from the runway, then it
			// will not be considered
			if (distanceFromRunway(obstructions.get(0).getPositionY()) < (getMaximum(this.planeTakingOff.getBlastDistance(), newResa) + 60)) {
				if (newResa != null) {
					parametersApproachFromRight.resa = newResa;
				}
				parametersApproachFromRight.tora = newTora;
				parametersApproachFromRight.toda = newToda;
				parametersApproachFromRight.asda = newAsda;
			} else {
				parametersApproachFromRight.resa = originalParameters.resa;
				parametersApproachFromRight.asda = originalParameters.asda;
				parametersApproachFromRight.tora = originalParameters.tora;
				parametersApproachFromRight.toda = originalParameters.toda;
			}
			parametersApproachFromLeftValid = false;
			parametersApproachFromRightValid = true;
//			logs.appendText("Runway re-declared for TakeOff from the right.");
		}

	}

	public boolean obstacleIsOnLeft() {
		return obstructions.get(0).getPositionX() < (runwayEndX - runwayStartX) / 2.0;
	}

	public void addObstruction(Obstruction obstruction) {
		parametersApproachFromLeftValid = false;
		parametersApproachFromRightValid = false;

		parametersValid = false;
		// Obstructions are assigned a unique ID when added to the runway.
		// (ID is unique to this instance of Runway only. That is, two obstacles
		// on different runways could have matching IDs)
		obstruction.setID(nextObstructionID);
		// Removes current obstruction as the program currently supports just
		// one obstruction
		this.obstructions.clear();
		this.obstructions.add(obstruction);
		nextObstructionID += 1;
	}

	public Obstruction getFirstObstruction() {
		return obstructions.size() == 0 ? null : obstructions.get(0);
	}

	public void removeObstruction(int obstructionID) {
		parametersApproachFromLeftValid = false;
		parametersApproachFromRightValid = false;

		for (int i = 0; i < obstructions.size(); i += 1) {
			if (obstructions.get(i).getID() == obstructionID)
				this.obstructions.remove(i);
		}
	}

	// Accessors:
	// ///////////////////////////////////////////////////////////////////////////////////

	public Double distanceFromRunway(Double positionY) {
		Double runwayMaxY = runwayCentrelineStartY + 0.5 * runwayWidth;
		Double runwayMinY = runwayCentrelineStartY - 0.5 * runwayWidth;
		Double obstacleWidth = obstructions.get(0).getWidth();

		if (positionY > runwayMaxY + obstacleWidth) {
			return positionY - (runwayMaxY + obstacleWidth);
		} else if (positionY < runwayMinY - obstacleWidth) {
			return (runwayMinY + obstacleWidth) - positionY;
		} else {
			return 0.0;
		}
	}

	public Double getMaximum(Double in1, Double in2) {
		if (in1 == null && in2 == null) {
			return 0.0;
		} else if (in1 == null) {
			return in2;
		} else if (in2 == null) {
			return in1;
		} else if (in2 >= in1) {
			return in2;
		} else {
			return in1;
		}
	}
}
