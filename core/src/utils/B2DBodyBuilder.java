package utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import static utils.B2DConstant.PPM;

public class B2DBodyBuilder {

	public static Body createBox(World world, float x, float y, float width, float height){
		Body body;
		BodyDef bDef = new BodyDef();
		bDef.type = BodyDef.BodyType.StaticBody;
		bDef.fixedRotation = true;
		(bDef).position.set(x/PPM, y/PPM);
		body = world.createBody(bDef);
		return body;
		
	}
}
