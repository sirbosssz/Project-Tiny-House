package Manager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import Character.InitAll;;

public class AssetMan {
	
	public static final AssetManager manager = new AssetManager();
	public static final String graphic = "picture/Background/new_back.png";
	public static final String graphic1 = "picture/Background/Demo Logo.png";
	public static final String graphic2 = "ui/Untitled-1.png";
	public static final String graphic3 = "picture/butSprite/Icon-Spritesheet1.png";
	public static final String graphic4 = "picture/backgroundsprite/MainSprite.png";
	public static final String graphic5 = "picture/CharSprite/cat walk_sptite.png";
	
	public static final String graphic_crechar = "picture/Background/Create_Char_Back.png";
	public static final String graphic1_crechar = "picture/Background/Char_Creback.png";
	public static final String graphic2_crechar = "picture/Background/Half Circle.png";
	public static final String graphic3_crechar = "picture/CharSprite/Cat Walk0001.png";
	public static final String graphic4_crechar = "picture/Background/selback.png";
	public static final String graphic5_crechar = "picture/Background/Outline.png";
	
	static InitAll charCre = new InitAll();
	
	public static boolean loadAsset(){
		manager.load(graphic, Texture.class);
		manager.load(graphic1, Texture.class);
		manager.load(graphic2, Texture.class);
		manager.load(graphic3, Texture.class);
		manager.load(graphic4, Texture.class);
		manager.load(graphic5, Texture.class);
		
		manager.load(graphic_crechar, Texture.class);
		manager.load(graphic1_crechar, Texture.class);
		manager.load(graphic2_crechar, Texture.class);
		manager.load(graphic3_crechar, Texture.class);
		manager.load(graphic4_crechar, Texture.class);
		manager.load(graphic5_crechar, Texture.class);
		if(manager.getLoadedAssets() == 12){
			System.out.println("Finished Load");
			return true;
		}
		else{
			manager.update();
			System.out.println(manager.getLoadedAssets());
		}
	return false;
		
	}

}
