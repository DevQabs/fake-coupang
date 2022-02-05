package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UnionDeliveryType implements CommonCode<UnionDeliveryType> {
	
	UNION_DELIVERY("UNION_DELIVERY", "UNION_DELIVERY", "묶음배송 가능", "묶음배송이 가능한 상품입니다.", 1),
	NOT_UNION_DELIVERY("NOT_UNION_DELIVERY", "NOT_UNION_DELIVERY", "묶음배송 불가능", "묶음배송이 불가능한 상품입니다.", 2);	
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private UnionDeliveryType(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static UnionDeliveryType fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(UnionDeliveryType.class, code.toString());
		} else if (code instanceof UnionDeliveryType) {
			return CommonCode.fromJson(UnionDeliveryType.class, ((UnionDeliveryType) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "UnionDeliveryType"));
	}
	
}
