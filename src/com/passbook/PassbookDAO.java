package com.passbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.member.MemberDTO;
import com.util.DBConnector;

public class PassbookDAO {
	
	public int insert(PassbookDTO passbookDTO) throws Exception {
		
		int result = 0;
		
		Connection con = DBConnector.getconnect();
		
		String sql = "insert into passbook values(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, passbookDTO.getBnum());
		st.setString(2, passbookDTO.getId());
		st.setString(3, passbookDTO.getAccount_num());
		st.setString(4, passbookDTO.getOpen_date());
		st.setString(5, passbookDTO.getAccount_name());
		st.setInt(6, passbookDTO.getBalance());
		
		result = st.executeUpdate();
		
		DBConnector.disconnect(st, con);
		
		return result;
		
	}
	
	
	// selectOne - 회원정보조회

		public PassbookDTO selectOnt(String id) throws Exception {

			Scanner sc = new Scanner(System.in);
			PassbookDTO passbookDTO = null;
			int result = 0;
			ResultSet rs = null;

			Connection con = DBConnector.getconnect();

			String sql = "select * from passbook where id=?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, id);

			rs = st.executeQuery();

			if (rs.next()) {

				passbookDTO = new PassbookDTO();

				passbookDTO.setBnum(rs.getInt("bnum"));
				passbookDTO.setId(rs.getString("id"));
				passbookDTO.setAccount_num(rs.getString("account_num"));
				passbookDTO.setOpen_date(rs.getString("open_date"));
				passbookDTO.setAccount_name(rs.getString("account_name"));
				passbookDTO.setBalance(rs.getInt("balance"));

			}

			DBConnector.disconnect(rs, st, con);

			return passbookDTO;

		}

		// selectList - 회원 전체 정보 조회

		public ArrayList<PassbookDTO> selectList() throws Exception {

			Connection con = DBConnector.getconnect();

			String sql = "select * from member";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			PassbookDTO passbookDTO = null;

			ArrayList<PassbookDTO> ar2 = new ArrayList<PassbookDTO>();

			while (rs.next()) {

				passbookDTO = new PassbookDTO();

				passbookDTO.setBnum(rs.getInt("bnum"));
				passbookDTO.setId(rs.getString("id"));
				passbookDTO.setAccount_num(rs.getString("account_num"));
				passbookDTO.setOpen_date(rs.getString("open_date"));
				passbookDTO.setAccount_name(rs.getString("account_name"));
				passbookDTO.setBalance(rs.getInt("balance"));

				ar2.add(passbookDTO);
			}

			DBConnector.disconnect(rs, st, con);

			return ar2;

		}

}
