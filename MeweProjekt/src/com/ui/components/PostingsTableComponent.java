package com.ui.components;


import i18n.BundleNames;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.List;
import java.util.ResourceBundle;

import com.data.model.Posting;
import com.data.provider.PostingProvider;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

public class PostingsTableComponent extends CustomComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostingsTableComponent(){
		//TODO Wie muss das Locale korrekt gesetzt werden -> Am besten in der Session!!
		ResourceBundle bundle = ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale());
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		DecimalFormat df = new DecimalFormat();
		
		PostingProvider pp = new PostingProvider();
		List<Posting> postings = pp.getPostingsByDate(Date.valueOf("2015-01-20"));
		//addComponent(new Label("Postings: " + postings.size()));
		Table postingsTable = new Table(bundle.getString("turnovers"));
		postingsTable.addContainerProperty(bundle.getString("postingDate"), String.class, null);
		postingsTable.addContainerProperty(bundle.getString("posting"), String.class, null);
		postingsTable.addContainerProperty(bundle.getString("postingText"), String.class, null);
		for(int i = 0; i < postings.size(); i++){
			Posting p = postings.get(i);
			Currency cr = Currency.getInstance(p.getCurrency());
			df.setCurrency(cr);
			postingsTable.addItem(new Object[]{sdf.format(p.getPostingDate()),df.format(p.getAmount()) + " " +cr.getSymbol(UI.getCurrent().getSession().getLocale()),p.getText()},i+1);
			postingsTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {
				
				@Override
				public void itemClick(ItemClickEvent event) {
					Navigator navigator = UI.getCurrent().getNavigator();
					String viewName = bundle.getString("singleView");
					int id = Integer.parseInt(event.getItemId().toString());				
					//System.out.println(id-1);
					//navigator.addView(viewName, new SinglePostingComponent((Posting)postings.get(id-1)));
					//navigator.navigateTo(viewName);
					
				}
			});
			//HorizontalLayout hl = new HorizontalLayout();
			//hl.addComponent(new Label(sdf.format(p.getPostingDate()) + ": " + df.format(p.getAmount()) + " "  + p.getPostingText()));
			//addComponent(hl);
		}
		postingsTable.setPageLength(postingsTable.size());
		//postingsTable.setE
		this.setCompositionRoot(postingsTable);
	}

}
