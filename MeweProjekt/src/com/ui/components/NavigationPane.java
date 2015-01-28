package com.ui.components;

import i18n.BundleNames;

import java.util.ResourceBundle;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class NavigationPane extends CustomComponent {

	/**
	 * 
	 */
	private VerticalLayout layout;
	private static final long serialVersionUID = 1L;
	private Navigator navigator;
	private MenuBar menubar;
	
	public NavigationPane() {
		layout = new VerticalLayout();
		layout.setImmediate(false);
		setCompositionRoot(layout);
		menubar = new MenuBar();
		navigator = UI.getCurrent().getNavigator();
		MenuBar.Command navigate_command = new MenuBar.Command() {		
			private static final long serialVersionUID = 1L;
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				
				if (selectedItem.getText() == ResourceBundle.getBundle(BundleNames.ScreenLabels,
						UI.getCurrent().getSession().getLocale()).getString("postings_show")) {
					String myView = ResourceBundle.getBundle(BundleNames.ScreenLabels,
							UI.getCurrent().getSession().getLocale()).getString("postings");
					//navigator.addView(myView, new PostingsTableComponent());
					//navigator.navigateTo(myView);
				} 
				else if(selectedItem.getText() == ResourceBundle.getBundle(BundleNames.ScreenLabels,
						UI.getCurrent().getSession().getLocale()).getString("costCategoryCreate")){
						//navigator.addView("Create Cost Category",new CostCategoryCreate());
//						navigator.navigateTo("Create Cost Category");
				}
				else if(selectedItem.getText() == ResourceBundle.getBundle(BundleNames.ScreenLabels,
						UI.getCurrent().getSession().getLocale()).getString("costCategoriesShow")){
						//navigator.addView("Show Cost Categories", new CostCategoriesView());
//						navigator.navigateTo("Show Cost Categories");
				}
				else // if(selectedItem.getText() ==
						// ResourceBundle.getBundle(BundleNames.ScreenLabels,UI.getCurrent().getSession().getLocale()).getString("posting_create_man"))
				{
					Notification.show(
							ResourceBundle
									.getBundle(BundleNames.ErrorMessage, UI.getCurrent().getSession().getLocale())
									.getString("NotImplementedCaption"),
							ResourceBundle
									.getBundle(BundleNames.ErrorMessage, UI.getCurrent().getSession().getLocale())
									.getString("NotImplementedDescription"), Notification.Type.WARNING_MESSAGE);
				}

			};
		};

		// Buchungen
		MenuItem postingsMenuItem = menubar.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"postings"), null, null);
		// Buchungen Sub-Menues
		postingsMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"postings_show"), null, navigate_command);
		postingsMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"posting_create_man"), navigate_command);

		// Kategorien
		MenuItem accountingObjetcsMenuItem = menubar.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"accountingObjects"), FontAwesome.BOOK, null);
		// Kategorien Sub-Menues
		MenuItem incomeCategoryMenuItem = accountingObjetcsMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"incomeCategory"), null, null);
		MenuItem houseBankAccountMenuItem = accountingObjetcsMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"houseBankAccount"), null);
		MenuItem costCategoryMenuItem = accountingObjetcsMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"costCategory"), null, null);
		// Kategorien Sub-sub Menues
		incomeCategoryMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"incomeCategoriesShow"), null, navigate_command);
		incomeCategoryMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"incomeCategoryCreate"), null, navigate_command);
		houseBankAccountMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"houseBankAccountsShow"), navigate_command);
		houseBankAccountMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"houseBankAccountCreate"), null, navigate_command);
		costCategoryMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"costCategoriesShow"), navigate_command);
		costCategoryMenuItem.addItem(
				ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale()).getString(
						"costCategoryCreate"), navigate_command);
		layout.addComponent(menubar);
	}
}
