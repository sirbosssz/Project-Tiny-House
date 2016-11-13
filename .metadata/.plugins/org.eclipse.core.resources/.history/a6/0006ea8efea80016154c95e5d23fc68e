package Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;

public class Save {
	
	public static GameData game;
	
	public static void save(){
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("game.sav")
				);
			out.writeObject(game);
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
	
	public static void load(){
		try{
			if(!saveFileExists()){
				init();
				return;
			}
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("game.sav")
				);
			game = (GameData) in.readObject();
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
	
	public static boolean saveFileExists(){
		File file = new File("game.sav");
		return file.exists();
	}
	
	public static void init(){
		game = new GameData();
		game.init();
		save();
	}
}
