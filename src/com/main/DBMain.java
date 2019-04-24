package com.main;

import java.util.ArrayList;

import com.Input.MemberInput;
import com.controller.MemberController;
import com.member.MemberDAO;
import com.member.MemberDTO;

public class DBMain {

	public static void main(String[] args) {
		
		MemberController mc = new MemberController();
		
		try {
			
			mc.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		

	}

}
