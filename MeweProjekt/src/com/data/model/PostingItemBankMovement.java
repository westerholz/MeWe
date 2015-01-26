package com.data.model;

public class PostingItemBankMovement implements PostingItem {

	private long id;
	private String text;
	private Double amount;
	private AccountingObject accountingObject;
	private BankStatementLine ReferencedBankStatementLine;
	
	/* (non-Javadoc)
	 * @see models.PostingItem#getId()
	 */
	public long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#getText()
	 */
	public String getText() {
		return text;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#setText(java.lang.String)
	 */
	public void setText(String text) {
		this.text = text;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#getAmount()
	 */
	public Double getAmount() {
		return amount;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#setAmount(java.lang.Double)
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#getAccountingObject()
	 */
	public AccountingObject getAccountingObject() {
		return accountingObject;
	}
	/* (non-Javadoc)
	 * @see models.PostingItem#setAccountingObject(models.IAccountingObject)
	 */
	public void setAccountingObject(AccountingObject accountingObject) {
		this.accountingObject = accountingObject;
	}
	public BankStatementLine getReferencedBankStatementLine() {
		return ReferencedBankStatementLine;
	}
	public void setReferencedBankStatementLine(
			BankStatementLine referencedBankStatementLine) {
		ReferencedBankStatementLine = referencedBankStatementLine;
	}
}
