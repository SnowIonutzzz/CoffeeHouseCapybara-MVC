package Views;
import Controllers.*;
import Views.Visualisation.VisualisationType;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class VisPanel {

	private static final int SIDE_VIEW_GROUND_HEIGHT = 200;
	private static final int TOP_VIEW_LEFT_START = 70;
	private static final int TOP_VIEW_RIGHT_START = 830;
	private VisualisationType currentDisplay;
	private Sprite currentBackdrop, currentPlane, currentObstacle;
	private AssetManager manager;
	private int width, height;
	private int offsetX, offsetY;
	private RunwayArea runway;
	private Vector2 runwayScale;
	private boolean isHeadingRight;
	private boolean isLanding;
	
	public VisPanel(AssetManager manager, VisualisationType type, int width, int height, int offsetX, int offsetY, RunwayArea runway)
	{
		this.manager = manager;
		this.currentDisplay = type;
		this.width = width;
		this.height = height;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.runway = runway;
		this.runwayScale = new Vector2((float)(((float)width)/runway.getAreaLength()), (float)(((float)height)/runway.getAreaWidth()));
		this.isHeadingRight = true;
		this.isLanding = false;
		
		setBackdrop();
		
		this.currentBackdrop.setSize(width, height);
		this.currentBackdrop.setPosition(offsetX, offsetY);
		
		
		this.currentPlane.setSize(width/5, height/4);
		this.currentPlane.setPosition(offsetX, offsetY+(height/2)-50);
		
		Obstruction o = this.runway.getFirstObstruction();
		Vector2 rel = getRelativeObstructionPosition(o);
		
		this.currentObstacle.setPosition(rel.x, rel.y);
		this.currentObstacle.setSize(70, 35);
	}
	
	public void updateVis(RunwayArea runway)
	{
		this.runway = runway;
		
		
		setBackdrop();
	}
	
	private void setBackdrop() {

		switch (currentDisplay) {
		case TopDown:
			this.currentBackdrop = new Sprite(manager.get("data/runwayworking.png", Texture.class));
			this.currentPlane = new Sprite(manager.get("data/topplane.png", Texture.class));
			this.currentObstacle = new Sprite(manager.get("data/topcar.png", Texture.class));
			break;
		case SideView:
			this.currentBackdrop = new Sprite(manager.get("data/sidevis.png", Texture.class));
			this.currentPlane = new Sprite(manager.get("data/sideplane.png", Texture.class));
			this.currentObstacle = new Sprite(manager.get("data/sidecar.png", Texture.class));
			break;
		default:
			break;
		}
		
		
	}
	
	public void render(SpriteBatch batch)
	{
		currentBackdrop.draw(batch);
		currentObstacle.draw(batch);
		currentPlane.draw(batch);
		/*
		switch(currentDisplay)
		{
		case TopDown:
			batch.draw(currentObstacle, rel.x, rel.y, 70, 35);
			batch.draw(currentPlane, planePos.x, planePos.y, width/5, height/5);
			break;
		case SideView:

			break;
		case ThreeDimensional:
			break;
		case Blank:
			break;
		}*/

		
	}
	
	private Vector2 getRelativeObstructionPosition(Obstruction o)
	{
		return new Vector2((float)(offsetX+(o.getPositionX() * runwayScale.x)), 
				currentDisplay == VisualisationType.SideView ? offsetY + SIDE_VIEW_GROUND_HEIGHT : 
					(float)(offsetY + (o.getPositionY() * runwayScale.y)));
	}
	
	public void update() {
		isHeadingRight = runway.getApproachFromLeft();
		currentPlane.setFlip(!isHeadingRight, false);
		// TODO Auto-generated method stub
		currentPlane.setPosition(currentPlane.getX() + (isHeadingRight ? 0.8f : -0.8f), currentPlane.getY());
		if(currentPlane.getX() > width)
			currentPlane.setPosition(offsetX, offsetY+(height/2));
		else if(currentPlane.getX() < 0)
			currentPlane.setPosition(width-100, offsetY+(height/2));

		Vector2 rel = getRelativeObstructionPosition(runway.getFirstObstruction());
		
		this.currentObstacle.setPosition(rel.x, rel.y);
		this.currentObstacle.setSize(70, 35);
		
	}	
}
