package Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;

public class Save {
	
	public static GameData gamed;
	
	public static void save(){
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("gamechar.sav")
				);
			out.writeObject(gamed);
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
					new FileInputStream("gamechar.sav")
				);
			gamed = (GameData) in.readObject();
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
	
	public static boolean saveFileExists(){
		File file = new File("gamechar.sav");
		return file.exists();
	}
	
	public static void init(){
		gamed = new GameData();
		gamed.init();
		save();
	}
}
