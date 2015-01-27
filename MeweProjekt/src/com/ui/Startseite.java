package com.ui;

import i18n.BundleNames;

import java.util.ResourceBundle;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Startseite extends HorizontalLayout implements View{

	/**
	 * 
	 */
	
	//TODO: UI Mockup
	//Tabbing für UI
	private static final long serialVersionUID = 1L;

	public Startseite(){
		Navigator navigator = UI.getCurrent().getNavigator();
		VerticalLayout v = new VerticalLayout();
		Button b = new Button("Postings");
//		MenuBar.Command navigate_command = new MenuBar.Command(){
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void menuSelected(MenuItem selectedItem) {
//
//				if(selectedItem.getText() == ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("postings_show")){
//					String myView = ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("postings");
//					navigator.addView(myView, new PostingsView());
//				}
//				else //if(selectedItem.getText() == ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("posting_create_man"))
//				{
//							Notification.show(ResourceBundle.getBundle(BundleNames.ErrorMessage,UI.getCurrent().getSession().getLocale()).getString("NotImplementedCaption"),
//									ResourceBundle.getBundle(BundleNames.ErrorMessage,UI.getCurrent().getSession().getLocale()).getString("NotImplementedDescription"),
//							Notification.Type.WARNING_MESSAGE);				
//			}
//			
//		};
//		};
//				
//		MenuBar menubar = new MenuBar();
//		
//		//Buchungen
//		MenuItem postingsMenuItem = menubar.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("postings"),null,null);
//		//Buchungen Sub-Menues
//		postingsMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("postings_show"),null,navigate_command);
//		postingsMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("posting_create_man"),navigate_command);
//		
//		//Kategorien
//		MenuItem accountingObjetcsMenuItem = menubar.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("accountingObjects"),null,null);
//		//Kategorien Sub-Menues
//		MenuItem incomeCategoryMenuItem = accountingObjetcsMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("incomeCategory"),null,null);
//		MenuItem houseBankAccountMenuItem = accountingObjetcsMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("houseBankAccount"),null);
//		MenuItem costCategoryMenuItem = accountingObjetcsMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("costCategory"),null,null);
//		//Kategorien Sub-sub Menues
//		incomeCategoryMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("incomeCategoriesShow"),null,navigate_command);
//		incomeCategoryMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("incomeCategoryCreate"),null,navigate_command);
//		houseBankAccountMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("houseBankAccountsShow"),navigate_command);
//		houseBankAccountMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("houseBankAccountCreate"),null,navigate_command);
//		costCategoryMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("costCategoriesShow"),navigate_command);
//		costCategoryMenuItem.addItem(ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("costCategoryCreate"),navigate_command);
//		
		b.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
			String viewName = "Postings";
			navigator.addView(viewName, new PostingsView());
			navigator.navigateTo(viewName);
				
			}
		});
		//v.addComponent(menubar);
		v.addComponent(new NavigationPane());
		//v.addComponent(b);
		addComponent(v);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
