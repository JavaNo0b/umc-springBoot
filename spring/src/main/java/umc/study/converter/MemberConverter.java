package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

//    Member 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)
    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case 1 :
                gender = Gender.MALE;
                break;
            case 2 :
                gender = Gender.FEMALE;
                break;
            case 3 :
                gender = Gender.NONE;
                break;
        }

        //  리스트는 new ArrayList<>()  ← 요렇게 초기화를 해줘야 합니다!
        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .memberPreferList(new ArrayList<>())
//                .memberMissionList(new ArrayList<>())
//                .memberAgreeList(new ArrayList<>())
//                .reviewList(new ArrayList<>())
                .build();

    }
}
