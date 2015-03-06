package Views;

import Controllers.*;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Visualisation implements ApplicationListener {

	enum VisualisationType {
		TopDown, SideView, ThreeDimensional, Blank
	};

	private VisPanel[] panels;
	private int width, height;

	private AssetManager manager;
	private SpriteBatch batch;
	private RunwayArea runway;

	public Visualisation(RunwayArea runway) {
		this.runway = runway;
	}

	public void setSize(int width, int height) {
		this.resize(width, height);
	}

	@Override
	public void resize(int arg0, int arg1) {
		width = arg0;
		height = arg1;
	}

	public void update(RunwayArea runway) {
		this.runway = runway;
		for (VisPanel panel : panels)
			panel.updateVis(runway);
	}

	// It's LibGDX from here down

	@Override
	public void create() {
		manager = new AssetManager();
		manager.load("data/runwayworking.png", Texture.class);
		manager.load("data/sidevis.png", Texture.class);
		manager.load("data/blank.jpg", Texture.class);
		manager.load("data/sideplane.png", Texture.class);
		manager.load("data/topplane.png", Texture.class);
		manager.load("data/sidecar.png", Texture.class);
		manager.load("data/topcar.png", Texture.class);
		manager.finishLoading();

		/*
		 * panels = new VisPanel[3]; panels[2] = new VisPanel(manager,
		 * VisualisationType.TopDown, width, height/3, 0, 0, runway); panels[1]
		 * = new VisPanel(manager, VisualisationType.SideView, width, height/3,
		 * 0, height/3, runway); panels[0] = new VisPanel(manager,
		 * VisualisationType.Blank, width, height/3, 0, 2*(height/3), runway);
		 */
		panels = new VisPanel[2];
		panels[1] = new VisPanel(manager, VisualisationType.SideView, width, height / 2, 0, 0, runway);
		panels[0] = new VisPanel(manager, VisualisationType.TopDown, width, height / 2, 0, height / 2, runway);
		batch = new SpriteBatch();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {
		// Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		// Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (VisPanel panel : panels) {
			panel.update();
			panel.render(batch);
		}
		batch.end();
	}
}
