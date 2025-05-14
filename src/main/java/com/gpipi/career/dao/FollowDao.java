/**
 * FollowDao
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.1
 * @author	Nakamura
 */

package com.gpipi.career.dao;

public class FollowDao {
	private Long id;
	private String profileImgUrl;
	private String username;

	public FollowDao(Long id, String username, String profileImgUrl) {
		this.id = id;
		this.username = username;
		this.profileImgUrl = profileImgUrl;
	}
	 // ID
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	 // Username
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	 // ProfileImgUrl
	public String getProfileImgUrl() { return profileImgUrl; }
	public void setProfileImgUrl(String profileImgUrl) { this.profileImgUrl = profileImgUrl; }
	
}
