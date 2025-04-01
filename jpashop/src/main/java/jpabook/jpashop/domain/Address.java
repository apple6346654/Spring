package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable //JAP의 내장타입? 어딘가 저장 될 수 있다.
@Getter  @Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
