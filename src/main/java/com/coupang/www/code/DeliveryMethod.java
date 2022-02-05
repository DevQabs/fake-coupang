package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeliveryMethod implements CommonCode<DeliveryMethod> {

	SEQUENCIAL("SEQUENCIAL", "SEQUENCIAL", "일반배송(순차배송)", "일반배송 상품입니다.", 1),
	COLD_FRESH("COLD_FRESH", "COLD_FRESH", "신선냉동", "신선냉동 상품입니다.", 2),
	MAKE_ORDER("MAKE_ORDER", "MAKE_ORDER", "주문제작", "주문제작 상품입니다.", 3),
	AGENT_BUY("AGENT_BUY", "AGENT_BUY", "구매대행", "구매대행 상품입니다.", 4),
	VENDOR_DIRECT("VENDOR_DIRECT", "VENDOR_DIRECT", "직접배송", "설치배송 또는 판매자가 직접 전달하는 상품입니다.", 5);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private DeliveryMethod(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static DeliveryMethod fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(DeliveryMethod.class, code.toString());
		} else if (code instanceof OfferCondition) {
			return CommonCode.fromJson(DeliveryMethod.class, ((DeliveryMethod) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "DeliveryMethod"));
	}
}
