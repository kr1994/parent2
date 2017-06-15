package com.kris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name = "owner", nullable = false, unique = true)
	private String owner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}