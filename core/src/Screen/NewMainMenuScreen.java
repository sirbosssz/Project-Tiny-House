package Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.PetGame;

import Manager.GameScreenManager.STATE;

public class NewMainMenuScreen extends AbstractScreen{

	OrthographicCamera camera, camera2, camera3, camera4, camera5;
	
	ShapeRenderer shape;
	private Skin skin, startGameSkin, exitSkin;
	private Table table, table2, table3, table4, table5;
	private TextButtonStyle buttonStyle, startGameStyle, exitButtonStyle;
	private TextButton Setting,exitBut, Startgame;
	private TextureAtlas buttonAtlas, startGameAtlas, exitAtlas;
	private FreeTypeFontGenerator generator;
	private Texture img, img2, img3, img4, img5;
	private Label tinyLabel;
	private LabelStyle style;
	private Actor temp;
	private Image image, settingPop, gameLogo;
	private Stage stage2, stage3, stage4, stage5, stagebig;
	private int keepState = 0, pressState = 0;
	private Cursor newCursor;
	private float posx = Gdx.graphics.getWidth()/2, posy=Gdx.graphics.getHeight()/2;//stage
	private float posx2 = Gdx.graphics.getWidth()*2, posy2=Gdx.graphics.getHeight()*2;//background
	private float posx3 = Gdx.graphics.getWidth()/2, posy3=Gdx.graphics.getHeight()/2;//stage2
	private float posx4 = 660, posy4=350;
	private float cPosx = 1600.0f,cPosy = 400.0f, stateTime, saveDelta = 0.016796896f;
	
	public NewMainMenuScreen(PetGame game) {
		super(game);
		
		
		this.camera = new OrthographicCamera();//stage cam label
		this.camera.setToOrtho(false, PetGame.WIDTH*4, PetGame.HEIGHT*4);
		
		this.camera2 = new OrthographicCamera();//background cam
		this.camera2.setToOrtho(false, PetGame.WIDTH*4, PetGame.HEIGHT*4);
		
		this.camera3 = new OrthographicCamera();//stage2 cam settingbutton
		this.camera3.setToOrtho(false, PetGame.WIDTH*4, PetGame.HEIGHT*4);
		
		this.camera4 = new OrthographicCamera();//stage3 cam settingpopup
		this.camera4.setToOrtho(false, PetGame.WIDTH*4, PetGame.HEIGHT*4);
		
		
		
		game.batch.setProjectionMatrix(camera2.combined);
		this.shape = new ShapeRenderer();
		
		stagebig = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera));
		stage = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera));
		stage2 = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera3));
		stage3 = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera4));
		stage4 = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera3));
		stage5 = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera3));
	}

	@Override
	public void show() {
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(stage2);
		multiplexer.addProcessor(stage3);
		multiplexer.addProcessor(stage4);
		multiplexer.addProcessor(stage5);
		
		
		/*Pixmap pm = new Pixmap(Gdx.files.internal("ui/Cursor/cursor_hand.png"));
		
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 10, 10));*/
		
		img = new Texture(Gdx.files.internal("picture/Background/new_back.png"));
		img2 = new Texture(Gdx.files.internal("ui/Untitled-1.png"));
		img3 = new Texture(Gdx.files.internal("picture/Background/settingpopup.png"));
		img4 = new Texture(Gdx.files.internal("picture/Background/Demo Logo.png"));
		img5 = new Texture(Gdx.files.internal("picture/Background/mid_cir.png"));
		
		image = new Image(img2);
		settingPop = new Image(img3);
		gameLogo = new Image(img4);
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		BitmapFont font = generator.generateFont(parameter);
		
		
		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/pre_ui.pack"));
		startGameAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/fianl2.pack"));
		exitAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/exit.pack"));
		
		skin = new Skin(buttonAtlas);
		startGameSkin = new Skin(startGameAtlas);
		exitSkin = new Skin(exitAtlas);
		
		style = new LabelStyle(font, Color.WHITE);
		tinyLabel = new Label("TINY HOUSE", style);
		tinyLabel.setFontScale(4);
		
		buttonStyle = new TextButtonStyle();
		startGameStyle = new TextButtonStyle();
		exitButtonStyle= new TextButtonStyle();
		
		exitButtonStyle.up = exitSkin.getDrawable("button_inact");
		exitButtonStyle.down = exitSkin.getDrawable("button_act");
	
		startGameStyle.up = startGameSkin.getDrawable("PlayButtonA");
		startGameStyle.down = startGameSkin.getDrawable("PlayButtonB");
		
		buttonStyle.up = skin.getDrawable("button_inac");
        buttonStyle.down = skin.getDrawable("button_ac");
        
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
        
        exitButtonStyle.font = font;
        exitButtonStyle.fontColor = Color.WHITE;
        
        startGameStyle.font = font;
        startGameStyle.fontColor = Color.WHITE;
        
        Setting = new TextButton("", buttonStyle);
        
        exitBut = new TextButton("", exitButtonStyle);
        
        Startgame = new TextButton("", startGameStyle);
        
		Gdx.input.setInputProcessor(multiplexer);
		
		table = new Table();
		table2 = new Table(skin);
		table3 = new Table(skin);
		table4 = new Table(skin);
		
		table5 = new Table(startGameSkin);
		
		table.add(gameLogo).width(500).height(100);
		table.setPosition(PetGame.WIDTH/2, PetGame.HEIGHT-50);
		//table.setexitBut(true);
		
		table2.add(Setting).width(80).height(80);//button
		table2.setPosition(860, 520);
		//table2.setexitBut(true);
		
		table3.add(settingPop).width(440).height(512);
		table3.setPosition(1000, -500);
		table3.setVisible(false);
		
		table4.add(exitBut).width(80).height(80);
		table4.setPosition(860, 200);
		
		table5.add(Startgame).width(200).height(200);
		table5.setPosition(660, 350);
		
		//stage2.addActor(table);
		stage.getCamera();
		stage2.getCamera();
		stage3.getCamera();
		stage4.getCamera();
		stage5.getCamera();
		//stage2.setKeyboardFocus(image);
		//stage.addActor(image);
		stage.addActor(table2);
		//stage.setexitButAll(true);
		
		stage2.addActor(table);
		//stage2.setexitButAll(true);
		
		stage3.addActor(table3);
		//stage3.setexitButAll(true);
		
		stage4.addActor(table4);
		//stage4.setexitButAll(true);
		
		stage5.addActor(table5);
		//stage5.setexitButAll(true);
		
		
	}
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		
		Gdx.gl.glLineWidth(5);

		game.batch.setProjectionMatrix(camera2.combined);
		game.batch.begin();
		
		game.batch.draw(img, 0, 0);
		game.batch.draw(img2, cPosx, cPosy);
		game.batch.draw(img5,cPosx+500,  cPosy+450);
		
		game.batch.end();
		
		stage.act(delta);
		stage.draw();
		stage2.act(delta);
		stage2.draw();
		stage3.act(delta);
		stage3.draw();
		stage4.act(delta);
		stage4.draw();
		stage5.act(delta);
		stage5.draw();
		
		if(exitBut.isPressed()){
			Gdx.app.exit();
		}
		if(Startgame.isPressed()&&pressState==0){
				game.gsm.setScreen(STATE.CHARCREATE);
		}
		
		if(Setting.isPressed()&&keepState==0){
			keepState = 1;
			pressState = 1;
		}
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
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		super.dispose();
		shape.dispose();
		//buttonAtlas.dispose();
		//skin.dispose();
	}

}
