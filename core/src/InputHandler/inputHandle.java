package InputHandler;

public class inputHandle {
	
	boolean stateLeft;
	boolean stateRight;
	boolean stateUp;
	boolean StateDown;
	float posX=640, posY=360;
	
	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public inputHandle(boolean SL, boolean SR, boolean SU, boolean SD, float PoX, float PoY){
		
		this.stateLeft = SL;
		this.stateRight = SR;
		this.stateUp = SU;
		this.StateDown = SD;
		this.posX = PoX;
		this.posY = PoY;
		
	}
	
	public void moveCam(boolean stateLeft, boolean stateRight, boolean stateUp, boolean stateDown, double posX, double posY){
		if(stateLeft == true){
			posX -= 10;
		}
		
		if(stateRight == true){
			posX += 10;
		}
		
		if(stateUp == true){
			posY += 10;
		}
		
		if(stateDown == true){
			posY -= 10;
		}
		System.out.println(posX+ " " + posY+" "+stateLeft + " " + stateRight + " " + stateUp + " " + stateDown);
	}

}
