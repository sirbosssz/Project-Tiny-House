package Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.mygdx.game.PetGame;
import Manager.GameScreenManager;
import Manager.GameScreenManager.STATE;

public class MainMenuScreen2 extends AbstractScreen{
	
	//final PetGame game;
	Texture img;
	
	private Skin skin;
	private Table table;
	private Table backTable;
	private TextButton button;
	private TextButtonStyle buttonStyle;
	private TextureAtlas buttonAtlas;
	private FreeTypeFontGenerator generator;
	private TextButton startButton;
	private static final int startButtonWidth = 250;
	private static final int startButtonHeight = 100;
	
	Texture startButtonActive;
	Texture startButtonInActive;

	OrthographicCamera camera;
	
	World world;
	Box2DDebugRenderer b_2D_DebRen;
	
	//InitButtons createButton = new InitButtons();
 
	public MainMenuScreen2(final PetGame game) {
		//this.game = game;
		super(game);
		
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, PetGame.WIDTH, PetGame.HEIGHT);
		
		game.batch.setProjectionMatrix(camera.combined);
		
		//world = new World(new Vector2(0f, 0f), false);
		//b_2D_DebRen = new Box2DDebugRenderer(); 
		
	}
	
	@Override
	public void show() {
		
		img = new Texture(Gdx.files.internal("picture/Background/background.png"));
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		BitmapFont font = generator.generateFont(parameter);

		Gdx.input.setInputProcessor(stage);
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
        
        table.setPosition(0, 0);
        table.add(startButton);
        
        stage.addActor(table);
        //stage.addActor(backTable);
        
		
		
	}
	
	@Override
	public void update(float delta) {
		//world.step(1/PetGame.APP_FPS, 6, 2);
		stage.act(delta);
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		game.batch.begin();
		
		game.batch.draw(img, 0, 0);
		
		game.batch.end();
		
		stage.act(delta);
		stage.draw();
		
		if(startButton.isPressed()){
			game.gsm.setScreen(STATE.PLAY);
		}
		
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}
	
	@Override
	public void hide() {}

	@Override
	public void dispose() {
		super.dispose();
		//stage.dispose();
		//game.batch.dispose();
		buttonAtlas.dispose();
		skin.dispose();
	}

}
