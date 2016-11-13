package Screen;

import java.io.File;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.PetGame;

import Manager.AssetMan;
import Manager.GameScreenManager.STATE;
import Manager.Save;

public class createChar extends AbstractScreen{

	protected static Table backTable, cre_char_Back_Ta, char_ta, selDel_Ta, cre_char_Back_Ta_Act, press_back_but_ta, start_game_table;
	private Texture tex1, tex2, tex3, tex4, tex5, tex6;
	private Image image1, image2, image3;
	private Skin skin, selDelSkin, pressBackSkin, startGameSkin;
	protected static Stage stage;
	protected static Stage stage2;
	protected static Stage stage3;
	protected static Stage stage4;
	private TextButtonStyle buttonStyle,select, del, backButtonStyle, startGameButtonStyle;
	private TextureAtlas buttonAtlas, selectDelAtlas, pressBackAtlas, startGameAtlas;
	private FreeTypeFontGenerator generator;
	private BitmapFont font;
	private TextButton backbutton, sel_But, del_But, back_But, start_But;
	private Label startGameLabel;
	private LabelStyle style;
	private OrthographicCamera camera, camera2;
	protected static int stateKeep = 0, stateCheck = 0, createState = 0, menuState = 0;
	private float posCre_x = Gdx.graphics.getWidth()/2, posCre_y = Gdx.graphics.getHeight()/2;

	public createChar(PetGame game) {
		super(game);
		
	}

