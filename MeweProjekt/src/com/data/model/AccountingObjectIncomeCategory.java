package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IncomeCategory")
public class AccountingObjectIncomeCategory extends AccountingObjectCategory {

}
