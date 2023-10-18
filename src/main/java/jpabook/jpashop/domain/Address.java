package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

/**
 * 값 타입은 변경 불가능하게 설계해야 함
 * JPA 스팩상 임베디드타입(@Embeddable)은 자바 기본 생성자를 public 혹은 protected로 설정해야한다.
 * (reflection 사용을 위해)
 */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // reflection 등을 사용하기 위해서 기본 생성자 필수
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
