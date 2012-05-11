package com.staho.ms.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.myfaces.extensions.cdi.core.api.Advanced;

import com.staho.ms.domain.ImageFile;
import com.staho.ms.jpa.CrudService;

@Advanced
@FacesConverter(forClass = ImageFile.class)
public class ImageFileConverter implements Converter {

	@Inject
	private CrudService crudService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
			throws ConverterException {
		
		return crudService.find(ImageFile.class, new Integer(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
			throws ConverterException {

		return String.valueOf(((ImageFile) value).getId());
	}
}
