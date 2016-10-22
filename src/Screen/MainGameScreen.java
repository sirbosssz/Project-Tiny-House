package Screen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.mygdx.game.PetGame;
import Character.InitChar;
import InputHandler.inputHandle;

public class MainGameScreen extends AbstractScreen implements Screen, ApplicationListener, InputProcessor{
	
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
	private Table table;
	private TextButton startButton;
	
	public static float posx = Gdx.graphics.getWidth()/4, posy = Gdx.graphics.getHeight()/4;
	public static float char_x=0, char_y=0;
	
	public static final int char_width = 128;
	public static final int char_height = 128;
	public static final float switch_time = 0.20f;
	
	int keepState;
	int checkState = 0;
	float stateTime;
	float timer;
	
	boolean stateLeft;
	boolean stateRight;
	boolean stateDown;
	boolean stateUp;
	boolean stateClick;
	boolean first = true;
	int camState= 0;
	
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	InitChar charCre = new InitChar();
	
	public MainGameScreen(final PetGame game){
		
		//this.game = game;
		super(game);
		charCre.createChar();
	}

	@Override
	public void create() {
		camera = new OrthographicCamera(1280, 768);
	}

	@Override
	public void show() {
		
		img = new Texture("picture/Background/game-background-images-2.png");
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		BitmapFont font = generator.generateFont(parameter);

		Gdx.input.setInputProcessor(stage);
		Gdx.input.setInputProcessor(this);
		stage = new Stage();
		buttonAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/pre_ui.pack"));
		skin = new Skin(buttonAtlas);
		table = new Table(skin);
		backTable = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		backTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("button_inac");
        buttonStyle.down = skin.getDrawable("button_ac");
        
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
        
        startButton = new TextButton("", buttonStyle);
        startButton.pad(20);
        
        table.setPosition(-555, 275);
        table.add(startButton);
        
        stage.addActor(table);
        
        map = new TmxMapLoader().load("Maps/Roomtest.tmx");
		renderer = new IsometricTiledMapRenderer(map);
		renderer.setView((OrthographicCamera) stage.getCamera());
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(10, 10, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			char_x -= 90.0f*delta; 
			timer -= Gdx.graphics.getDeltaTime(); 
			
			if(Math.abs(timer) > switch_time){
				if(checkState == 0){
					keepState += 1;
					timer = 0.0f;
					if(keepState >= 9){checkState = 1;}
				}
				else if(checkState == 1){
					keepState -= 1;
					timer = 0.0f;
					if(keepState <= 1){checkState = 0;}
				}
			}
		}
		////////////////////////////////////////////////////////////////////////////////////
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			char_x += 90.0f*delta; 
			timer -= Gdx.graphics.getDeltaTime(); 
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				
				if(checkState == 0){
					keepState += 1;
					timer = 0.0f;
					if(keepState >= 9){checkState = 1;}
				}
				else if(checkState == 1){
					keepState -= 1;
					timer = 0.0f;
					if(keepState <= 1){checkState = 0;}
				}
			}
		}
		////////////////////////////////////////////////////////////////////////////////
		if(Gdx.input.isKeyPressed(Keys.UP)){
			char_y += 90.0f*delta;
			timer -= Gdx.graphics.getDeltaTime(); 
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				if(checkState == 0){
					keepState += 1;
					timer = 0.0f;
					if(keepState >= 9){checkState = 1;}
				}
				else if(checkState == 1){
					keepState -= 1;
					timer = 0.0f;
					if(keepState <= 1){checkState = 0;}
				}
			}
			
		}
		//////////////////////////////////////////////////////////////////////////////
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			
		    timer -= Gdx.graphics.getDeltaTime(); 
			char_y -= 90.0f*delta;
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				//System.out.println(keepState);
				
				if(checkState == 0){
					keepState += 1;
					timer = 0.0f;
					if(keepState >= 9){checkState = 1;}
				}
				else if(checkState == 1){
					keepState -= 1;
					timer = 0.0f;
					if(keepState <= 1){checkState = 0;}
				}
				
				//System.out.println(keepState);
					
			}
		}
		
		stateTime+=delta;
		
		switch(camState){
		case 1 : posx -= 50*delta;
				break;
		case 2 : posx += 50*delta;
				break;
		case 3 : posy += 50*delta;
				break;
		case 4 : posy -= 50*delta;
				break;
		}
		
		game.batch.begin();
		
		game.batch.draw(img, 0, 0);
		renderer.render();
		
		
		if(first == true){
			game.batch.draw(charCre.down[0].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		////////////////////////////////////////////////////////////////////////////////////////////
		if(stateLeft == true){
			
			if(char_x < -10){
				char_x = -10;
			}
			game.batch.draw(charCre.left[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		if(stateRight == true){
			game.batch.draw(charCre.right[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		if(stateUp == true){
			game.batch.draw(charCre.up[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		if(stateDown == true){
			if(char_y < -10){
				char_y = -10;
			}
			game.batch.draw(charCre.down[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		renderer.setView(camera);
		stage.act();
		stage.draw();
		game.batch.end();

		
		camera.position.set(posx, posy , 0f);
		camera.update();
		
		
	}

	@Override
	public void hide() {}

	
	@Override
	public void dispose(){
		img.dispose();
	}

	@Override
	public void render() {
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			stateClick = false; stateLeft = true; stateRight = false; stateUp = false; stateDown = false; first=false;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			stateClick = false; stateLeft = false;stateRight = true;stateUp = false;stateDown = false; first=false;
		}
		if(Gdx.input.isKeyPressed(Keys.UP)){
			stateClick = false;stateLeft = false;stateRight = false;stateUp = true;stateDown = false; first=false;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			stateClick = false;stateLeft = false;stateRight = false;stateUp = false;stateDown = true; first=false;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {return false;}

	@Override
	public boolean keyTyped(char character) {return false;}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {return false;}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		System.out.println(screenX + " " + screenY);
		
		if(screenX < 1260 && screenX > 15 && screenY > 15)
			camState = 0;
		
		if(screenX < 15)
			camState = 1;
		
		if(screenX > 1260)
			camState = 2;
		
		if(screenY < 15)
			camState = 3;
		
		if(screenY > 705)
			camState = 4;
		
		System.out.println(camState);
		return false;
		}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	

}
