package com.staho.ms.domain.util;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DomainUtil {

	private static final Log log = LogFactory.getLog(DomainUtil.class);

	static {
		BeanUtilsBean.getInstance().getConvertUtils()
				.register(new BooleanConverter(null), Boolean.class);
		BeanUtilsBean.getInstance().getConvertUtils().register(new DateConverter(null), Date.class);
		BeanUtilsBean.getInstance().getConvertUtils()
				.register(new IntegerConverter(null), Integer.class);
		BeanUtilsBean.getInstance().getConvertUtils()
				.register(new BigDecimalConverter(null), BigDecimal.class);
		/*
		 * ConvertUtils.register(new BooleanConverter(null), Boolean.class);
		 * ConvertUtils.register(new DateConverter(null), Date.class);
		 * ConvertUtils.register(new IntegerConverter(null), Integer.class);
		 * ConvertUtils.register(new BigDecimalConverter(null),
		 * BigInteger.class);
		 */
	}

	public static void copyProperties(Object destination, Object source) {
		if (source != null) {
			try {
				BeanUtils.copyProperties(destination, source);
			} catch (Exception e) {
				log.error("could not copy properties from: " + source + " into: " + destination);
				log.error(e.getMessage());
			}
		}
	}

	public static void copyProperty(Object destination, Object source, String property) {
		try {
			Object value = PropertyUtils.getProperty(source, property);
			PropertyUtils.setProperty(destination, property, value);
		} catch (Exception e) {
			log.error("could not copy property: " + property + " from: " + source + " into: "
					+ destination);
			log.error(e.getMessage());
		}
	}

	public static Object getProperty(Object source, String property) {
		Object value = null;
		try {
			value = PropertyUtils.getProperty(source, property);
		} catch (Exception e) {
			log.error("could not get property: " + property + " from: " + source);
			log.error(e.getMessage());
		}
		return value;
	}
}
