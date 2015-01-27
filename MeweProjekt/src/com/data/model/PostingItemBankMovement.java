package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("BankMovement")
public class PostingItemBankMovement extends PostingItem{

	@ManyToOne
	@JoinColumn(name="bankStatementLineId")
	private BankStatementLine referencedBankStatementLine;
	
	
	public BankStatementLine getReferencedBankStatementLine() {
		return referencedBankStatementLine;
	}
	public void setReferencedBankStatementLine( BankStatementLine referencedBankStatementLine) {
		this.referencedBankStatementLine = referencedBankStatementLine;
	}
}
