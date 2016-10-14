package Screen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.mygdx.game.PetGame;

public class MainGameScreen extends AbstractScreen implements Screen, ApplicationListener, InputProcessor{
	
	//final PetGame game;
	private TiledMap map;
	private IsometricTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private TextButton exitButton;
	private Skin skin;
	private Stage stage;
	private Table backTable;
	private TextButton button;
	private TextButtonStyle buttonStyle;
	private TextureAtlas buttonAtlas;
	private FreeTypeFontGenerator generator;
	private BitmapFont font;
	public static float posx = Gdx.graphics.getWidth()/2, posy = Gdx.graphics.getHeight()/2, posz;
	public static float char_x = posx, char_y = posy;
	
	public static final int char_sprite_width = 48;
	public static final int char_sprite_height = 48;
	public static final int char_width = char_sprite_width*2;
	public static final int char_height = char_sprite_height*2;
	public static final float switch_time = 0.20f;
	int keepState;
	float stateTime;
	float timer;
	boolean stateLeft;
	boolean stateRight;
	boolean stateDown;
	boolean stateUp;
	boolean stateClick;
	boolean first = true;
	Animation[] left;
	Animation[] right;
	Animation[] up;
	Animation[] down;
	
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	public MainGameScreen(final PetGame game){
		
		//this.game = game;
		super(game);
		int keepState = 0;
		down = new Animation[4];
		left = new Animation[4];
		up = new Animation[4];
		right = new Animation[4];
		TextureRegion[][] spriteSheet= new TextureRegion().split(new Texture("picture/CharSprite/george.png"), char_sprite_width, char_sprite_height);
		
		down[0] = new Animation(0,spriteSheet[0][0]);
		down[1] = new Animation(0,spriteSheet[1][0]);
		down[2] = new Animation(0,spriteSheet[2][0]);
		down[3] = new Animation(0,spriteSheet[3][0]);
		left[0] = new Animation(0,spriteSheet[0][1]);
		left[1] = new Animation(0,spriteSheet[1][1]);
		left[2] = new Animation(0,spriteSheet[2][1]);
		left[3] = new Animation(0,spriteSheet[3][1]);
		up[0] = new Animation(0,spriteSheet[0][2]);
		up[1] = new Animation(0,spriteSheet[1][2]);
		up[2] = new Animation(0,spriteSheet[2][2]);
		up[3] = new Animation(0,spriteSheet[3][2]);
		right[0] = new Animation(0,spriteSheet[0][3]);
		right[1] = new Animation(0,spriteSheet[1][3]);
		right[2] = new Animation(0,spriteSheet[2][3]);
		right[3] = new Animation(0,spriteSheet[3][3]);
		
	}

	@Override
	public void create() {
		stage = new Stage();
        camera.position.set(posx/2, posy/2, 0);
        camera.update();
		camera = new OrthographicCamera(1280, 768);
        map = new TmxMapLoader().load("Maps/2d.tmx");
        renderer = new IsometricTiledMapRenderer(map);
        Gdx.input.setInputProcessor(this);
		
		
	}

	@Override
	public void show() {
		img = new Texture("picture/Background/game-background-images-2.png");
		map = new TmxMapLoader().load("Maps/Roomtest.tmx");
		renderer = new IsometricTiledMapRenderer(map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(10, 10, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isTouched()){
			System.out.println(Gdx.input.getX());
			System.out.println(Gdx.input.getY());
			
			//stateClick = true;stateLeft = false; stateRight = false; stateUp = false; stateDown = false; first=false;
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			char_x -= 90.0f*delta; 
			timer -= Gdx.graphics.getDeltaTime(); 
			//System.out.println(timer);
			
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				timer = 0.0f;
				if(keepState >= 4){
					keepState = 0;
				}
			}
			stateClick = false; stateLeft = true; stateRight = false; stateUp = false; stateDown = false; first=false;}
		////////////////////////////////////////////////////////////////////////////////////
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			char_x += 90.0f*delta; 
			timer -= Gdx.graphics.getDeltaTime(); 
			System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				timer = 0.0f;
				if(keepState >= 4){
					keepState = 0;
				}
			}
			stateClick = false; stateLeft = false;stateRight = true;stateUp = false;stateDown = false; first=false;}
		////////////////////////////////////////////////////////////////////////////////
		if(Gdx.input.isKeyPressed(Keys.UP)){
			char_y += 90.0f*delta;
			timer -= Gdx.graphics.getDeltaTime(); 
			System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				timer = 0.0f;
				if(keepState >= 4){
					keepState = 0;
				}
			}
			
			stateClick = false;stateLeft = false;stateRight = false;stateUp = true;stateDown = false; first=false;}
		//////////////////////////////////////////////////////////////////////////////
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			
		    timer -= Gdx.graphics.getDeltaTime(); 
			char_y -= 90.0f*delta;
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				timer = 0.0f;
				if(keepState >= 4){
					keepState = 0;
				}
			}
			
			stateClick = false;stateLeft = false;stateRight = false;stateUp = false;stateDown = true; first=false;}
		
		stateTime+=delta;
		
		
		//camera.position.set(char_x, char_y, 0);
		//camera.update();
		
		renderer.setView(camera);
		renderer.render();
		
		game.batch.begin();
		
		if(first == true){
			game.batch.draw(down[0].getKeyFrame(stateTime), posx, posy,char_width, char_height);
		}
		////////////////////////////////////////////////////////////////////////////////////////////
		if(stateLeft == true){
			
			if(char_x < -10){
				char_x = -10;
			}
			game.batch.draw(left[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		if(stateRight == true){
			game.batch.draw(right[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		if(stateUp == true){
			game.batch.draw(up[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		if(stateDown == true){
			if(char_y < -10){
				char_y = -10;
			}
			game.batch.draw(down[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		game.batch.end();
	}

	@Override
	public void hide() {}

	@Override
	public boolean keyDown(int keycode) {return false;}

	@Override
	public boolean keyUp(int keycode) {return false;}

	@Override
	public boolean keyTyped(char character) {return false;}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {return false;}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {return false;}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {return false;}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void dispose(){
		img.dispose();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	

}
