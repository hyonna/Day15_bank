package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.Input.MemberInput;
import com.member.MemberDAO;
import com.member.MemberDTO;
import com.passbook.PassbookDAO;
import com.passbook.PassbookDTO;
import com.view.MemberView;
import com.view.PassbookView;

public class MemberController {

	public void start() throws Exception {

		Scanner sc = new Scanner(System.in);
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		PassbookDTO passbookDTO = new PassbookDTO();
		PassbookDAO passbookDAO = new PassbookDAO();
		MemberView mv = new MemberView();
		PassbookView pv = new PassbookView();
		MemberInput mi = new MemberInput();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		ArrayList<PassbookDTO> ar2 = new ArrayList<PassbookDTO>();
		
		String str = null;
		int result = 0;

		boolean check = true;

		while (check) {

			System.out.println("1. 회원가입");
			System.out.println("2. 통장개설");
			System.out.println("3. 거래내역");
			System.out.println("4. 회원조회");
			System.out.println("5. 종료");
			int select = sc.nextInt();

			switch (select) {
			case 1:

				memberDTO = mi.join();
				ar.add(memberDTO);
				result = memberDAO.insert(memberDTO);

				if (result > 0) {

					System.out.println("가입완료");
				} else {

					System.out.println("가입실패");
				}

				break;

			case 2:

				passbookDTO = mi.passbook_add();
				ar2.add(passbookDTO);
				result = passbookDAO.insert(passbookDTO);

				if (result > 0) {

					System.out.println("통장 개설 완료");
					
				} else {

					System.out.println("가입실패");
				}
				
			case 3:
				
				
				
				break;
				
			case 4:
				
				System.out.println("1) ID조회");
				System.out.println("2) 전체조회");
				int select2 = sc.nextInt();
				
				if(select2 == 1) {
					
					str = mi.search("조회");
					memberDTO = memberDAO.selectOne(str);
					
					if(str != null) {
						
						mv.view(memberDTO);
						pv.view(passbookDTO);
						
					} else {
						
						mv.view("없는 아이디");
						
					}
					
					
				} else if(select2 == 2) {
					
					ar = memberDAO.selectList();
					ar2 = passbookDAO.selectList();
					mv.view(ar);
					pv.view(ar2);
					break;
					
				} else {
					
					System.out.println("다시 입력해주세요");
				}
				
				
				break;

			default:
				check = !check;
			}

		}

	}

}
