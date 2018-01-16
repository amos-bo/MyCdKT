package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * 
     * Title: AttachmentVo.java    
     * Description: 附件
     * @author 向赵臣       
     * @created 2017年7月11日 上午11:12:54
 */
public class AttachmentVoInfo implements Serializable {
	    

	private String id;
	
	/**  附件原始名称 */
	private String originalName;
	
	/**  附件名称 */
	private String name;
	
	/**  类型 */
	private String type;
	
	/**  附件大小 */
	private Long attachmentSize;
	
	/**  附件路径 */
	private String path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAttachmentSize() {
		return attachmentSize;
	}

	public void setAttachmentSize(Long attachmentSize) {
		this.attachmentSize = attachmentSize;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
