package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //member_id 외래키로 가지며 연관 관계의 주인이 됨
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //category_id 외래키로 가지며 연관 관계의 주인이 됨
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;
//N : 1에서 N에 해당하는 엔티티가 1에 해당하는 엔티티와 연관 관계를 매핑할 때
//@ManytoOne 어노테이션을 씁니다.
// (fetch = FetchType.LAZY)는 지연 로딩을 설정하는 것입니다.
// @JoinColumn은 실제 데이터베이스에서 해당 칼럼(외래키)의 이름을 설정하는 것입니다.



    //연관 관계를 설정하고, 양방향 매핑이 된 경우 연관 관계 편의 매서드를 이용해 양방향 매핑을 해줍니다.
    public void setMember(Member member){
        if(this.member != null)
            member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}
