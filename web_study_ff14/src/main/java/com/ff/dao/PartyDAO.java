package com.ff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ff.dto.PlayerVO;

import util.DBManager;

public class PartyDAO {

	private PartyDAO() {
		super();
	}
	
	private static PartyDAO instance=new PartyDAO();
	
	public static void setInstance(PartyDAO instance) {
		PartyDAO.instance=instance;
	}
	
	public static PartyDAO getInstance() {
		return instance;
	}
	
	public int userCheck(String id, String server, String pwd) {
		int result=1;
		
		if(id.equals("월숙이") && server.equals("3") && pwd.equals("1104")) {
			result=2;
		}
		
		return result;
	}
	
	public ArrayList<PlayerVO> selectAllPlayer() {
		String sql="select P.code, P.id, P.server, J.name, P.unionparty, P.pwd from party P inner join jobnum J on P.job=J.job order by TO_NUMBER(P.job)";
		ArrayList<PlayerVO> partyList=new ArrayList<PlayerVO>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				PlayerVO pvo=new PlayerVO();
				pvo.setCode(rs.getInt("code"));
				pvo.setId(rs.getString("id"));
				pvo.setServer(rs.getString("server"));
				pvo.setJob(rs.getString("name"));
				pvo.setUnion(rs.getString("unionparty"));
				pvo.setPwd(rs.getString("pwd"));
				
				partyList.add(pvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(rs, pstmt, conn);
		}
		
		return partyList;
	}
	
	public void insertPlayer(PlayerVO pVO) {
		String sql="insert into party values(player_seq.nextval, ?, ?, ?, ?, default, default)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pVO.getId());
			pstmt.setString(2, pVO.getServer());
			pstmt.setString(3, pVO.getJob());
			pstmt.setString(4, pVO.getUnion());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(pstmt, conn);
		}
	}
	
	public PlayerVO selectPlayerByCode(int code) {
		PlayerVO pvo=new PlayerVO();
		String sql="select * from party where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				pvo.setCode(rs.getInt("code"));
				pvo.setId(rs.getString("id"));
				pvo.setServer(rs.getString("server"));
				pvo.setJob(rs.getString("job"));
				pvo.setUnion(rs.getString("unionparty"));
				pvo.setPwd(rs.getString("pwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(rs, pstmt, conn);
		}
		
		return pvo;
	}
	
	public void deletePlayer(int code) {
		String sql="delete from party where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(pstmt, conn);
		}
	}
	
	public void updatePlayer(PlayerVO pVO) {
		String sql="update party set id=?, server=?, job=?, unionparty=? where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pVO.getId());
			pstmt.setString(2, pVO.getServer());
			pstmt.setString(3, pVO.getJob());
			pstmt.setString(4, pVO.getUnion());
			pstmt.setInt(5, pVO.getCode());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			util.DBManager.close(pstmt, conn);
		}
	}
}
