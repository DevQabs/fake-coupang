package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OfferCondition implements CommonCode<OfferCondition> {

	NEW("NEW", "NEW", "새 상품", "새 상품입니다.", 1),
	REFURBISHED("REFURBISHED", "REFURBISHED", "리퍼", "리퍼 상품입니다.", 2),
	USED_BEST("USED_BEST", "USED_BEST", "중고(최상)", "최우수 등급 중고 상품입니다.", 3),
	USED_GOOD("USED_GOOD", "USED_GOOD", "중고(상)", "우수 등급의 중고 상품입니다.", 4),
	USED_NORMAL("USED_NORMAL", "USED_NORMAL", "중고(중)", "일반 등급의 중고 상품입니다.", 5);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private OfferCondition(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static OfferCondition fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(OfferCondition.class, code.toString());
		} else if (code instanceof OfferCondition) {
			return CommonCode.fromJson(OfferCondition.class, ((OfferCondition) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "OfferCondition"));
	}
}
