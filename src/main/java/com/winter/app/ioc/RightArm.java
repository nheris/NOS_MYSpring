package com.winter.app.ioc;

import org.springframework.stereotype.Component;

//@Component
public class RightArm extends Arm{
	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("오른팔");
	}
}
