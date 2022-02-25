package com.coupang.www.product.domain.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"attributeNo"})
@AllArgsConstructor
@Component
public class Attribute {

    @Id
    private long attributeNo;

    private String attributeTypeName;

    private String attributeValueName;

    private String exposed;

}