package com.data.provider;

import java.util.List;

import com.data.model.AccountingObjectCostCategory;
import com.data.model.Posting;

public class CostCategoryProvider extends AbstractProvider<AccountingObjectCostCategory> {

	@Override
	protected Class<AccountingObjectCostCategory> getEntityClass() {
		return AccountingObjectCostCategory.class;
	}
	public boolean addCostCategory(AccountingObjectCostCategory costCategory){
		return super.save(costCategory);
	}
	public List<AccountingObjectCostCategory> getAllCostCategories(){
		StringBuffer sb = new StringBuffer();
		sb.append("Select a FROM AccountingObjectCategory a ");
		if(!em.isOpen()){
			em = getEmf().createEntityManager();
		}		
		@SuppressWarnings("unchecked")
		List<AccountingObjectCostCategory> resultList = (List<AccountingObjectCostCategory>)em.createQuery(sb.toString()).getResultList();
		return resultList;
	}

}
