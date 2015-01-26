package com.data.model;
//TODO: Discuss: Abstractclass more usefull, how to store Postingitems?
public interface PostingItem {

	public long getId();

	public void setId(long id);

	public String getText();

	public void setText(String text);

	public Double getAmount();

	public void setAmount(Double amount);

	public AccountingObject getAccountingObject();

	public void setAccountingObject(AccountingObject accountingObject);

}