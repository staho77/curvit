package com.staho.ms.jsf;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class ContextUtil {

	private static final String VALIDATION_MESSAGES = "ValidationMessages";

	public static String getViewId() {
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}

	public static ResourceBundle getResourceBundle() {

		FacesContext context = FacesContext.getCurrentInstance();
		if (context == null) {
			return null;
		}
		return ResourceBundle.getBundle(context.getApplication().getMessageBundle(), context
				.getViewRoot() == null ? Locale.getDefault() : context.getViewRoot().getLocale());
	}

	public static ResourceBundle getValidationMessages() {

		FacesContext context = FacesContext.getCurrentInstance();

		return ResourceBundle.getBundle(VALIDATION_MESSAGES,
				context.getViewRoot() == null ? Locale.getDefault() : context.getViewRoot()
						.getLocale());
	}

	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static void saveSuccessful() {
		getExternalContext().getRequestMap().put("saveSuccessful", "true");
	}

	public static void saveSuccessful(String page) {
		getExternalContext().getRequestMap().put("saveSuccessful", page);
	}

	public static boolean isSaveRequired() {
		String param = getExternalContext().getRequestParameterMap().get("content-form:saveRequired");
		return "true".equals(param);
	}

	public static void confirmUnload() {
		getExternalContext().getRequestMap().put("confirmUnload", "true");
	}

	public static boolean isNoValidationRequired() {
		String param = getExternalContext().getRequestParameterMap().get("validationRequired");
		return "false".equals(param);
	}

	public static void refreshView() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
}
