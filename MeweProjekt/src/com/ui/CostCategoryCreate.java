package com.ui;

import i18n.BundleNames;

import java.util.ResourceBundle;

import com.data.model.AccountingObjectCostCategory;
import com.data.provider.CostCategoryProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class CostCategoryCreate extends VerticalLayout implements View {
		private ResourceBundle screenLabels;
		private ResourceBundle errorMessages;
	public CostCategoryCreate(){
		screenLabels = ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale());
		errorMessages = ResourceBundle.getBundle(BundleNames.ErrorMessage, UI.getCurrent().getSession().getLocale());
		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(new NavigationPane());
		GridLayout gl = new GridLayout(2,2);
		TextField name = new TextField();
		vl.addComponent(gl);
		
		//Create Grid for Createing a Cost Category
		Button create = new Button(screenLabels.getString("create"));
		create.addClickListener(new ClickListener(){
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(!name.getValue().equals("")){
				AccountingObjectCostCategory costCategory = new AccountingObjectCostCategory();
				costCategory.setName(name.getValue());
				CostCategoryProvider ccp = new CostCategoryProvider();
				if(!ccp.addCostCategory(costCategory)){
					Notification.show(errorMessages.getString("SaveFailed"), Notification.Type.WARNING_MESSAGE);
				}else{//Create Successful
					event.getButton().setIcon(FontAwesome.CHECK);
				}
				}
				else{
					Notification.show(errorMessages.getString("RequiredFieldsCaption"), errorMessages.getString("RequiredFieldsDescription"), Notification.Type.WARNING_MESSAGE);;
				}
			}
		});
		gl.addComponent(new Label("Name"), 0, 0);
		gl.addComponent(name, 1, 0);
		gl.addComponent(create, 1, 1);
		
		
		
		
		addComponent(vl);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
