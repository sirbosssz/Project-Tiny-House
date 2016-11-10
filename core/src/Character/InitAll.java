package Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Manager.AssetMan;

public class InitAll {
	
	public Animation[] left = new Animation[10];
	public Animation[] right = new Animation[10];
	public Animation[] up = new Animation[10];
	public Animation[] down = new Animation[10];
	public Animation[] leftup = new Animation[17];
	public Animation[] rightup = new Animation[17];
	public Animation[] leftdown = new Animation[17];
	public Animation[] rightdown = new Animation[17];
	public Animation[] loading = new Animation[74];
	public Animation[][] Mainmenu = new Animation[9][10];
	
	int keepState = 0;
	private final int char_sprite_width = 600;//2368
	private final int char_sprite_height = 600;//2500
	private final int load_sprite_width = 90;//2368
	private final int load_sprite_height = 90;//2500
	private final int main_sprite_width = 1280;
	private final int main_sprite_height = 720;
	
	
	
	public void createChar(){
		
		new TextureRegion();
		
		if(AssetMan.manager.getLoadedAssets() == 12){
			TextureRegion[][] spriteSheet= TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic5), char_sprite_width, char_sprite_width);
			TextureRegion[][] spriteSheet1= TextureRegion.split(new Texture("picture/CharSprite/cat walk down_right.png"), char_sprite_width, char_sprite_width);
			TextureRegion[][] spriteSheet2= TextureRegion.split(new Texture("picture/CharSprite/cat walk forward_right.png"), char_sprite_width, char_sprite_width);
			TextureRegion[][] spriteSheet3= TextureRegion.split(new Texture("picture/CharSprite/cat walk front_ left.png"), char_sprite_width, char_sprite_width);
			
			for(int i = 0 ;i<17;i++){
				leftdown[i] = new Animation(0,spriteSheet[0][i]);
			}
			for(int i = 0 ;i<17;i++){
				rightdown[i] = new Animation(0,spriteSheet1[0][i]);
			}
			for(int i = 0 ;i<17;i++){
				rightup[i] = new Animation(0,spriteSheet2[0][i]);
			}
			for(int i = 0 ;i<17;i++){
				leftup[i] = new Animation(0,spriteSheet3[0][i]);
			}
			System.out.println("Finished");
			
		}
		
	}
	
	public void createLoading(){
		new TextureRegion();
		TextureRegion[][] spriteSheet_Load= TextureRegion.split(new Texture("picture/butSprite/Icon-Spritesheet1.png"), load_sprite_width, load_sprite_height);
		
		for(int i = 0 ;i<73;i++){
			loading[i] = new Animation(0,spriteSheet_Load[0][i]);
		}
	}
	
	public void createMainmenuSprite(){
		if(AssetMan.manager.getLoadedAssets() == 12){
			TextureRegion[][] spriteSheet_mainMenu= TextureRegion.split((Texture) AssetMan.manager.get(AssetMan.graphic4), main_sprite_width, main_sprite_height);

			for(int i = 0 ;i<9;i++){
				for(int j = 0 ; j < 10 ;j++){
					Mainmenu[i][j] = new Animation(0,spriteSheet_mainMenu[i][j]);
					
				}
				
			}
		}
		
	}
	
	
	
}
