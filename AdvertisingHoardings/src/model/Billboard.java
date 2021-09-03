package model;

import java.io.Serializable;

public class Billboard implements Serializable{
	
	private static final long serialVersionUID = 1L ;
	
	private double width;
	private double height;
	private boolean inUse;
	private String brand;
	
	public Billboard(double w, double h, boolean iu,String b) {
		width=w;
		height=h;
		inUse=iu;
		brand=b;
	}

	public Billboard(Billboard newBillboard) {
		// TODO Auto-generated constructor stub
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public double calculateArea() {
		double area=0;
		area=height*width;
		return area;
	}
	
	
}
