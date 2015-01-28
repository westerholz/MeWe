package com.ui.components;

import i18n.BundleNames;

import java.util.List;
import java.util.ResourceBundle;

import com.data.model.AccountingObjectCostCategory;
import com.data.provider.CostCategoryProvider;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ShowCostCategoriesComponent extends CustomComponent{//VerticalLayout {//implements View{
	private ResourceBundle screenLabels;
	private ResourceBundle errorMessages;
public ShowCostCategoriesComponent(){
	screenLabels = ResourceBundle.getBundle(BundleNames.ScreenLabels, UI.getCurrent().getSession().getLocale());
	errorMessages = ResourceBundle.getBundle(BundleNames.ErrorMessage, UI.getCurrent().getSession().getLocale());
	VerticalLayout vl = new VerticalLayout();
	vl.addComponent(new NavigationPane());
	CostCategoryProvider ccp = new CostCategoryProvider();
	List<AccountingObjectCostCategory> costCategories = ccp.getAllCostCategories();
	
	Table costCategoriesTable = new Table(screenLabels.getString("costCategory"));
	costCategoriesTable.addContainerProperty(screenLabels.getString("name"), String.class, null);
//	costCategoriesTable.addContainerProperty(screenLabels.getString("posting"), String.class, null);
//	costCategoriesTable.addContainerProperty(screenLabels.getString("postingText"), String.class, null);
	for(int i = 0; i < costCategories.size(); i++){
		AccountingObjectCostCategory p = costCategories.get(i);
		costCategoriesTable.addItem(new Object[]{p.getName()},i+1);

//		costCategoriesTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {
//			
//			@Override
//			public void itemClick(ItemClickEvent event) {
//				Navigator navigator = UI.getCurrent().getNavigator();
//				String viewName = bundle.getString("singleView");
//				int id = Integer.parseInt(event.getItemId().toString());				
//				//System.out.println(id-1);
//				navigator.addView(viewName, new SinglePostingView((Posting)postings.get(id-1)));
//				navigator.navigateTo(viewName);
//			}
//		});
		//HorizontalLayout hl = new HorizontalLayout();
		//hl.addComponent(new Label(sdf.format(p.getPostingDate()) + ": " + df.format(p.getAmount()) + " "  + p.getPostingText()));
		//addComponent(hl);
	}
	costCategoriesTable.setPageLength(costCategoriesTable.size());
	vl.addComponent(costCategoriesTable);
	//addComponent(vl);
	setCompositionRoot(vl);
}
//	@Override
//	public void enter(ViewChangeEvent event) {
//		// TODO Auto-generated method stub
//		
//	}
}
