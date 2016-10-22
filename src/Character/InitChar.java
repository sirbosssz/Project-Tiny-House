package Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class InitChar {
	
	public Animation[] left = new Animation[10];
	public Animation[] right = new Animation[10];
	public Animation[] up = new Animation[10];
	public Animation[] down = new Animation[10];
	public Animation[] leftup = new Animation[10];
	public Animation[] rightup = new Animation[10];
	public Animation[] leftdown = new Animation[10];
	public Animation[] rightdown = new Animation[10];
	
	int keepState = 0;
	private int char_sprite_width = 128;
	private int char_sprite_height = 128;
	
	
	
	public void createChar(){
		
		new TextureRegion();
		TextureRegion[][] spriteSheet= TextureRegion.split(new Texture("picture/CharSprite/cowboy.png"), char_sprite_width, char_sprite_height);
		
		down[0] = new Animation(0,spriteSheet[9][0]);
		down[1] = new Animation(0,spriteSheet[9][1]);
		down[2] = new Animation(0,spriteSheet[9][2]);
		down[3] = new Animation(0,spriteSheet[9][3]);
		down[4] = new Animation(0,spriteSheet[9][4]);
		down[5] = new Animation(0,spriteSheet[9][5]);
		down[6] = new Animation(0,spriteSheet[9][6]);
		down[7] = new Animation(0,spriteSheet[9][7]);
		down[8] = new Animation(0,spriteSheet[9][8]);
		down[9] = new Animation(0,spriteSheet[9][9]);
		///////////////////////////////////////////////////////////////////////////////////////
		left[0] = new Animation(0,spriteSheet[7][0]);
		left[1] = new Animation(0,spriteSheet[7][1]);
		left[2] = new Animation(0,spriteSheet[7][2]);
		left[3] = new Animation(0,spriteSheet[7][3]);
		left[4] = new Animation(0,spriteSheet[7][4]);
		left[5] = new Animation(0,spriteSheet[7][5]);
		left[6] = new Animation(0,spriteSheet[7][6]);
		left[7] = new Animation(0,spriteSheet[7][7]);
		left[8] = new Animation(0,spriteSheet[7][8]);
		left[9] = new Animation(0,spriteSheet[7][9]);
		/////////////////////////////////////////////////////////////////////////////////////
		up[0] = new Animation(0,spriteSheet[5][0]);
		up[1] = new Animation(0,spriteSheet[5][1]);
		up[2] = new Animation(0,spriteSheet[5][2]);
		up[3] = new Animation(0,spriteSheet[5][3]);
		up[4] = new Animation(0,spriteSheet[5][4]);
		up[5] = new Animation(0,spriteSheet[5][5]);
		up[6] = new Animation(0,spriteSheet[5][6]);
		up[7] = new Animation(0,spriteSheet[5][7]);
		up[8] = new Animation(0,spriteSheet[5][8]);
		up[9] = new Animation(0,spriteSheet[5][9]);
		/////////////////////////////////////////////////////////////////////////////////////
		right[0] = new Animation(0,spriteSheet[3][0]);
		right[1] = new Animation(0,spriteSheet[3][1]);
		right[2] = new Animation(0,spriteSheet[3][2]);
		right[3] = new Animation(0,spriteSheet[3][3]);
		right[4] = new Animation(0,spriteSheet[3][4]);
		right[5] = new Animation(0,spriteSheet[3][5]);
		right[6] = new Animation(0,spriteSheet[3][6]);
		right[7] = new Animation(0,spriteSheet[3][7]);
		right[8] = new Animation(0,spriteSheet[3][8]);
		right[9] = new Animation(0,spriteSheet[3][9]); 	
		
	}
	
	
}
