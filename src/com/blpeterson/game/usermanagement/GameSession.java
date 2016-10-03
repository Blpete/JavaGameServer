package com.blpeterson.game.usermanagement;

public class GameSession {

	private long startDTG;
	private long endDTG;
	private String userId;
	private String clientIpAddress;
	
	public long getEndDTG() {
		return endDTG;
	}
	public void setEndDTG(long endDTG) {
		this.endDTG = endDTG;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClientIpAddress() {
		return clientIpAddress;
	}
	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	/**
	 * @return the startDTG
	 */
	public long getStartDTG() {
		return startDTG;
	}
	/**
	 * @param startDTG the startDTG to set
	 */
	public void setStartDTG(long startDTG) {
		this.startDTG = startDTG;
	}
	
}
