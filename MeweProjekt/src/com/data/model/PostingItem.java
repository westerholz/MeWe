package com.data.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//TODO: Discuss: Abstractclass more usefull, how to store Postingitems?
import javax.persistence.Table;

@Entity
@Inheritance
@DiscriminatorColumn(name="PostingItemType")
@Table(name="PostingItem")
public abstract class PostingItem {
	@Id
	@Column(name="PostingItemId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long postingItemID;
	@ManyToOne
	@JoinColumn(name="PostingId")
	private long postingId;
	private long postingItemNumber;
	private String text;
	private double amount;
	private String currency;
	private AccountingObject accountingObject;
	public long getPostingItemID() {
		return postingItemID;
	}
	public void setPostingItemID(long postingItemID) {
		this.postingItemID = postingItemID;
	}
	public long getPostingId() {
		return postingId;
	}
	public void setPostingId(long postingId) {
		this.postingId = postingId;
	}
	public long getPostingItemNumber() {
		return postingItemNumber;
	}
	public void setPostingItemNumber(long postingItemNumber) {
		this.postingItemNumber = postingItemNumber;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public AccountingObject getAccountingObject() {
		return accountingObject;
	}
	public void setAccountingObject(AccountingObject accountingObject) {
		this.accountingObject = accountingObject;
	}
	
	
	


}