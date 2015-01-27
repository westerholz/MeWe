package com.ui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//@SuppressWarnings("serial")
@PreserveOnRefresh
@Theme("meweprojekt")
public class MeweUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Navigator navigator;
	private final static Logger logger = LogManager.getLogger(MeweUI.class);
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MeweUI.class)
	public static class Servlet extends VaadinServlet implements SessionInitListener, SessionDestroyListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ResourceBundle errorMessages;
		Locale locale;
		private void initializeLocaleAndBundle(){
						
			// TODO Locale vernünftig zuweisen, auf welcher Basis? 
						locale = Locale.GERMANY;
						errorMessages = ResourceBundle.getBundle("i18n/errorMessages",locale);
						logger.debug("Locale and Bundle for error messages set!" );
		}
		@Override
		protected void servletInitialized() throws ServletException{
			
			super.servletInitialized();
			getService().addSessionInitListener(this);
			getService().addSessionDestroyListener(this);
			getService().setSystemMessagesProvider(
				    new SystemMessagesProvider() {
				    /**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					@Override 
				    public SystemMessages getSystemMessages(
				        SystemMessagesInfo systemMessagesInfo) {
				        CustomizedSystemMessages messages =
				                new CustomizedSystemMessages();
				  		//Fehlertexte
				        initializeLocaleAndBundle();
				        messages.setSessionExpiredCaption(errorMessages.getString("SessionExpiredCaption"));
				        messages.setSessionExpiredMessage(errorMessages.getString("SessionExpiredMessage"));
				        messages.setCommunicationErrorCaption(errorMessages.getString("CommunicationErrorCaption"));
				        messages.setCommunicationErrorMessage(errorMessages.getString("CommunicationErrorMessage"));
				        messages.setInternalErrorCaption(errorMessages.getString("InternalErrorCaption"));
				        messages.setInternalErrorMessage(errorMessages.getString("InternalErrorMessage"));
				        logger.debug("Error message added to system message!");
				        return messages;
				    }
				});
			
		}
		@Override
		public void sessionDestroy(SessionDestroyEvent event) {
			// TODO Welche Objekte sollen gelöscht / persitiert werden?
			logger.debug("Session destroyed!");
			
		}

		@Override
		public void sessionInit(SessionInitEvent event) throws ServiceException {
			//TODO: 2) Was muss noch an die Sesion?(ResourceBundles)
			initializeLocaleAndBundle();
			event.getSession().setLocale(locale);	
			event.getSession().setAttribute("errorMessagesLocation", "i18n/errorMessages");
			event.getSession().setAttribute("messageBundleLocation", "i18n/messageBundle");
			logger.info("Session intilized!");
		}
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		//TODO: Add Error page and Error Navigation to Navigator
		navigator = new Navigator(this,this);
		String viewName = "Startseite";
		
		//navigator.addView(viewName, new Startseite());
		try{
		navigator.addView(viewName,(View)Class.forName("com.ui.Startseite").newInstance());
		navigator.navigateTo(viewName);
		}catch(Exception cnfe){
		cnfe.printStackTrace();	
		}

		   // Create the content root layout for the UI
        //VerticalLayout content = new VerticalLayout();
        //setContent(content);

	}
	
}