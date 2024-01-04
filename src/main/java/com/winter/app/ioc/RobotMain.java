package com.winter.app.ioc;

public class RobotMain {
	public static void main(String[] args) {
		//기본 생성자
		Robot robot = new Robot();
		robot.getLeftArm().act();
		robot=null; 
	
		//매개변수있는 생성자
		//생명주기 다름 위랑 leftArm,rightArm 살아남아 재활용 가능
		LeftArm leftArm = new LeftArm();
		RightArm rightArm = new RightArm();
		robot = new Robot(leftArm, rightArm);
		robot=null; 
		
		//셋터
		robot.setLeftArm(leftArm);
	}
}
