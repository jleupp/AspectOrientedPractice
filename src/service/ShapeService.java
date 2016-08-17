package service;

import model.Circle;
import model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	public Circle getCircle() {
		return this.circle;
	}
	
	public Triangle getTriangle() {
		return this.triangle;
	}
	
	public void setTriangle(Triangle tri) {
		this.triangle = tri;
	}
	
	public void setCircle(Circle cir) {
		this.circle = cir;
	}
	
}
