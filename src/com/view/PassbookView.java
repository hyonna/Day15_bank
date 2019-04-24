package com.view;

import java.util.ArrayList;

import com.passbook.PassbookDTO;

public class PassbookView {
	
	
	public void view(PassbookDTO passbookDTO) {

		System.out.println("=============통장 정보===============");
		System.out.println("회원번호 : " + passbookDTO.getBnum());
		System.out.println("ID : " + passbookDTO.getId());
		System.out.println("계좌번호 : " + passbookDTO.getAccount_num());
		System.out.println("개설일 : " + passbookDTO.getOpen_date());
		System.out.println("통장이름 : " + passbookDTO.getAccount_name());
		System.out.println("잔고 : " + passbookDTO.getBalance());
		System.out.println("==================================");

	}

	public void view(ArrayList<PassbookDTO> ar2) {

		for (PassbookDTO passbookDTO : ar2) {

			this.view(passbookDTO);
		}

	}

}
