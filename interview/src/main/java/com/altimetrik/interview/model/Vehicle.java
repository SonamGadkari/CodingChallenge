package com.altimetrik.interview.model;

public class Vehicle {

	private String make;
	private String model;
	private String year;
	private String plant;
	private String country;
	private String plantState;
		
	
	public Vehicle() {
		//super();
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlantState() {
		return plantState;
	}
	public void setPlantState(String plantState) {
		this.plantState = plantState;
	}
	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", year=" + year + ", plant=" + plant + ", country="
				+ country + ", plantState=" + plantState + "]";
	}	
}
