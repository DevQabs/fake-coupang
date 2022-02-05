package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RemoteAreaDeliverable implements CommonCode<RemoteAreaDeliverable> {

	ISLAND("Y", "Y", "도서 산간 배송", "도서 산간 배송입니다.", 1),
	NOT_ISLAND("N", "N", "도서 산간 미배송", "도서 산간 미배송입니다.", 2);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private RemoteAreaDeliverable(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static RemoteAreaDeliverable fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(RemoteAreaDeliverable.class, code.toString());
		} else if (code instanceof RemoteAreaDeliverable) {
			return CommonCode.fromJson(RemoteAreaDeliverable.class, ((RemoteAreaDeliverable) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "RemoteAreaDeliverable"));
	}
	
}
