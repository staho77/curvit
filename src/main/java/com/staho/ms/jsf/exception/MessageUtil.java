package com.staho.ms.jsf.exception;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.staho.ms.jsf.ContextUtil;

public class MessageUtil extends ApplicationRuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactory.getLog(MessageUtil.class);

	public static void getMessage(String messageKey) {
		getMessage(messageKey, FacesMessage.SEVERITY_ERROR);
	}

	public static void getMessage(String messageKey, Object... param) {
		getMessage(messageKey, FacesMessage.SEVERITY_ERROR, param);
	}

	public static void getMessage(String messageKey, Severity severity) {
		LOGGER.error(ContextUtil.getResourceBundle().containsKey(messageKey) ? ContextUtil
				.getResourceBundle().getString(messageKey) : messageKey);

		String message = ContextUtil.getResourceBundle().getString(messageKey);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, message, null));
	}

	public static void getMessage(String messageKey, Severity severity, Object... param) {
		LOGGER.error(ContextUtil.getResourceBundle().containsKey(messageKey) ? ContextUtil
				.getResourceBundle().getString(messageKey) + "; param: " + param : messageKey
				+ "; param: " + param);

		String message = ContextUtil.getResourceBundle().getString(messageKey);
		message = MessageFormat.format(message, param);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, message, null));
	}
}
