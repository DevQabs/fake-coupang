package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeliveryChargeType implements CommonCode<DeliveryChargeType> {
	
	FREE("FREE", "FREE", "무료배송", "무료배송입니다.", 1),
	NOT_FREE("NOT_FREE", "NOT_FREE", "유료배송", "유료배송입니다.", 2),
	CHARGE_RECEIVED("CHARGE_RECEIVED", "CHARGE_RECEIVED", "착불배송", "착불배송입니다", 3),
	CONDITIONAL_FREE("CONDITIONAL_FREE", "CONDITIONAL_FREE", "조건부 무료배송", "조건부 무료배송입니다.", 4);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private DeliveryChargeType(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static DeliveryChargeType fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(DeliveryChargeType.class, code.toString());
		} else if (code instanceof AdultOnly) {
			return CommonCode.fromJson(DeliveryChargeType.class, ((DeliveryChargeType) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "AdultOnly"));
	}
	
}
