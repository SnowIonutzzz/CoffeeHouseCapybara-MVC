package Controllers;
import Models.ObstructionModel;

public class Obstruction {
	private ObstructionModel myModel;

	public Obstruction(Double width, Double height, Double length, Double positionX, Double positionY, Double positionHighestPointX, Double positionHighestPointY) {
		myModel = new ObstructionModel();	
		
		myModel.setWidth(width);
		myModel.setHeight(height);
		myModel.setLength(length);
		myModel.setPositionX(positionX);
		myModel.setPositionY(positionY);
		myModel.setPositionHighestPointX(positionHighestPointX);
		myModel.setPositionHighestPointY(positionHighestPointY);
	}
	
	public void setID(int newID) {
		myModel.setID(newID);
	}
	
	public int getID() {
		return myModel.getID();
	}
	
	public Double getWidth(){
		return myModel.getWidth();
	}
	
	public Double getHeight(){
		return myModel.getHeight();
	}
	
	public Double getLength(){
		return myModel.getLength();
	}
	
	public Double getPositionX(){
		return myModel.getPositionX();
	}
	
	public Double getPositionY(){
		return myModel.getPositionY();
	}
	
	public Double getPositionHighestPointX(){
		return myModel.getPositionHighestPointX();
	}
	
	public Double getPositionHighestPointY(){
		return myModel.getPositionHighestPointY();
	}
	
	// Other Functions
	public void rotateObstruction(Double rotateByDegrees) {
		// TODO CODE
		//myModel.rotateObstruction(rotateByDegrees);
	}

}