	@Override
	public void show() {
		
		
		camera = new OrthographicCamera();
		camera2 = new OrthographicCamera();
		
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		stage = new Stage();
		stage2 = new Stage(new FitViewport(PetGame.WIDTH, PetGame.HEIGHT, camera2));
		stage3 = new Stage();
		stage4 = new Stage();
		
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(stage2);
		multiplexer.addProcessor(stage4);
		
		tex1 = AssetMan.manager.get(AssetMan.graphic_crechar);
		tex2 = AssetMan.manager.get(AssetMan.graphic1_crechar);
		tex3 = AssetMan.manager.get(AssetMan.graphic2_crechar);
		tex4 = AssetMan.manager.get(AssetMan.graphic3_crechar);
		tex5 = AssetMan.manager.get(AssetMan.graphic4_crechar);
		tex6 = AssetMan.manager.get(AssetMan.graphic5_crechar);
		
		image1 = new Image(tex2);
		image2 = new Image(tex4);
		image3 = new Image(tex5);
		
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		BitmapFont font = generator.generateFont(parameter);
		
		cre_char_Back_Ta = new Table();
		char_ta = new Table();
		cre_char_Back_Ta_Act = new Table();
		press_back_but_ta = new Table();
		start_game_table = new Table();
		
		selectDelAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/selectdel.pack"));
		buttonAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/create_button.pack"));
		pressBackAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/back_but.pack"));
		startGameAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/StartGame_crescr.pack"));
		
		skin = new Skin(buttonAtlas);
		selDelSkin = new Skin(selectDelAtlas);
		pressBackSkin = new Skin(pressBackAtlas);
		startGameSkin = new Skin(startGameAtlas);
		
		backTable = new Table(skin);
		selDel_Ta = new Table(selDelSkin);
		press_back_but_ta = new Table(pressBackSkin);
		start_game_table = new Table(startGameSkin);
		
		buttonStyle = new TextButtonStyle();
		select = new TextButtonStyle();
		del = new TextButtonStyle();
		backButtonStyle = new TextButtonStyle();
		startGameButtonStyle = new TextButtonStyle();
		
		buttonStyle.up = skin.getDrawable("createButton");
        buttonStyle.down = skin.getDrawable("Create_press");
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
        
        select.up = selDelSkin.getDrawable("all purpose accept button");
        select.down = selDelSkin.getDrawable("Activate Accept Button");
        select.font = font;
        select.fontColor = Color.WHITE;
        
        del.up = selDelSkin.getDrawable("Delete");
        del.down = selDelSkin.getDrawable("Activate Delete");
        del.font = font;
        del.fontColor = Color.WHITE;
        
        backButtonStyle.up = pressBackSkin.getDrawable("all purpose back button");
        backButtonStyle.down = pressBackSkin.getDrawable("Activate Back Button");
        backButtonStyle.font = font;
        backButtonStyle.fontColor = Color.WHITE;
        
        startGameButtonStyle.up = startGameSkin.getDrawable("Half Circle");
        startGameButtonStyle.down = startGameSkin.getDrawable("Active Half Circle");
        startGameButtonStyle.font = font;
        startGameButtonStyle.fontColor = Color.WHITE;
        
        
        backbutton = new TextButton("", buttonStyle);
        
        sel_But = new TextButton("", select);
        
        del_But = new TextButton("", del);
        
        back_But = new TextButton("", backButtonStyle);
        
        start_But = new TextButton("STARTGAME", startGameButtonStyle);
        start_But.getLabel().setFontScale(2, 2);
        
        selDel_Ta.add(sel_But).width(60).height(60);
        selDel_Ta.add(del_But).width(60).height(60);
        selDel_Ta.setPosition(640, 305);
        
        backTable.add(backbutton);
        backTable.setPosition(posCre_x, posCre_y+100);
        char_ta.setVisible(true);
        
        cre_char_Back_Ta.add(image1).width(242).height(429);
        cre_char_Back_Ta.setPosition(posCre_x, posCre_y+100);
        
        char_ta.add(image2).width(320).height(320);
        char_ta.setPosition(posCre_x+20, posCre_y+150);
        char_ta.setVisible(false);
        
        cre_char_Back_Ta_Act.add(image3).width(242).height(429);
        cre_char_Back_Ta_Act.setPosition(posCre_x, posCre_y+100);
        cre_char_Back_Ta_Act.setVisible(false);
        
        press_back_but_ta.add(back_But).width(100).height(100);
        press_back_but_ta.setPosition(50, 670);
        
        start_game_table.add(start_But);
        start_game_table.setPosition(645, 70);
        
        Gdx.input.setInputProcessor(multiplexer);
        stage.addActor(backTable);
        stage2.addActor(cre_char_Back_Ta);
        stage2.addActor(cre_char_Back_Ta_Act);
        stage3.addActor(char_ta);
       
        stage4.addActor(selDel_Ta);
        stage4.addActor(press_back_but_ta);
        stage4.addActor(start_game_table);
        
        stage.getCamera();
        stage2.getCamera();

	}
	@Override
	public void render(float delta){
		
		Gdx.gl.glClearColor(10, 10, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		
		game.batch.draw(tex1, 0, 0);
		//game.batch.draw(tex3, posCre_x-157, 0);
		game.batch.draw(tex6, posCre_x-187, -4);
		
		game.batch.end();
		
		stage.act(delta);
		stage.draw();
		
		stage2.act(delta);
		stage2.draw();
		
		stage.act(delta);
		stage.draw();
		
		stage3.act(delta);
		stage3.draw();
		
		stage4.act(delta);
		stage4.draw();
		
		sel_But.setVisible(false);
		del_But.setVisible(false);
		
		if(start_But.isPressed() && menuState == 1){
			/*backTable.setVisible(false);
			createState = 1;
			stateKeep = 0;
			stateCheck = 0;
			select.up = selDelSkin.getDrawable("all purpose accept button");*/
			Save.gamed.setCreateState(1);
			Save.save();
			game.gsm.setScreen(STATE.PLAY);
			
		}
		
		if(backbutton.isPressed() && Save.gamed.getCreateState() == 0){
			backTable.setVisible(false);
			char_ta.setVisible(true);
			createState = 1;
			sel_But.setVisible(true);
			del_But.setVisible(true);
			Save.gamed.setCreateState(1);
			
		}
		
		else if (Save.gamed.getCreateState() == 1){
			backTable.setVisible(false);
			char_ta.setVisible(true);
			sel_But.setVisible(true);
			del_But.setVisible(true);
		}
		
		sel_But.addListener(new ClickListener(){
			@Override
			public void clicked (InputEvent event, float x, float y) {
				if(stateCheck == 0 && createState != 0){//select (press)
					stateKeep = 1;
					menuState = 1;//if 1 it's can press start game
					select.up = selDelSkin.getDrawable("all purpose exit button");
				}
				else if(stateCheck == 1 && stateKeep == 1){//not select (press again)
					stateKeep = 0;
					select.up = selDelSkin.getDrawable("all purpose accept button");
				}
			}
		});
		
		if(stateKeep == 0){//un-activate(press for un-select )
			cre_char_Back_Ta.setVisible(true);
			cre_char_Back_Ta_Act.setVisible(false);
			if(sel_But.isPressed()){
				stateCheck = 0;
			}

		}
		else{//activate selected(press for select already)
			cre_char_Back_Ta.setVisible(false);
			cre_char_Back_Ta_Act.setVisible(true);
			if(sel_But.isPressed()){
				stateCheck = 1;
			}
		}
		//System.out.println(stateKeep);
		if(del_But.isPressed()){
			char_ta.setVisible(false);
			if(stateKeep == 1 || stateKeep == 0){
				cre_char_Back_Ta.setVisible(true);
				cre_char_Back_Ta_Act.setVisible(false);
				backTable.setVisible(true);
				select.up = selDelSkin.getDrawable("all purpose accept button");
				stateKeep= 0;
				createState = 0;
				menuState = 0;
				sel_But.setVisible(false);
				del_But.setVisible(false);
				Save.gamed.setCreateState(0);
				Save.gamed.setPosition(2500, 200);
				Save.save();
				
			}
		}
		if(back_But.isPressed()){
			stateKeep= 0;
			createState = Save.gamed.getCreateState();
			menuState = 0;
			cre_char_Back_Ta.setVisible(true);
			cre_char_Back_Ta_Act.setVisible(false);
			Save.save();
			game.gsm.setScreen(STATE.MAIN_MENU);
		}
		System.out.println(stateCheck + " " + menuState + " " + createState);
		
	}

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
