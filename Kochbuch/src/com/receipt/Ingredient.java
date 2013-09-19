package com.receipt;

import java.io.Serializable;

public class Ingredient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Entity entity;
	private	double quantity;
	
	public Ingredient(String name, Entity entity, double quantity) {
		this.name = name;
		this.entity = entity;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "" + quantity + " " + entity + " " + name;
	}
	
}
