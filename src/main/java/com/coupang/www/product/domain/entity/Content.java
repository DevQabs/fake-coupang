package com.coupang.www.product.domain.entity;

import com.coupang.www.code.ContentsType;
import com.coupang.www.code.OfferCondition;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
public class Content {

    @Id
    private long contentNo;

    private ContentsType contentsType;

    @OneToMany
    private List<ContentDetail> contentDetails;

    private OfferCondition offerCondition;

    private String offerDescription;

}