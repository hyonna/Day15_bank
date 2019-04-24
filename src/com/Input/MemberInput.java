package com.Input;

import java.util.Scanner;

import com.member.MemberDTO;
import com.passbook.PassbookDTO;

public class MemberInput {

	private Scanner sc;

	public MemberInput() {

		sc = new Scanner(System.in);
	}

	public MemberDTO join() {

		MemberDTO memberDTO = new MemberDTO();

		System.out.println("ID를 입력하세요>>>>");
		memberDTO.setId(sc.next());

		System.out.println("PW를 입력하세요>>>>");
		memberDTO.setPw(sc.next());

		System.out.println("이름을 입력하세요>>>>");
		memberDTO.setName(sc.next());

		System.out.println("핸드폰 번호를 입력하세요>>>>");
		memberDTO.setPhone(sc.nextInt());

		System.out.println("이메일을 입력하세요>>>>");
		memberDTO.setEmail(sc.next());

		return memberDTO;

	}

	public PassbookDTO passbook_add() {

		PassbookDTO passbookDTO = new PassbookDTO();
		
		System.out.println("회원번호를 입력하세요>>>>");
		passbookDTO.setBnum(sc.nextInt());

		System.out.println("ID를 입력하세요>>>>");
		passbookDTO.setId(sc.next());

		System.out.println("계좌번호를 입력하세요>>>>");
		passbookDTO.setAccount_num(sc.next());

		System.out.println("개설일 입력하세요>>>>");
		passbookDTO.setOpen_date(sc.next());

		System.out.println("통장 이름을 입력하세요>>>>");
		passbookDTO.setAccount_name(sc.next());

		System.out.println("잔고를 입력하세요>>>>");
		passbookDTO.setBalance(sc.nextInt());

		return passbookDTO;

	}
	
	public String search(String str) {
		
		System.out.println("검색할 ID를 입력하세요");
		String id = sc.next();
		
		return id;
		
	}

}
