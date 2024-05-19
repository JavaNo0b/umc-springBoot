package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

//- **@Entity 어노테이션을 통해 해당 클래스가 JPA의 엔티티임을 명시**합니다.
//- **@Getter**는 lombok에서 제공해주는 것으로, getter를 만들어주는 어노테이션입니다.
//        (자바에서 getter가 무엇인지는 다들 아실거라고 믿습니다. 🙂)
//        - **@Builder
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor**
//
//위 세 개의 어노테이션은 자바의 디자인 패턴 중 하나인 ***빌더 패턴***을 사용하기 위함입니다.
//
//빌더 패턴을 사용하면 생성자를 사용하는 것보다 더욱 편리하게 코딩이 가능합니다!
public class Member {

    @Id
//    가장 편리한 **@GeneratedValue(strategy = GenerationType.IDENTITY) 방법**을 사용하겠습니다.
//해당 내용은 **JPA가 통신을 하는 DBMS의 방식을 따른다는 뜻**
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String specAddress;

//    EnumType은 반드시 STRING으로 해야함
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;
}
