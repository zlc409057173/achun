package com.clear2pay.cn.entity;

import java.util.Date;

public class EmulatorTimer {
	private int emulatortimerKey;
	private String folderPath;
	private String bakfolderPath;
	private String errorfolderPath;
	private String queueName;
	private String description;
	private Date whenmodify;
	private String enableFlag;
	public int getEmulatortimerKey() {
		return emulatortimerKey;
	}
	public void setEmulatortimerKey(int emulatortimerKey) {
		this.emulatortimerKey = emulatortimerKey;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	public String getBakfolderPath() {
		return bakfolderPath;
	}
	public void setBakfolderPath(String bakfolderPath) {
		this.bakfolderPath = bakfolderPath;
	}
	public String getErrorfolderPath() {
		return errorfolderPath;
	}
	public void setErrorfolderPath(String errorfolderPath) {
		this.errorfolderPath = errorfolderPath;
	}
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getWhenmodify() {
		return whenmodify;
	}
	public void setWhenmodify(Date whenmodify) {
		this.whenmodify = whenmodify;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	
}
