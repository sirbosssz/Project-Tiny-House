package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
//import com.badlogic.gdx.graphics.Camera;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
import Manager.GameScreenManager;
//import GameScreen.MainGameScreen;
//import Screen.MainMenuScreen;

public class PetGame extends Game implements ApplicationListener{
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final int APP_FPS = 60;
	
	public SpriteBatch batch;
	public TextureAtlas buttonAtlas;
	//private StretchViewport viewport;
	Skin skin;
	public float posX, posY;
	
	public GameScreenManager gsm;
	public AssetManager assets;
	public ShapeRenderer shapeBatch;
	//private Camera camera;
	//private StretchViewport viewport;
	
	@Override
	public void create () {
		
		assets = new AssetManager();
		shapeBatch = new ShapeRenderer();
		batch = new SpriteBatch();
		buttonAtlas = new TextureAtlas();
		gsm = new GameScreenManager(this);
		//viewport = new StretchViewport(WIDTH, HEIGHT, camera);
		//viewport.apply();
		
		//this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose() {
		super.dispose(); 
		assets.dispose(); 
		batch.dispose();
		gsm.dispose();
		}
	
	@Override
	public void resize(int width, int height) {
		//viewport.update(width, height);
		//super.resize(width, height);
	}
	@Override
	public void pause() {super.pause();}
	
	@Override
	public void resume() {super.resume();}

}