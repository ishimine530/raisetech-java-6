package com.raisetech.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Form {
	@NotBlank(message = "*Nameが未入力です。")
	@Size(min = 1, max = 20, message = "*{min}～{max}文字で入力してください。")
	private String name;
	
	@NotNull(message = "*Ageが未入力です。")
	@Range(min=0, max=200, message = "*{min}～{max}の数字を入力してください。")
	private Integer age;
	
	@NotNull(message = "*Date of birthが未選択です。")
	@PastOrPresent(message = "*未来の日付は選択できません。")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birth;
}
