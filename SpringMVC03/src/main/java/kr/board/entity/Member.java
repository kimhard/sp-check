package kr.board.entity;

import lombok.Data;

@Data //- Lombok API
public class Member {
  private int idx; // 번호
  private String memID; // 제목
  private String memPassword; // 내용
  private String memName; // 작성자q
  private int memAge; // 작성일
  private String memGender; // 성별
  private String memEmail; // 이메일
  private String memProfile; // 프로필
  // setter , getter 
}