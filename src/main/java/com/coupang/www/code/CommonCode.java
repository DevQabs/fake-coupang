package com.coupang.www.code;

import java.util.EnumSet;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface CommonCode<E extends Enum<E> & CommonCode<E>> {
	String name();
	String getCode();
	String getColumn();
	String getName();
	String getDesc();
	
	static <E extends Enum<E> & CommonCode<E>> E fromJson(Class<E> clazz, String code) {
		Optional<E> en =
				EnumSet.allOf(clazz)
					.stream()
					.filter((e) -> {return e.getCode().equals(code);})
					.findAny();
		
		if (en.isEmpty()) {
			throw new NoSuchElementException(String.format("코드 %s(이)가 %s에 존재하지 않습니다.", code, clazz.getSimpleName()));
		}
		
		return en.get();
	}
}
