package com.ui.views;

import com.ui.components.NavigationPane;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TestTabSheet extends CustomComponent implements View{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private TabSheet tabSheet_1;
	@AutoGenerated
	private NavigationPane navigationPane_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public TestTabSheet() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		UI.getCurrent().getSession().setAttribute("TabSheet", this);
		tabSheet_1.addTab(new Startseite(), "Startseite");
		tabSheet_1.addTab(new Startseite(),"",FontAwesome.PLUS);
		// TODO add user code here
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		mainLayout.setSpacing(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// navigationPane_1
		navigationPane_1 = new NavigationPane();
		navigationPane_1.setImmediate(false);
		navigationPane_1.setWidth("-1px");
		navigationPane_1.setHeight("-1px");
		mainLayout.addComponent(navigationPane_1);
		
		// tabSheet_1
		tabSheet_1 = new TabSheet();
		tabSheet_1.setImmediate(false);
		tabSheet_1.setWidth("100.0%");
		tabSheet_1.setHeight("-1px");
		mainLayout.addComponent(tabSheet_1);
		
		return mainLayout;
	}

}
