package com.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@Column(name="ContactId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private BankReference defaultBankReference;
	private AccountingObject autoAssignedAccObj;
	@OneToMany(mappedBy="ContactID")
	private List<BankReference> bankReference;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountingObject getAutoAssignedAccObj() {
		return autoAssignedAccObj;
	}
	public void setAutoAssignedAccObj(AccountingObject autoAssignedAccObj) {
		this.autoAssignedAccObj = autoAssignedAccObj;
	}
	public List<BankReference> getBankReference() {
		return bankReference;
	}
	public void setBankReference(List<BankReference> bankReference) {
		this.bankReference = bankReference;
	}
	public BankReference getDefaultBankReference(){
		return this.defaultBankReference;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDefaultBankReference(BankReference defaultBankReference) {
		this.defaultBankReference = defaultBankReference;
	}
	
}