/**
 * ProfileImage.java
 * @since       2025-05-23
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         org.springframework
 */
package com.gpipi.career.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profile_image")
@Getter
@NoArgsConstructor
public class ProfileImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@Column(name = "file_name", nullable = false, length = 255)
	private String fileName;
	
	@Column(name = "file_path", nullable = false, length = 500)
	private String filePath;
	
	public ProfileImage(Member member, String fileName, String filePath) {
		this.member = member;
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
	public String getResolveUrl() {
		return "/images/profile/" + fileName;
	}
	
}
