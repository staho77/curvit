package com.staho.ms.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

import com.staho.ms.domain.ImageFile;
import com.staho.ms.jpa.CrudService;
import com.staho.ms.jpa.Curvit;

public class ImageFileServiceImpl implements ImageFileService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CrudService crudService;

	private static final Log log = LogFactory.getLog(ImageFileServiceImpl.class);

	@Transactional(qualifier = Curvit.class)
	public ImageFile save(ImageFile imageFile) {
		log.debug("saving ImageFile: " + imageFile);
		if (imageFile.getId() == null) {
			imageFile = crudService.persist(imageFile);
		}
		else {
			imageFile = crudService.merge(imageFile);
		}
		return imageFile;
	}

	@Override
	@Transactional(qualifier = Curvit.class)
	public ImageFile delete(ImageFile imageFile) {
		log.debug("delete ImageFile: " + imageFile);
		crudService.delete(ImageFile.class, imageFile.getId());
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ImageFile> findAllImages() {
		return crudService.findByNamedQuery(ImageFile.ALL);
	}
}
