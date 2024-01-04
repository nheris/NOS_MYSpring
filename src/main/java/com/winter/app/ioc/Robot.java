package com.winter.app.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Robot {
	//팔없으면 일못함 로봇은 팔에 의존적
	//depandency injection 팔집어넣
	//팔(왼쪽 , 오른쪽)
	//@Autowired
	private LeftArm leftArm;
	//@Autowired
	private RightArm rightArm;
	
	//주입방법
	//1. 생성자
	public Robot(){
		//this.leftArm = new LeftArm();
		//this.rightArm = new RightArm();
	}
	
	//2. 매개변수로 외부에서 받은 생성자
	public Robot(LeftArm leftArm, RightArm rightArm) {
		this.leftArm = leftArm;
		this.rightArm = rightArm;
	}

	//3. 세터게터
	public LeftArm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(LeftArm leftArm) {
		this.leftArm = leftArm;
	}

	public RightArm getRightArm() {
		return rightArm;
	}

	public void setRightArm(RightArm rightArm) {
		this.rightArm = rightArm;
	}
	
	//다리
}
