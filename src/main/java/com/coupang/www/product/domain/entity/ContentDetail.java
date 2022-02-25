package com.coupang.www.product.domain.entity;

import com.coupang.www.code.DetailType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
public class ContentDetail {

    @Id
    private long contentDetailNo;

    private String content;

    private DetailType detailType;

}