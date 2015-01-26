package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CostCategory")
public class AccountingObjectCostCategory extends AccountingObjectCategory{

}