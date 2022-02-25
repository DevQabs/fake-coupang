package com.coupang.www.product.domain.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"certificationNo"})
@AllArgsConstructor
@Component
public class Certification {

    @Id
    private long certificationNo;

    private String certificationType;

    private String certificationCode;

}