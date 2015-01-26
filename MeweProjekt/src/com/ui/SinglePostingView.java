package com.ui;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.data.model.Posting;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SinglePostingView extends VerticalLayout implements View{

	public SinglePostingView(Posting p){
		Locale locale = getUI().getSession().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/messageBundle", locale);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		GridLayout gl = new GridLayout(2,4);
		gl.addComponent(new Label(bundle.getString("postingDate")),0,0);
		gl.addComponent(new Label(sdf.format(p.getPostingDate())), 1,0);
		addComponent(gl);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
