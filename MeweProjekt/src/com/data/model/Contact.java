package com.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@Column(name="ContactId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long contactId;
	private String name;
	@ManyToOne
	@JoinColumn(name="bankReferenceId")
	private BankReference defaultBankReference;
	@ManyToOne
	@JoinColumn(name="accountingObjectId")
	private AccountingObjectCategory autoAssignedAccObj;
	@OneToMany(mappedBy="contact")
	private List<BankReference> bankReferences;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountingObject getAutoAssignedAccObj() {
		return autoAssignedAccObj;
	}
	public void setAutoAssignedAccObj(AccountingObjectCategory autoAssignedAccObj) {
		this.autoAssignedAccObj = autoAssignedAccObj;
	}
	public List<BankReference> getBankReferences() {
		return bankReferences;
	}
	public void setBankReferences(List<BankReference> bankReferences) {
		this.bankReferences = bankReferences;
	}
	public boolean addBankReference(BankReference bankReference){
		return this.bankReferences.add(bankReference);
	}
	public BankReference getDefaultBankReference(){
		return this.defaultBankReference;
	}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public void setDefaultBankReference(BankReference defaultBankReference) {
		this.defaultBankReference = defaultBankReference;
	}
	
}