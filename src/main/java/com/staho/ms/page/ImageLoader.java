package com.staho.ms.page;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.staho.ms.domain.ImageFile;
import com.staho.ms.jpa.CrudService;

@Named("imageLoader")
public class ImageLoader implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CrudService crudService;

	public void paint(OutputStream out, Object data) throws IOException {
		Integer id = (Integer) data; 
		ImageFile imageFile = crudService.find(ImageFile.class, id);
		byte[] imageFileData = imageFile.getData();
		out.write(imageFileData);
	}
}