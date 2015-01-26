package com.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Startseite extends HorizontalLayout implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Startseite(){
		VerticalLayout v = new VerticalLayout();
		Button b = new Button("Postings");

		
		b.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
			Navigator navigator = UI.getCurrent().getNavigator();
			String viewName = "Postings";
			navigator.addView(viewName, new PostingsView());
			navigator.navigateTo(viewName);
				
			}
		});
		v.addComponent(b);
		addComponent(v);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
