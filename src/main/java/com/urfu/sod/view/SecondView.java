package com.urfu.sod.view;

import org.springframework.stereotype.Component;

@Component
public class SecondView {

	public SecondView() {
		System.out.println("Created Second!");
	}

	public String getSecondFrom() {
		return "second!";
	}

}
