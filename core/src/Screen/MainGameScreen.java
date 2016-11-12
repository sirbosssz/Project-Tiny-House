package Screen;

import java.lang.reflect.Parameter;

import com.badlogic.gdx.ApplicationListener;
import Screen.createChar;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
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
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.mygdx.game.PetGame;
import Character.InitAll;
import InputHandler.inputHandle;
import Manager.GameScreenManager.STATE;

public class MainGameScreen extends AbstractScreen implements Screen, ApplicationListener, InputProcessor{
	
	private TiledMap map;
	private IsometricTiledMapRenderer renderer;
	private OrthographicCamera camera, camera2;
	private Skin skin;
	private Stage stage;
	private Table backTable;
	private TextButtonStyle buttonStyle;
	private TextureAtlas buttonAtlas;
	private FreeTypeFontGenerator generator;
	private BitmapFont font;
	private Table table;
	private TextButton backbutton;
	
	public static float posx = 5000/*Gdx.graphics.getWidth()/4*/, posy = 2000/*Gdx.graphics.getHeight()/4*/;
	public static float char_x=4000, char_y=1000;
	
	public static final int char_width = 900;
	public static final int char_height = 900;
	public static final float switch_time = 0.02f;
	
	int keepState, checkState = 0, camState= 0;
	float stateTime, timer;
	
	boolean stateLeft, stateRight, stateDown, stateUp, stateClick, first = true;
	
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	InitAll charCre = new InitAll();
	
