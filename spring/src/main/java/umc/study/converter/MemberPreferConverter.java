package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    //    List<MemberPrefer> 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
