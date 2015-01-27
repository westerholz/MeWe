package com.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Posting")
public class Posting {

	//TODO Discuss - sub-classes income/expense
	
	@Id
	@Column(name="PostingId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long postingId;
	@Temporal(TemporalType.DATE)
	private Date postingDate;
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	@Temporal(TemporalType.DATE)
	private Date modificationDate;
	private double amount;
	private String currency;
	private double sequence;
	private String text;
	@OneToMany(mappedBy="posting")
	private List<PostingItem> items = new ArrayList<PostingItem>();
	
	public long getPostingId() {
		return postingId;
	}
	public void setPostingId(long postingId) {
		this.postingId = postingId;
	}
	public Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
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
	public List<PostingItem> getItems() {
		return items;
	}
	public void setItems(List<PostingItem> items) {
		this.items = items;
	}
	public double getSequence() {
		return sequence;
	}
	public void setSequence(double sequence) {
		this.sequence = sequence;
	}
	
}
