package Manager;

import java.util.HashMap;
import com.mygdx.game.PetGame;
import Screen.AbstractScreen;
import Screen.MainGameScreen;
//import Screen.GameScreen;
import Screen.MainMenuScreen2;
import Screen.NewMainMenuScreen;
import Screen.createChar;
import Screen.loadingScreen;


public class GameScreenManager {
	
	public final PetGame game;
	private HashMap<STATE, AbstractScreen> gameScreen;
	public enum STATE{
		MAIN_MENU,
		PLAY,
		CHARCREATE,
		LOADING
	}
	
	public GameScreenManager(final PetGame game) {
		this.game = game;
		initGameScreen();
		setScreen(STATE.MAIN_MENU);
	}
	
	public void initGameScreen() {
		this.gameScreen = new HashMap<STATE, AbstractScreen>();
		this.gameScreen.put(STATE.MAIN_MENU, new NewMainMenuScreen(game));
		this.gameScreen.put(STATE.PLAY, new MainGameScreen(game));
		this.gameScreen.put(STATE.CHARCREATE, new createChar(game));
		this.gameScreen.put(STATE.LOADING, new loadingScreen(game));
	}
	
	public void setScreen(STATE nextScreen){
		game.setScreen(gameScreen.get(nextScreen));
	}
	
	public void dispose(){
		for(AbstractScreen screen: gameScreen.values()){
			if(screen != null){
				screen.dispose();
			}
		}
	}
}
