package com.staho.ms.log.interceptor;

import java.io.Serializable;
import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Interceptor
@Logable
public class LogableInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		Log log = LogFactory.getLog(ctx.getTarget().getClass());
		log.debug("calling: " + ctx.getTarget().getClass().getSimpleName() + "."
				+ ctx.getMethod().getName() + " with args: " + Arrays.toString(ctx.getParameters()));
		Object returnValue = ctx.proceed();
		log.debug(ctx.getTarget().getClass().getSimpleName() + "." + ctx.getMethod().getName()
				+ " returned: " + returnValue);
		return returnValue;
	}
}
