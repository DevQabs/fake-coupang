package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetailType implements CommonCode<DetailType> {

	IMAGE("IMAGE", "IMAGE", "이미지", "이미지입니다.", 1),
	TEXT("TEXT", "TEXT", "텍스트", "텍스트입니다.", 2);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private DetailType(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static DetailType fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(DetailType.class, code.toString());
		} else if (code instanceof DetailType) {
			return CommonCode.fromJson(DetailType.class, ((DetailType) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "OfferCondition"));
	}
	
}
