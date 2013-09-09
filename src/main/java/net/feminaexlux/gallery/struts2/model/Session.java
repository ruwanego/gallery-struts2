package net.feminaexlux.gallery.struts2.model;

import java.util.Date;

public class Session {
	public static final int SESSION_TIMEOUT = 3600000;

	private int userId;
	private Date lastActive;

	public Session(int userId, Date lastActive) {
		this.userId = userId;
		this.lastActive = lastActive;
	}

	public boolean isValidLogin() {
		return userId > 0 && beforeSessionTimeout();
	}

	public void updateActivity() {
		this.lastActive = new Date();
	}

	private boolean beforeSessionTimeout() {
		if (lastActive != null) {
			Date now = new Date();
			if (now.getTime() < (lastActive.getTime() + SESSION_TIMEOUT)) {
				return true;
			}
		}

		return false;
	}
}
