package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BankStatementLine")
public class BankStatementLine {
	//TODO define, implement
	@Id
	@Column(name="BankStatementId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long bankStatementLineId;

	public long getBankStatementLineId() {
		return bankStatementLineId;
	}

	public void setBankStatementLineId(long bankStatementLineId) {
		this.bankStatementLineId = bankStatementLineId;
	}
	
}
