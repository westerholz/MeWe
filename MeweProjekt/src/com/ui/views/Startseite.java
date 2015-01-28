package com.ui.views;

import com.ui.AccountingObjectCreate;
import com.ui.components.NavigationPane;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.server.FontAwesome;

public class Startseite extends TabSheet implements View{

	/**
	 * 
	 */
	
	//TODO: UI Mockup
	//Tabbing für UI
	private static final long serialVersionUID = 1L;
	
	public Startseite(){
		//this.addTab(new Startseite(),"",FontAwesome.PLUS);
		Navigator navigator = UI.getCurrent().getNavigator();
		VerticalLayout v = new VerticalLayout();
		Button b = new Button("Postings");
	
		b.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
			String viewName = "Postings";
			//navigator.addView(viewName, new PostingsTableComponent());
			//navigator.navigateTo(viewName);
				
			}
		});
		//v.addComponent(menubar);
		//v.addComponent(new NavigationPane());
		v.addComponent(new AccountingObjectCreate());
		//v.addComponent(b);
		addComponent(v);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
