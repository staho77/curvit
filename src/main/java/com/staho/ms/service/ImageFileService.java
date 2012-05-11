package com.staho.ms.service;

import java.util.List;

import com.staho.ms.domain.ImageFile;

public interface ImageFileService {

	ImageFile save(ImageFile imageFile);

	ImageFile delete(ImageFile imageFile);

	List<ImageFile> findAllImages();
}
