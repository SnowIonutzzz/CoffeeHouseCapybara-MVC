package Models;

import Controllers.Obstruction;

public class ObstructionModel {
	private ObstructionModel myModel;
	
	private int obstructionID;

	private Double width;
	private Double height;
	private Double length;

	// These give the position of the centre of the obstacle
	private Double positionX;
	private Double positionY;

	// These are given relative to the centre of the obstacle
	private Double positionHighestPointX;
	private Double positionHighestPointY;

	
	// Set Methods
	public void setID(int newID) {
		this.obstructionID = newID;
	}
	
	public void setWidth( Double receivedWidth ){
		this.width = receivedWidth;
	}
	
	public void setHeight ( Double receivedHeight ){
		this.height = receivedHeight;
	}
	
	public void setLength ( Double receivedLength ){
		this.length = receivedLength;
	}
	
	public void setPositionX ( Double receivedPositionX ){
		this.positionX = receivedPositionX;
	}
	
	public void setPositionY ( Double receivedPositionY ){
		this.positionY = receivedPositionY;
	}
	
	public void setPositionHighestPointX ( Double receivedPositionHighestPointX ){
		this.positionHighestPointX = receivedPositionHighestPointX;
	}
	
	public void setPositionHighestPointY ( Double receivedPositionHighestPointY ){
		this.positionHighestPointY = receivedPositionHighestPointY;
	}
	
	
	
	// Get Methods
	public int getID() {
		return this.obstructionID;
	}
	
	public Double getWidth(){
		return this.width;
	}
	
	public Double getHeight (){
		return this.height;
	}
	
	public Double getLength (){
		return this.length;
	}
	
	public Double getPositionX (){
		return this.positionX;
	}
	
	public Double getPositionY (){
		return this.positionY;
	}
	
	public Double getPositionHighestPointX (){
		return this.positionHighestPointX;
	}
	
	public Double getPositionHighestPointY ( ){
		return this.positionHighestPointY;
	}
	
	// Other Functions
	public void rotateObstruction(Double rotateByDegrees) {
		// TODO CODE
		//myModel.rotateObstruction(rotateByDegrees);
	}

}