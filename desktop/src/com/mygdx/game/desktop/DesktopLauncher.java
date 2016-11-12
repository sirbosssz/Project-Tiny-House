package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.PetGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PetGame.WIDTH;
		config.height = PetGame.HEIGHT;
		config.samples = 10;
		config.foregroundFPS = PetGame.APP_FPS;
		config.backgroundFPS = PetGame.APP_FPS;
		config.resizable = false;
		new LwjglApplication(new PetGame(), config);
		
	}
}
