package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OnlineBankingParameters")
public class OnlineBankingParameters {

	//TODO implement OnlinebankingParameters
	@Id
	@Column(name="OnlineBankPaId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long onlineBankPaId;

	public long getOnlineBankPaId() {
		return onlineBankPaId;
	}

	public void setOnlineBankPaId(long onlineBankPaId) {
		this.onlineBankPaId = onlineBankPaId;
	}
}
