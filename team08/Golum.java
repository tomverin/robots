/**
 * Copyright (c) 2001-2020 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://robocode.sourceforge.io/license/epl-v10.html
 */
package team08;


import robocode.*;


/**
 * MyFirstRobot - a sample robot by Mathew Nelson.
 * <p>
 * Moves in a seesaw motion, and spins the gun around at each end.
 *
 * @author Mathew A. Nelson (original)
 */
public class Golum extends AdvancedRobot {
	boolean direction = true;
	boolean movingForward;
	double angle=20;

	/**
	 * MyFirstRobot's run method - Seesaw
	 */
	public void run() {

		while (true) {
			System.out.println("start loop");
			// Tell the game we will want to move ahead 40000 -- some large number
			setAhead(40000);
			movingForward = true;

			if (direction)
				//turnRight(20); // Spin gun around
				setTurnRight(angle);
			else
				setTurnLeft(angle);
				//turnLeft(20);
			waitFor(new TurnCompleteCondition(this));
			angle=20;
			System.out.println("angle no target"+angle);
			
		}
	}

	/**
	 * Fire when we see a robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
		direction = !direction;
		if (direction)
			System.out.println("right");
		else
			System.out.println("left");
		System.out.println(""+e.getName()+" "+e.getBearing()+" "+e.getBearingRadians()+" "+e.getHeadingRadians());
		angle=2;
		System.out.println("angle "+angle);
		
	}

	/**
	 * We were hit!  Turn perpendicular to the bullet,
	 * so our seesaw might avoid a future shot.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		//turnLeft(90 - e.getBearing());
	}
}												

