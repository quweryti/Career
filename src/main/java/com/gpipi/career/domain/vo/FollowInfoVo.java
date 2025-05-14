/*
 * FollowService
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.1
 * @author	Nakamura
 */

package com.gpipi.career.domain.vo;

public class FollowInfoVo {
	private Long id;
	private String username;
	private String profileImgUrl;
	
	// gettrt,setter
	// ID
	public Long getId() { return id; }
	public void setId(long id) { this.id = id; }
	// username
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	// ProfileImgUrl
	public String getProfileImgUrl() { return profileImgUrl; }
	public void setProfileImgUrl(String profileImgUrl) { this.profileImgUrl = profileImgUrl; }
}


/* 
[1] Entity作成（DBテーブルと対応）
[2] Mapper or Repository作成（DB操作）
[3] Serviceクラスでデータ取得
[4] ControllerからServiceを呼び出す
[5] HTML or JSにデータ渡して描画

[1] com.gpipi.career.domain.entityに書く
	ex) 
	・FollowEntity作る
	・DBのフォローリストとマッピング
[2] src/main/resource/mybatisにMpperXML
	javaのMapper interfaceは多分daoかdao.implementに書く
[3] service.imprementにFollowServiceImpleてきなの作る
[4] controllerにFollowController的なの作っとく(もしかしたらすでにあるかも)

英語↓
[1] Create an Entity class that maps to a DB table
Put it under com.gpipi.career.domain.entity
Example:
・Create a FollowEntity
・Map it to the follow list table in the database

[2] Create a Mapper or Repository to handle DB operations
The Mapper XML should go in src/main/resources/mybatis
The Java Mapper interface probably goes in the dao or dao.implement package

[3] Create a service class that fetches the data
For example, implement something like FollowServiceImpl in the service.implement package

[4] Call the service from a controller
Create a controller class like FollowController (there might already be one)

[5] Pass the data to HTML or JavaScript to render it on the screen
*/