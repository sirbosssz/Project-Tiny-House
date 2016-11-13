package Manager;

import java.io.Serializable;

public class GameData implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	public static int createstate;
	public static int position;
	
	public int getCreateState(){return createstate;}
	public void setCreateState(int i){createstate = i;}
	public int getPositon(){return position;}
	public void setPosition(int i){position = i;}
	
	public void init(){
		createstate = 0;
	}
	
}
