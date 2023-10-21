package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    /**
     * 컬렉션 필드는 바로 초기화 하는 것이 안전
     * null 문제에서 안전
     * 새로 생성자를 만들면 하이버네이트 내부 메커니즘에 문제가 발생할 수 있음
     * - 하이버네이트는 엔티티를 영속화 할 때 컬렌션을 감싸서 하이버네이트가 제공하는 내장 컬렉션으로 변경하기 때문에
     */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
