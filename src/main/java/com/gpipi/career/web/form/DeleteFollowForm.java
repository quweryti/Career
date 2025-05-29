/**
 * DeleteFollowForm.java
 * @since       2025-05-26
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.
 */
package com.gpipi.career.web.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteFollowForm {

	@NotNull
	private Long followId;
	
}
