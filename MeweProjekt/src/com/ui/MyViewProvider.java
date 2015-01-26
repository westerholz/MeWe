package com.ui;
import java.util.HashMap;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
public class MyViewProvider implements ViewProvider {
	private static HashMap<String,String> viewNames;
	public MyViewProvider(){
		viewNames = new HashMap<String,String>();
	}
	@Override
	public String getViewName(String viewAndParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getView(String viewName) {
		// TODO Auto-generated method stub
		return null;
	}

}
