package model;

import java.util.ArrayList;

public class MemberDAO {
	
	ArrayList<Member> list = new ArrayList<>();
	
	// 비즈니스 로직
	// 멤버 저장
	public ArrayList<Member> memberJoin(Member member) {
		list.add(member);
		
		return list; 
	}
}
