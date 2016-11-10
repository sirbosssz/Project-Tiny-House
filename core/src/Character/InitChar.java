package Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class InitChar {
	
	public Animation[] left = new Animation[10];
	public Animation[] right = new Animation[10];
	public Animation[] up = new Animation[10];
	public Animation[] down = new Animation[10];
	public Animation[] leftup = new Animation[17];
	public Animation[] rightup = new Animation[17];
	public Animation[] leftdown = new Animation[17];
	public Animation[] rightdown = new Animation[17];
	
	int keepState = 0;
	private final int char_sprite_width = 600;//2368
	private final int char_sprite_height = 600;//2500
	
	
	
	public void createChar(){
		
		new TextureRegion();
		TextureRegion[][] spriteSheet= TextureRegion.split(new Texture("picture/CharSprite/cat walk_sptite.png"), char_sprite_width, char_sprite_width);
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
	}
	
	
}
