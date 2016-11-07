package Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.PetGame;
import utils.B2DBodyBuilder;
import static utils.B2DConstant.PPM;


public class GameScreen extends AbstractScreen{
	
	OrthographicCamera camera;
	
	//Box 2D Var
	World world;
	Box2DDebugRenderer b_2D_DebRen;
	

	public GameScreen(final PetGame game) {
		
		super(game);
		
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, PetGame.WIDTH, PetGame.HEIGHT);
		
		game.batch.setProjectionMatrix(camera.combined);
		//game.shapeBatch.setProjectionMatrix(camera.combined);
		
		world = new World(new Vector2(0f, 0f), false);
		b_2D_DebRen = new Box2DDebugRenderer(); 
		
	}
	@Override
	public void show() {
	}

	@Override
	public void update(float delta) {
		
		world.step(1/PetGame.APP_FPS, 6, 2);
		stage.act(delta);
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		
		b_2D_DebRen.render(world, camera.combined.cpy().scl(PPM));
		stage.draw();
	}
	
	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}
	
	@Override
	public void dispose(){
		super.dispose();
		world.dispose();
		
	}

	
}
