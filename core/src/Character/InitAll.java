package Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Manager.AssetMan;
import Screen.MainGameScreen;

public class InitAll {

	public Sprite[] left = new Sprite[20];
	public Sprite[] right = new Sprite[20];
	public Sprite[] up = new Sprite[17];
	public Sprite[] down = new Sprite[17];
	public Sprite[] leftup = new Sprite[17];
	public Sprite[] rightup = new Sprite[17];
	public Sprite[] leftdown = new Sprite[17];
	public Sprite[] rightdown = new Sprite[17];
	public Sprite[] inter_left = new Sprite[14];
	public Sprite[] inter_right = new Sprite[14];
	public Animation[] loading = new Animation[74];
	public Animation[][] Mainmenu = new Animation[9][10];
	public Texture [] tex;

	int keepState = 0, k=0, l = 0;
	private final int char_sprite_width = 891;// 2368
	private final int char_sprite_height = 899;// 2500
	private final int load_sprite_width = 90;// 2368
	private final int load_sprite_height = 90;// 2500
	private final int main_sprite_width = 1280;
	private final int main_sprite_height = 720;

	public void createChar() {

		new TextureRegion();
	
		if (AssetMan.manager.getLoadedAssets() == 18) {
			TextureRegion[][] spriteSheet7 = TextureRegion.split(new Texture("picture/CharSprite/interact_R_sprite.png"), 928, 942);
			TextureRegion[][] spriteSheet = TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic8_crechar), char_sprite_width, char_sprite_width);
			TextureRegion[][] spriteSheet1 = TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic9_crechar), char_sprite_width, char_sprite_width);
			// TextureRegion[][] spriteSheet2= TextureRegion.split(new
			// Texture("picture/CharSprite/cat walk forward_right.png"),
			// char_sprite_width, char_sprite_width);
			// TextureRegion[][] spriteSheet3= TextureRegion.split(new
			// Texture("picture/CharSprite/cat walk front_ left.png"),
			// char_sprite_width, char_sprite_width);
			
			TextureRegion[][] spriteSheet4 = TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic7_crechar), 860, 900);
			TextureRegion[][] spriteSheet5 = TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic6_crechar), 860, 900);
			TextureRegion[][] spriteSheet6 = TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic10_crechar), 928, 942);
			

			/*
			 * for(int i = 0 ;i<17;i++){ leftdown[i] = new
			 * Sprite(spriteSheet[0][i]);
			 * leftdown[i].setBounds(MainGameScreen.char_x,
			 * MainGameScreen.char_y, MainGameScreen.char_width,
			 * MainGameScreen.char_height); } for(int i = 0 ;i<17;i++){
			 * rightdown[i] = new Sprite(spriteSheet1[0][i]);
			 * rightdown[i].setBounds(MainGameScreen.char_x,
			 * MainGameScreen.char_y, MainGameScreen.char_width,
			 * MainGameScreen.char_height); } for(int i = 0 ;i<17;i++){
			 * rightup[i] = new Sprite(spriteSheet2[0][i]);
			 * rightup[i].setBounds(MainGameScreen.char_x,
			 * MainGameScreen.char_y, MainGameScreen.char_width,
			 * MainGameScreen.char_height); } for(int i = 0 ;i<17;i++){
			 * leftup[i] = new Sprite(spriteSheet3[0][i]);
			 * leftup[i].setBounds(MainGameScreen.char_x, MainGameScreen.char_y,
			 * MainGameScreen.char_width, MainGameScreen.char_height); }
			 */

			for (int i = 0; i < 17; i++) {
				down[i] = new Sprite(spriteSheet4[0][i]);
				//down[i].setBounds(MainGameScreen.char_x, MainGameScreen.char_y, MainGameScreen.char_width,
						//MainGameScreen.char_height);
			}
			for (int i = 0; i < 17; i++) {
				up[i] = new Sprite(spriteSheet5[0][i]);
				//up[i].setBounds(MainGameScreen.char_x, MainGameScreen.char_y, MainGameScreen.char_width,
						//MainGameScreen.char_height);
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0 ; j < 10; j++) {
					left[k] = new Sprite(spriteSheet[i][j]);
					k++;
					System.out.println(k);
					//left[i].setBounds(MainGameScreen.char_x, MainGameScreen.char_y, MainGameScreen.char_width,
							//MainGameScreen.char_height);
				}
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0 ; j < 10; j++) {
					
					right[l] = new Sprite(spriteSheet1[i][j]);
					l++;
					//down[i].setBounds(MainGameScreen.char_x, MainGameScreen.char_y, MainGameScreen.char_width,
							//MainGameScreen.char_height);
					System.out.println(l);
				}
			}
			for (int i = 0; i < 14; i++) {
				inter_left[i] = new Sprite(spriteSheet6[0][i]);
				//down[i].setBounds(MainGameScreen.char_x, MainGameScreen.char_y, MainGameScreen.char_width,
						//MainGameScreen.char_height);
			}
		
			System.out.println("Finished");

		}

	}

	public void createLoading() {
		new TextureRegion();
		TextureRegion[][] spriteSheet_Load = TextureRegion.split(new Texture("picture/butSprite/Icon-Spritesheet1.png"),
				load_sprite_width, load_sprite_height);

		for (int i = 0; i < 73; i++) {
			loading[i] = new Animation(0, spriteSheet_Load[0][i]);
		}
	}

	public void createMainmenuSprite() {
		if (AssetMan.manager.getLoadedAssets() == 18) {
			TextureRegion[][] spriteSheet_mainMenu = TextureRegion
					.split((Texture) AssetMan.manager.get(AssetMan.graphic4), main_sprite_width, main_sprite_height);

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 10; j++) {
					Mainmenu[i][j] = new Animation(0, spriteSheet_mainMenu[i][j]);

				}

			}
		}

	}

}
