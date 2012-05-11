package com.staho.ms.page;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.hibernate.exception.ConstraintViolationException;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import com.staho.ms.constants.LengthConstants;
import com.staho.ms.domain.FileTypeEnum;
import com.staho.ms.domain.ImageFile;
import com.staho.ms.domain.util.DomainUtil;
import com.staho.ms.jsf.ContextUtil;
import com.staho.ms.jsf.exception.CommonRuntimeException;
import com.staho.ms.jsf.exception.MessageUtil;
import com.staho.ms.service.ImageFileService;
import com.staho.ms.service.MasterDataService;

@Named("imageAdministrationBean")
@WindowScoped
public class ImageAdministrationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// private Log log = LogFactory.getLog(UserAdministrationBean.class);

	@Inject
	private MasterDataService masterDataService;

	@Inject
	private ImageFileService imageFileService;

	private ImageFile imageFile;

	public ImageAdministrationBean() {
		super();
		imageFile = new ImageFile();
	}

	public MasterDataService getMasterDataService() {
		return masterDataService;
	}

	public ImageFileService getImageFileService() {
		return imageFileService;
	}

	public ImageFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(ImageFile imageFile) {
		this.imageFile = new ImageFile();
		DomainUtil.copyProperties(this.imageFile, imageFile);
	}

	public void refreshView() {
		ContextUtil.refreshView();
	}

	public void save() {
		try {
			imageFile = imageFileService.save(imageFile);
		} catch (PersistenceException pe) {
			if (pe.getCause() instanceof ConstraintViolationException) {
				MessageUtil.getMessage("error_ConstraintViolationException");
			}
		}

		ContextUtil.saveSuccessful();
	}

	public void createImage() {
		imageFile = new ImageFile();
	}

	public List<ImageFile> getAllImages() {
		return imageFileService.findAllImages();
	}

	public void deleteImage() {
		imageFileService.delete(imageFile);
	}
	
	public void uploadListener(FileUploadEvent event) throws Exception {
		if (event != null && event.getUploadedFile() != null) {
			UploadedFile file = event.getUploadedFile();
			if (imageFile == null) {
				imageFile = new ImageFile();
			}

			// get filename without its path and extension
			String name = file.getName();
			name = name.substring(name.lastIndexOf(System.getProperty("file.separator")) + 1);
			String extension = name.substring(name.lastIndexOf(".") + 1);
			name = name.substring(0, Math.min(name.lastIndexOf("."), LengthConstants.IMAGE_FILENAME));

			byte[] data = file.getData();
			FileTypeEnum fileType = FileTypeEnum.valueOf(extension.toUpperCase());

			imageFile.setFileName(name);
			imageFile.setFileType(fileType);
			imageFile.setFileSize(new BigDecimal(file.getData().length));
			imageFile.setData(data);
		}
		else {
			throw new CommonRuntimeException("incorrect FileUploadEvent event");
		}
	}

	public void checkImageFile() {
		try {
			byte[] data = imageFile.getData();
			if (data == null || data.length > 10000000) {
				clearImageFile(null);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, ContextUtil
								.getResourceBundle().getString("uploadSizeExceeded"), null));
			}
			else {
				Detector detector = TikaConfig.getDefaultConfig().getDetector();
				MediaType mediaType = detector.detect(new ByteArrayInputStream(data),
						new Metadata());
				String contentType = mediaType.getType() + "/" + mediaType.getSubtype();

				// check if the extension matches the real content of the file
				FileTypeEnum fileType = imageFile.getFileType();
				if (!fileType.getContentType().equals(contentType)) {
					clearImageFile(null);
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, ContextUtil
									.getResourceBundle().getString("uploadServerError"), null));
				}
			}
		} catch (IOException ioe) {
			clearImageFile(null);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, ContextUtil.getResourceBundle()
							.getString("uploadServerError"), null));
		} catch (IllegalArgumentException iae) {
			clearImageFile(null);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, ContextUtil.getResourceBundle()
							.getString("uploadServerError"), null));
		}
	}

	public void clearImageFile(AjaxBehaviorEvent event) {
		if (imageFile != null) {
			imageFile.setData(null);
		}
	}
}
