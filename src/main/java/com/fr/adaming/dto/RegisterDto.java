package com.fr.adaming.dto;

import javax.validation.constraints.NotNull;

import com.fr.adaming.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegisterDto {
	@NotNull
	User user;

}
