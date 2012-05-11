package com.staho.ms.jsf.exception;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewExpiredException;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.staho.ms.jsf.ContextUtil;

public class CommonExceptionHandler extends ExceptionHandlerWrapper {

	private static final Log log = LogFactory.getLog(CommonExceptionHandler.class);

	private static final String ERROR_PAGE = "/error.xhtml?faces-redirect=true";

	private ExceptionHandler wrapped;

	public CommonExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {

		log.debug("entering CommonExceptionHandler");

		Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents().iterator();
		while (iterator.hasNext()) {

			ExceptionQueuedEvent event = iterator.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			FacesContext facesContext = FacesContext.getCurrentInstance();
			boolean handleDefault = true;

			Throwable t = searchForApplicationException(context.getException());
			if (t instanceof CommonRuntimeException) {
				log.error("CommonRuntimeException catched in CommonExceptionHandler");
				setMessage(facesContext, ((CommonRuntimeException) t).getMessage1(),
						((CommonRuntimeException) t).getMessage2());
				handleDefault = false;
			}
			else if (t instanceof ViewExpiredException) {
				log.error("ViewExpiredException catched in CommonExceptionHandler");
				if (facesContext.getViewRoot() == null) {
					UIViewRoot view = facesContext.getApplication().getViewHandler()
							.createView(facesContext, ((ViewExpiredException) t).getViewId());
					facesContext.setViewRoot(view);
				}
				setMessage(facesContext,
						ContextUtil.getResourceBundle().getString("error_ViewExpiredMsg1"),
						ContextUtil.getResourceBundle().getString("error_ViewExpiredMsg2"));
				handleDefault = false;
			}

			log.error("Exception occured, redirecting to " + ERROR_PAGE, context.getException());

			try {
				if (handleDefault) {
					setMessage(facesContext,
							ContextUtil.getResourceBundle().getString("error_DefaultMsg1"),
							ContextUtil.getResourceBundle().getString("error_DefaultMsg2"));
				}

				facesContext.getApplication().getNavigationHandler()
						.handleNavigation(facesContext, null, ERROR_PAGE);
				facesContext.renderResponse();

			} /*
			 * catch (IOException e) { log.fatal(
			 * "Exception occured redirecting to error page. No way out of here!"
			 * , context.getException()); }
			 */
			finally {
				log.debug("remove item from iterator");
				iterator.remove();
			}

		}
		getWrapped().handle();
	}

	private void setMessage(FacesContext facesContext, String message1, String message2) {
		facesContext
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message1, null));
		facesContext
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message2, null));
	}

	private Throwable searchForApplicationException(Throwable throwable) {
		if (throwable instanceof ApplicationRuntimeException) {
			return throwable;
		}
		Throwable t = throwable.getCause();
		while (t != null) {
			if (t instanceof ApplicationRuntimeException) {
				return t;
			}
			t = t.getCause();
		}
		return throwable;
	}
}
