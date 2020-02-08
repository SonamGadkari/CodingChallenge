package com.springboot.thymeprj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Vehicle {
	
	public String vehicleId;
	

	public Vehicle() {
		super();
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Vehicle(String vehicleId) {
		super();
		this.vehicleId = vehicleId;
	}
		
}