	public MainGameScreen(final PetGame game){
		
		//this.game = game;
		super(game);
		stage = new Stage();
		float posx = Gdx.graphics.getWidth()/4, posy = Gdx.graphics.getHeight()/4;
	}

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera2 = new OrthographicCamera();
	}

	@Override
	public void show() {
		
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this);
		multiplexer.addProcessor(stage);
		
		img = new Texture("picture/Background/game-background-images-2.png");
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		BitmapFont font = generator.generateFont(parameter);

		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/backbut.pack"));
		skin = new Skin(buttonAtlas);
		table = new Table(skin);
		backTable = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		backTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("back");
        buttonStyle.down = skin.getDrawable("back_press");
        
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
        
        backbutton = new TextButton("", buttonStyle);
        backbutton.pad(20);
        
        table.setPosition(-555, 275);
        table.add(backbutton).width(200).height(80);
        
        stage.addActor(table);
        
        Gdx.input.setInputProcessor(multiplexer);
        
        map = new TmxMapLoader().load("Maps/newmap.tmx");
		renderer = new IsometricTiledMapRenderer(map);
		renderer.setView((OrthographicCamera) stage.getCamera());
		camera = new OrthographicCamera();
		camera2 = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth()*4, Gdx.graphics.getHeight()*4);
		camera2.setToOrtho(false, Gdx.graphics.getWidth()*4, Gdx.graphics.getHeight()*4);
		
		charCre.createChar();
		
	}

	@Override
	public void render(float delta) {
		System.gc();
		
		if(backbutton.isPressed()){
			/*createChar.menuState = 1;
			createChar.createState = 1;
			createChar.char_ta.setVisible(true);
			createChar.cre_char_Back_Ta.setVisible(false);
			createChar.cre_char_Back_Ta_Act.setVisible(true);
			createChar.backTable.setVisible(false);*/
			game.gsm.setScreen(STATE.MAIN_MENU);
			
		}
		
		Gdx.gl.glClearColor(10, 10, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		if(Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)){
			timer -= Gdx.graphics.getDeltaTime(); 
			char_y += 190.0f*delta;
			char_x -= 190.0f*delta;
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
			
		}
		else if(Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)){
			timer -= Gdx.graphics.getDeltaTime(); 
			char_y += 190.0f*delta;
			char_x += 190.0f*delta;
			
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
			
		}
		else if(Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)){
			timer -= Gdx.graphics.getDeltaTime(); 
			char_y -= 190.0f*delta;
			char_x -= 190.0f*delta;
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
			
		}
		else if(Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)){
			timer -= Gdx.graphics.getDeltaTime(); 
			char_y -= 190.0f*delta;
			char_x += 190.0f*delta;
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
			
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			char_x -= 190.0f*delta; 
			timer -= Gdx.graphics.getDeltaTime(); 
			
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
		}
		////////////////////////////////////////////////////////////////////////////////////
		else if(Gdx.input.isKeyPressed(Keys.D)){
			char_x += 190.0f*delta; 
			timer -= Gdx.graphics.getDeltaTime(); 
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
		}
		////////////////////////////////////////////////////////////////////////////////
		else if(Gdx.input.isKeyPressed(Keys.W)){
			char_y += 190.0f*delta;
			timer -= Gdx.graphics.getDeltaTime(); 
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
			
		}
		//////////////////////////////////////////////////////////////////////////////
		else if(Gdx.input.isKeyPressed(Keys.S)){
			
		    timer -= Gdx.graphics.getDeltaTime(); 
			char_y -= 190.0f*delta;
			//System.out.println(timer);
			if(Math.abs(timer) > switch_time){
				keepState += 1;
				//System.out.println(keepState);
				timer = 0.0f;
				if(keepState >= 15 ){keepState = 0;}
			}
		}
		
		//stateTime+=delta;
		
		switch(camState){
		case 1 : posx -= 1150*delta;
				break;
		case 2 : posx += 1150*delta;
				break;
		case 3 : posy += 1150*delta;
				break;
		case 4 : posy -= 1150*delta;
				break;
		}
		
		renderer.render();
		renderer.setView(camera);
		
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		
		//game.batch.draw(img, 0, 0);
		
		
		
		if(first == true){
			game.batch.draw(charCre.leftdown[0].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		if(stateLeft == true && stateDown == true){
			if(char_x < -10){
				char_x = -10;
			}
			game.batch.draw(charCre.leftdown[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		if(stateRight == true && stateDown == true){
			game.batch.draw(charCre.rightdown[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
			//System.out.println("ssssss");
		}
		
		if(stateUp == true && stateLeft == true){
			game.batch.draw(charCre.leftup[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		if(stateUp == true && stateRight == true){
			if(char_y < -10){
				char_y = -10;
			}
			game.batch.draw(charCre.rightup[keepState].getKeyFrame(stateTime), char_x, char_y,char_width, char_height);
		}
		
		
		game.batch.end();
		
		stage.act();
		stage.draw();

		camera.position.set(posx, posy , 0f);
		camera.update();
		
		
	}

	@Override
	public void hide() {
		
		//stage.dispose();
		//super.dispose();
	}

	
	@Override
	public void dispose(){
		super.dispose();
		//stage.dispose();
		//skin.dispose();
		//batch.dispose();
		//generator.dispose();
		//font.dispose();
		//renderer.dispose();
		map.dispose();
		
	}

	@Override
	public void render() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if(Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)){
			stateClick = false; stateLeft = true; stateRight = false; stateUp = true; stateDown = false; first=false;
		}
		else if(Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)){
			stateClick = false; stateLeft = false;stateRight = true;stateUp = true;stateDown = false; first=false;
		}
		else if(Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)){
			stateClick = false; stateLeft = false; stateRight = true; stateUp = false; stateDown = true; first=false;
			System.out.println("SD");
		}
		else if(Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)){
			stateClick = false; stateLeft = true;stateRight = false;stateUp = false;stateDown = true; first=false;
		}
		else if(Gdx.input.isKeyPressed(Keys.W)){
			stateClick = false;stateLeft = false;stateRight = false;stateUp = true;stateDown = false; first=false;
		}
		else if(Gdx.input.isKeyPressed(Keys.S)){
				stateClick = false;stateLeft = false;stateRight = false;stateUp = false;stateDown = true; first=false;
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			stateClick = false;stateLeft = true;stateRight = false;stateUp = false;stateDown = false; first=false;
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
				stateClick = false;stateLeft = false;stateRight = true;stateUp = false;stateDown = false; first=false;
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
		
		//System.out.println(camState);
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