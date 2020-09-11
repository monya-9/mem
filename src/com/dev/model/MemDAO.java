package com.dev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dev.common.ConnectionManager;

public class MemDAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;

	//전체조회
	public  ArrayList<MemVO> selectAll(MemVO memVO) {
		MemVO resultVo = null;
		ResultSet rs = null;
		ArrayList<MemVO> list = new ArrayList<MemVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT id, pw, nickname, email, pnum"
						+ " FROM mem"
						+ " ORDER BY id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVo = new MemVO();
				resultVo.setId(rs.getString(1));
				resultVo.setPw(rs.getString("pw"));
				resultVo.setNickname(rs.getString("nickname"));
				resultVo.setEmail(rs.getString("email"));
				resultVo.setPnum(rs.getInt("pnum"));
				list.add(resultVo);
				System.out.println(rs.getString(1));
				System.out.println(rs.getString("pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	// 단건조회
	public MemVO selectOne(MemVO memVO) {
		MemVO resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT id, pw, nickname, email, pnum"
						+ " FROM mem"
						+ " WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVO.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVo = new MemVO();
				resultVo.setId(rs.getString(1));
				resultVo.setPw(rs.getString("pw"));
				resultVo.setNickname(rs.getString("nickname"));
				resultVo.setEmail(rs.getString("email"));
				resultVo.setPnum(rs.getInt("pnum"));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString("pw"));
			}else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo;
	}

	public void delete(MemVO memVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete mem where id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void update(MemVO memVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update pw = ?, nickname = ?, email = ?, pnum = ? where id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVO.getPw());
			pstmt.setString(2, memVO.getNickname());
			pstmt.setString(3, memVO.getEmail());
			pstmt.setInt(4, memVO.getPnum());
			pstmt.setString(5, memVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void insert(MemVO memVO) {
		try {

			// 1.DB연결
			conn = ConnectionManager.getConnnect();
			// 2.sql 구문실행
			String sql = "insert into member (id, pw, nickname, email, pnum)" + "values("
					+ memVO.getId() + ", " + memVO.getPw() + ""
							+ ", " + memVO.getNickname() + ", " + memVO.getEmail() + ", " + memVO.getPnum() + " )";
			Statement pstmt = conn.createStatement();
			int r = pstmt.executeUpdate(sql);

			// 3.결과처리
			System.out.println(r + " 건이 처리됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 4.연결해제
			ConnectionManager.close(conn);
		}
	}

	public static MemDAO getInsertance() {
		// TODO Auto-generated method stub
		return null;
	}


}
