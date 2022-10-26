package com.optus;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class CvcChange implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String cvcId;
	private com.optus.Bandwidth currentBandwidth;
	private com.optus.Bandwidth newBandwidth;
	private java.lang.String status;

	private com.optus.NetConfig netConfig;

	private com.optus.NbnCvcRecord nbnCvc;

	private java.lang.String resizeAction;

	private com.optus.Bandwidth deviceBandwidth;

	private java.lang.String productId;

	private java.lang.String referenceId;

	public CvcChange() {
	}

	public java.lang.String getCvcId() {
		return this.cvcId;
	}

	public void setCvcId(java.lang.String cvcId) {
		this.cvcId = cvcId;
	}

	public com.optus.Bandwidth getCurrentBandwidth() {
		return this.currentBandwidth;
	}

	public void setCurrentBandwidth(com.optus.Bandwidth currentBandwidth) {
		this.currentBandwidth = currentBandwidth;
	}

	public com.optus.Bandwidth getNewBandwidth() {
		return this.newBandwidth;
	}

	public void setNewBandwidth(com.optus.Bandwidth newBandwidth) {
		this.newBandwidth = newBandwidth;
	}

	public java.lang.String getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public com.optus.NetConfig getNetConfig() {
		return this.netConfig;
	}

	public void setNetConfig(com.optus.NetConfig netConfig) {
		this.netConfig = netConfig;
	}

	public com.optus.NbnCvcRecord getNbnCvc() {
		return this.nbnCvc;
	}

	public void setNbnCvc(com.optus.NbnCvcRecord nbnCvc) {
		this.nbnCvc = nbnCvc;
	}

	public java.lang.String getResizeAction() {
		return this.resizeAction;
	}

	public void setResizeAction(java.lang.String resizeAction) {
		this.resizeAction = resizeAction;
	}

	public com.optus.Bandwidth getDeviceBandwidth() {
		return this.deviceBandwidth;
	}

	public void setDeviceBandwidth(com.optus.Bandwidth deviceBandwidth) {
		this.deviceBandwidth = deviceBandwidth;
	}

	public java.lang.String getProductId() {
		return this.productId;
	}

	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		com.google.gson.Gson gson = new com.google.gson.Gson();
		return gson.toJson(this);
	}

	public java.lang.String getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(java.lang.String referenceId) {
		this.referenceId = referenceId;
	}

	public CvcChange(java.lang.String cvcId,
			com.optus.Bandwidth currentBandwidth,
			com.optus.Bandwidth newBandwidth, java.lang.String status,
			com.optus.NetConfig netConfig, com.optus.NbnCvcRecord nbnCvc,
			java.lang.String resizeAction, com.optus.Bandwidth deviceBandwidth,
			java.lang.String productId, java.lang.String referenceId) {
		this.cvcId = cvcId;
		this.currentBandwidth = currentBandwidth;
		this.newBandwidth = newBandwidth;
		this.status = status;
		this.netConfig = netConfig;
		this.nbnCvc = nbnCvc;
		this.resizeAction = resizeAction;
		this.deviceBandwidth = deviceBandwidth;
		this.productId = productId;
		this.referenceId = referenceId;
	}

}