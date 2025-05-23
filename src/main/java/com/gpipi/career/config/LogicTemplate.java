/**
 * LogicTemplate.java
 * @since   2025-05-01
 * @version 1.0.0
 * @author  Kwon Yujin
 * @see     @link 
 */
package com.gpipi.career.config;

import java.util.Optional;

public enum LogicTemplate {
	LOGIN("/auth/login"),
	LOGOUT("/auth/logout"),
	JOIN("/auth/join"),
    UPDATE_NAME("/auth/updateName"),
    UPDATE_PASSWORD("/auth/updatePassword"),
    UPDATE_LINK("/auth/updateLink"),
    DELETE_FOLLOW("/auth/deleteFollow"),
    UPDATE_IS_DELETE("/auth/updateIsDelete");

	private final String logicKey;
	
	LogicTemplate(String logicKey) {
		this.logicKey = logicKey;
	}
	
	public String getLogicUrl() {
		return logicKey;
	}

	public static Optional<LogicTemplate> ofKey(String logicKey) {
		if(logicKey == null) {
			return Optional.empty();
		}
		try {
			return Optional.of(LogicTemplate.valueOf(logicKey.toUpperCase()));
		} catch(IllegalArgumentException ex) {
			return Optional.empty();
		}
	}
	
}
