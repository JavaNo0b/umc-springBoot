package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.MemberAgree;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

//    가장 편리한 **@GeneratedValue(strategy = GenerationType.IDENTITY) 방법**을 사용하겠습니다.
//해당 내용은 **JPA가 통신을 하는 DBMS의 방식을 따른다는 뜻**

//
//양방향 매핑의 경우 1 : N에서 1에 해당하는 엔티티에게 설정합니다.
//
//        **@OneToMany 어노테이션**으로
//
//**1에 해당하는 엔티티가 N에 해당하는 엔티티와 관계가 있음을 명시**하며,
//이 때, **N에 해당하는 엔티티에서 ManyToOne이 설정 된 멤버변수를 mappedBy**를 합니다.
//
//        **CascadeType.ALL**이란 Member의 변화에 따라 Review, MemberPrefer 등의 엔티티가 영향을 받는다는 것을 의미합니다.

//만약 이렇게 하지 않으면, 나중에 멤버 삭제 시,
//연결된 데이터들을 하나 하나 다 삭제를 해야 해서 매우 짜증납니다.



//**columnDefinition = "VARCHAR(10)"** 이렇게 **칼럼의 타입을 직접 지정**할 수도 있고,
//
//        **@Column(nullable = false, length = 40)** 이렇게도 가능합니다.
//
//gender와 status는 enum으로 되어있어서
//
//**@Column(columnDefinition = "VARCHAR(10)")** 이렇게 설정을 했습니다.
//
//        주의할 점은
//
//@Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
//
//여긴데, **ACTIVE가 아니라 ‘ACTIVE’** 입니다.

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

//    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("0")
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
