package model;

import aspect.CustomAspectAnnotation;

public class Triangle {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("THE TRIANGLES NAME HAS BEEN SET");
	}
	
	@CustomAspectAnnotation
	public void annotationMethod() {
		System.out.println("Inside Triangle annoMethod");
	}
}
