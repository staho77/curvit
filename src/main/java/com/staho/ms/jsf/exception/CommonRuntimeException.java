package com.staho.ms.jsf.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.staho.ms.jsf.ContextUtil;

public class CommonRuntimeException extends ApplicationRuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactory.getLog(CommonRuntimeException.class);

	private String message1;

	private String message2;

	public CommonRuntimeException(String logKey) {
		// check needed for asynchronous call
		if (ContextUtil.getResourceBundle() != null) {
			LOGGER.error(ContextUtil.getResourceBundle().containsKey(logKey) ? ContextUtil
					.getResourceBundle().getString(logKey) : logKey);
		}
		else {
			LOGGER.error(logKey);
		}
		LOGGER.debug(this);
	}

	public CommonRuntimeException(String messageKey1, String messageKey2, String logKey) {
		this.message1 = ContextUtil.getResourceBundle().containsKey(messageKey1) ? ContextUtil
				.getResourceBundle().getString(messageKey1) : messageKey1;
		this.message2 = ContextUtil.getResourceBundle().containsKey(messageKey2) ? ContextUtil
				.getResourceBundle().getString(messageKey2) : messageKey2;

		LOGGER.error(ContextUtil.getResourceBundle().containsKey(logKey) ? ContextUtil
				.getResourceBundle().getString(logKey) : logKey);
		LOGGER.error("message1: "
				+ (ContextUtil.getResourceBundle().containsKey(message1) ? ContextUtil
						.getResourceBundle().getString(message1) : message1));
		LOGGER.error("message2: "
				+ (ContextUtil.getResourceBundle().containsKey(message2) ? ContextUtil
						.getResourceBundle().getString(message2) : message2));

		LOGGER.debug(this);
	}

	public String getMessage1() {
		if (message1 == null) {
			return ContextUtil.getResourceBundle().getString("error_DefaultMsg1");
		}
		return message1;
	}

	public String getMessage2() {
		if (message2 == null) {
			return ContextUtil.getResourceBundle().getString("error_DefaultMsg2");
		}
		return message2;
	}
}
