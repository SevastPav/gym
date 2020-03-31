package com.urfu.sod.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("view")
public class MyBean {

	public MyBean() {
		System.out.println("Created!");
	}

	public String getFrom() {
		return this.toString();
	}

	public String getDate() {
		return new Date().toString();
	}

}
