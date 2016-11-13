package Screen;

<<<<<<< HEAD
import javax.swing.Action;

import com.badlogic.gdx.Gdx;
import Manager.AssetMan;
import Manager.Save;
=======
import com.badlogic.gdx.Gdx;
import Manager.AssetMan;
>>>>>>> master
import Manager.GameScreenManager.STATE;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
<<<<<<< HEAD
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
=======
>>>>>>> master
import com.mygdx.game.PetGame;
import Character.InitAll;


public class loadingScreen extends AbstractScreen{
	
	float stateTime;
	int i=0;
	private Texture img;
	
	InitAll createLoad = new InitAll();
	private OrthographicCamera camera;
<<<<<<< HEAD
=======
	
>>>>>>> master

	public loadingScreen(PetGame game) {
		super(game);
		
	}
	
	@Override
	public void show() {
<<<<<<< HEAD
=======
		
>>>>>>> master
		createLoad.createLoading();
		img = new Texture(Gdx.files.internal("picture/Background/Loading Screen.png"));
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, PetGame.WIDTH, PetGame.HEIGHT);
		
	}
	
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(10, 10, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		System.gc();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.batch.draw(img, 0, 0);
<<<<<<< HEAD
		game.batch.draw(createLoad.loading[0].getKeyFrame(stateTime), 95, 320, 90, 90);
=======
		game.batch.draw(createLoad.loading[0].getKeyFrame(stateTime), 95, 320,90, 90);
>>>>>>> master
		stateTime += delta;
		i++;
		if(i > 72){i = 0;}
		game.batch.end();
		
		if(AssetMan.loadAsset()){
<<<<<<< HEAD
			/*stage.addAction(Actions.sequence(Actions.fadeOut(1), Actions.run(new Runnable(){
				@Override
				public void run() {
					game.gsm.setScreen(STATE.MAIN_MENU);
				}
				
			})));*/
			game.gsm.setScreen(STATE.MAIN_MENU);
			
		}
	}	
	
	
=======
			game.gsm.setScreen(STATE.MAIN_MENU);
		}
			
		
		
	}

	

>>>>>>> master
	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void update(float delta) {}
	
	@Override
	public void dispose(){
		super.dispose();
	}


}
