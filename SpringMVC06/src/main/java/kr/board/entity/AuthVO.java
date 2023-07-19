package kr.board.entity;

import lombok.Data;

@Data
public class AuthVO {
	private int no; //일련번호
	private String memID; //회원아이디
	private String auth; //회원권한 (3가지 부여, Role_user, manager, admin)
}
