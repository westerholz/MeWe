package com.data.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PostingItemType",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PostingItem")
@Table(name="PostingItem")
//@AttributeOverride(name = "PostingItemType", column = @Column(name="PostingItemType", nullable=false, insertable = false, updatable = false))
public abstract class PostingItem {
	@Id
	@Column(name="PostingItemId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long postingItemId;
	@ManyToOne
	@JoinColumn(name="posting")
	private Posting posting;
	private long postingItemNumber;
	private String text;
	private double amount;
	private String currency;
	@ManyToOne
	@JoinColumn(name="accountObjectCategoryId")
	private AccountingObjectCategory accountingObject;
	

	public long getPostingItemId() {
		return postingItemId;
	}
	public void setPostingItemID(long postingItemID) {
		this.postingItemId = postingItemID;
	}

	public Posting getPosting() {
		return posting;
	}
	public void setPosting(Posting postingId) {
		this.posting = postingId;
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

	public AccountingObjectCategory getAccountingObject() {
		return accountingObject;
	}
	public void setAccountingObject(AccountingObjectCategory accountingObject) {
		this.accountingObject = accountingObject;
	}
	
	
	


}