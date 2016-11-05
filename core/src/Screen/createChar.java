package Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.mygdx.game.PetGame;

public class createChar extends AbstractScreen{

	private Table backTable;
	private Texture tex1, tex2, tex3;
	private Image image1, image2;
	private Skin skin;
	private Stage stage;
	private TextButtonStyle buttonStyle;
	private TextureAtlas buttonAtlas;
	private FreeTypeFontGenerator generator;
	private BitmapFont font;
	private TextButton backbutton;

	public createChar(PetGame game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		
		tex1 = new Texture(Gdx.files.internal(""));
		tex2 = new Texture(Gdx.files.internal(""));
		tex3 = new Texture(Gdx.files.internal(""));
		
		image1 = new Image();
		image2 = new Image();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		BitmapFont font = generator.generateFont(parameter);

		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("ui/Button/Buttonout/"));
		skin = new Skin(buttonAtlas);
		backTable = new Table(skin);
		
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("");
        buttonStyle.down = skin.getDrawable("");
        
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;
		
		
		
	}
	@Override
	public void render(float delta){
		
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
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

}
