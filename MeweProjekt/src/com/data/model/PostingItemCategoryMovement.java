package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CategoryMovement")
public abstract class PostingItemCategoryMovement extends PostingItem{

	
}
