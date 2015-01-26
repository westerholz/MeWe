package com.data.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Inheritance
@DiscriminatorColumn(name="AccountObjectCategory")
@Table(name="AccountingObjectCategories")
public abstract class AccountingObjectCategory implements AccountingObject {
	@Id
	@Column(name="AccountObjectCategoryId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="Name")
	private String name;
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
