package com.ui.components;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.data.model.Posting;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class SinglePostingComponent extends CustomComponent{

	public SinglePostingComponent(Posting p){
		Locale locale = getUI().getSession().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/messageBundle", locale);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		GridLayout gl = new GridLayout(2,4);
		gl.addComponent(new Label(bundle.getString("postingDate")),0,0);
		gl.addComponent(new Label(sdf.format(p.getPostingDate())), 1,0);
		//addComponent(gl);
		this.setCompositionRoot(gl);
	}

}
