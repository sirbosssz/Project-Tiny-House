package Manager;

import java.io.Serializable;

public class GameData implements Serializable{
	
	private static final long SerialID = 1;
	
	public static int createstate;
	
	public int getCreateState(){return createstate;}
	public void setCreateState(int i){createstate = i;}
	
	public void init(){
		createstate = 0;
	}
	
}
