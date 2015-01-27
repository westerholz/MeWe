package com.data.provider;
import java.util.Date;
import java.util.List;

import com.data.model.Posting;
public class PostingProvider extends AbstractProvider<Posting> {

	@Override
	protected Class<Posting> getEntityClass() {
		return Posting.class;
	}
	public List<Posting> getPostingsByDate(Date date){
		StringBuffer sb = new StringBuffer();
		sb.append("Select p FROM Posting p WHERE p.postingDate = '" + date + "'");
		if(!em.isOpen()){
			em = getEmf().createEntityManager();
		}		
		@SuppressWarnings("unchecked")
		List<Posting> resultList = (List<Posting>)em.createQuery(sb.toString()).getResultList();
		return resultList;
	}
	public boolean addPosting(Posting p){
		
		return super.save(p);
	}

}
