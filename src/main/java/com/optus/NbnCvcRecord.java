package com.optus;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class NbnCvcRecord implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String cvcId;
	private com.optus.Bandwidth currentBandwidth;
	private java.util.Date lastUpdated;

	public NbnCvcRecord() {
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

	public java.util.Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(java.util.Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public NbnCvcRecord(java.lang.String cvcId,
			com.optus.Bandwidth currentBandwidth, java.util.Date lastUpdated) {
		this.cvcId = cvcId;
		this.currentBandwidth = currentBandwidth;
		this.lastUpdated = lastUpdated;
	}

}