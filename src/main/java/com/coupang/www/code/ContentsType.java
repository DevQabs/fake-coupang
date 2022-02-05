package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ContentsType implements CommonCode<ContentsType> {
	
	IMAGE("IMAGE", "IMAGE", "이미지", "이미지", 1),
	IMAGE_NO_SPACE("IMAGE_NO_SPACE", "IMAGE_NO_SPACE", "이미지(공백없음)", "공백없는 이미지입니다.", 2),
	TEXT("TEXT", "TEXT", "텍스트", "텍스트", 2),
	IMAGE_TEXT("IMAGE_TEXT", "IMAGE_TEXT", "이미지-텍스트", "이미지 텍스트", 3),
	TEXT_IMAGE("TEXT_IMAGE", "TEXT_IMAGE", "텍스트-이미지", "텍스트 이미지", 4),
	IMAGE_IMAGE("IMAGE_IMAGE", "IMAGE_IMAGE", "이미지-이미지", "이미지 이미지", 5),
	TEXT_TEXT("TEXT_TEXT", "TEXT_TEXT", "텍스트-텍스트", "텍스트 텍스트", 6),
	TITLE("TITLE", "TITLE", "제목", "제목", 8),
	HTML("HTML", "HTML", "HTML", "Hyper Text Mark up Language", 9);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private ContentsType(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static ContentsType fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(ContentsType.class, code.toString());
		} else if (code instanceof ContentsType) {
			return CommonCode.fromJson(ContentsType.class, ((ContentsType) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "ContentsType"));
	}
	
}
