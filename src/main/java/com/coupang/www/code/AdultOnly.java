package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AdultOnly implements CommonCode<AdultOnly> {

	ADULT_ONLY("ADULT_ONLY", "Y", "19세 이상", "19세 이상만 이용가능합니다.", 1),
	EVERYONE("EVERYONE", "N", "전연령 구입 가능상품(기본값)", "전연령 구입 가능 상품입니다.(기본값)", 2);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private AdultOnly(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static AdultOnly fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(AdultOnly.class, code.toString());
		} else if (code instanceof AdultOnly) {
			return CommonCode.fromJson(AdultOnly.class, ((AdultOnly) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "AdultOnly"));
	}
}
