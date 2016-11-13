package Manager;

import java.io.Serializable;

public class GameData implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	public int createstate;
	public float position_x = 2500, position_y = 200;
	
	public int getCreateState(){return createstate;}
	public float getPositionX(){return position_x;}
	public float getPositionY(){return position_y;}
	
	public void setCreateState(int i){createstate = i;}
	
	public void setPosition(float j , float k){
		position_x = j;
		position_y = k;
	}
	
	public void init(){
		createstate = 0;
		position_x = 2500;
		position_y = 200;
	
	}
}
