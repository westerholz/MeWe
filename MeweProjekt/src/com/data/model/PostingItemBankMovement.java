package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BankMovement")
public class PostingItemBankMovement extends PostingItem{

	private BankStatementLine ReferencedBankStatementLine;
	
	
	public BankStatementLine getReferencedBankStatementLine() {
		return ReferencedBankStatementLine;
	}
	public void setReferencedBankStatementLine(
			BankStatementLine referencedBankStatementLine) {
		ReferencedBankStatementLine = referencedBankStatementLine;
	}
}
