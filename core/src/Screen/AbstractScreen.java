package Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.PetGame;
//import Manager.GameScreenManager;

public abstract class AbstractScreen implements Screen{
	
	protected final PetGame game;
	Stage stage;

	public AbstractScreen(final PetGame game) {
		this.game = game;
		this.stage = new Stage();
	}

	public abstract void update(float delta);
	
	@Override
	public void render(float delta){
		update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}
	
	@Override
	public void resize(int width, int height){
		stage.getViewport().update(width, height, true);
	}
	
	@Override
	public void dispose(){
		this.stage.dispose();
	}
}
