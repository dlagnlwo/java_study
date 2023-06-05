package test.controller;

import static test.util.TestIO.p;
import static test.util.TestIO.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import TestDTO.Board;

public class TestController {
	//멤버변수
	private Connection conn;
	private Scanner sc;
	
	//멤버상수
	final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String MYSQL_URL = "jdbc:mysql://localhost/java";
	final String USER = "root";
	final String PASS = "mariadb";
	//생성자
	public TestController() {
		sc = new Scanner(System.in);
		getConn();
	}
	//메소드
	//연결
	public void getConn() {
		try {
			Class.forName(MYSQL_DRIVER);
			conn = DriverManager.getConnection(MYSQL_URL, USER, PASS);
			
		}catch (Exception e) {
			
		}
	}
	
	//목록
	public void list() {
		pl("[게시물 목록]");
		pl("-------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		pl("-------------------------------------------------------");
		select();
		
		pl("-------------------------------------------------------");
		pl("");
		pl("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		p("메뉴 선택: ");
		String choice = sc.nextLine();
		switch(choice) {
		case "1" :
			create();
			list();
			break;
		case "2" :
			read();
			list();
			break;
		case "3" :
			clear();
			break;
		case "4" :
			exit();
			break;
		default :
			pl("잘못누르셨습니다. 목록으로 돌아갑니다.");
			list();
		}
	}
	
	public void create() {
		Board board = new Board();
		pl("");
		pl("[새 게시물 입력]");
		p("제목: ");
		board.setBtitle(sc.nextLine());
		p("내용: ");
		board.setBcontent(sc.nextLine());
		p("작성자: ");
		board.setBwriter(sc.nextLine());
		pl("-------------------------------------------------------");
		pl("보조 메뉴: 1.OK | 2.Cancel");
		p("메뉴 선택: ");
		String choice = sc.nextLine();
		pl("");
		if(choice.equals("1")) {
			try {
				PreparedStatement pstmt = null;
				String insertSql = 	"""
									insert into boards
									(btitle, bcontent, bwriter, bdate)
									values (?, ?, ?, now());
									""";
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				int rows = pstmt.executeUpdate();
				pl("추가된 행 수 : " + rows);
				
				pstmt.close();
				
			}catch (SQLException se) {
				
			}catch (Exception e) {
				
			}
			
			
			pl("-------------------------------------------------------");
		}else if(choice.equals("2")) {
			pl("취소를 누르셨습니다. 목록으로 돌아갑니다.");
			list();
		}else {
			pl("잘못 누르셨습니다. 목록으로 돌아갑니다.");
			list();
		}
		
		
	}
	public void read() {
		Board board = new Board();
		pl("");
		pl("[게시물 읽기]");
		p("bno: ");
		int bno = Integer.parseInt(sc.nextLine());
		board.setBno(bno);
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = 	"""
								select bno, btitle, bcontent, bwriter, bdate
								from boards
								where bno = ?
								""";
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				
				pl("###########");
				pl("번호: " + board.getBno());
				pl("제목: " + board.getBtitle());
				pl("내용: " + board.getBcontent());
				pl("작성자: " + board.getBwriter());
				pl("날짜: " + board.getBdate());
				pl("###########");
			}
			pl("-------------------------------------------------------");
			pl("보조 메뉴: 1.Update | 2.Delete | 3.List");
			p("메뉴 선택: ");
			String choice = sc.nextLine();
			if(choice.equals("1")) {
				update(board);
			}else if(choice.equals("2")) {
				delete(board);
			}else if(choice.equals("3")) {
				pl("리스트를 선택하셨습니다. 목록으로 돌아갑니다.");
				list();
			}
			
			rs.close();
			pstmt.close();
		}catch (SQLException se) {
			
		}catch (Exception e) {
			
		}
		list();
	}
	public void clear() {
		pl("");
		pl("[게시물 전체 삭제]");
		pl("-------------------------------------------------------");
		pl("보조 메뉴: 1.OK | 2.Cancel");
		p("메뉴 선택: ");
		String choice = sc.nextLine();
		pl("");
		p("정말로 전체 데이터를 삭제하시겠습니까? (y 또는 n): ");
		String yesOrNo = sc.nextLine();
		if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
			try {
				PreparedStatement pstmt = null;
				String dropSql =	"""
									TRUNCATE TABLE boards;
									""";
				pstmt = conn.prepareStatement(dropSql);
				pstmt.executeUpdate();
			}catch (SQLException se) {
				
			}catch (Exception e) {
				
			}
		}else if(yesOrNo.equals("n") || yesOrNo.equals("N")) {
			pl("삭제를 취소하셨습니다. 목록으로 돌아갑니다.");
			list();
		}else {
			pl("잘못 누르셨습니다. 목록으로 돌아갑니다.");
			list();
		}
	}
	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException se) {
				
			}
		}
		pl("** 게시판 종료 **");
		System.exit(0);
	}
	
	
	public void select() {
		Board board = new Board();
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = 	"""
								select bno, btitle, bcontent, bwriter, bdate
								from boards
								order by bno desc; 
								""";
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				
				System.out.printf("%-6s%-12s%-16s%-40s\n",
									board.getBno(),
									board.getBwriter(),
									board.getBdate(),
									board.getBtitle());	
			}
			rs.close();
			pstmt.close();
		}catch (SQLException se) {
			
		}catch (Exception e) {
			
		}
	}
	public void update(Board board) {
		pl("");
		pl("[수정 내용 입력]");
		p("제목: ");
		board.setBtitle(sc.nextLine());
		p("내용: ");
		board.setBcontent(sc.nextLine());
		p("작성자: ");
		board.setBwriter(sc.nextLine());
		pl("-------------------------------------------------------");
		pl("보조 메뉴: 1.Ok | 2.Cancel");
		p("메뉴 선택: ");
		String choice = sc.nextLine();
		if(choice.equals("1")) {
			try {
				PreparedStatement pstmt = null;
				String updateSql = 	"""
									update boards
									set btitle = ?, bcontent = ?, bwriter = ?
									where bno = ?;
									""";
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				int rows = pstmt.executeUpdate();
				pl("수정된 행 수 : " + rows);
				
				pstmt.close();
			}catch (SQLException se) {
				
			}catch (Exception e) {
				
			}
		}else if(choice.equals("2")) {
			pl("취소를 선택하셨습니다. 목록으로 돌아갑니다.");
			list();
		}
	}
	public void delete(Board board) {
		p("정말로 삭제하시겠습니까? (y 또는 n): ");
		String choice = sc.nextLine();
		if(choice.equals("y") || choice.equals("Y")) {
			try {
				PreparedStatement pstmt = null;
				
				String deleteSql = 	"""
									delete from boards
									where bno = ?;
									""";
				pstmt = conn.prepareStatement(deleteSql);
				pstmt.setInt(1, board.getBno());
				int rows = pstmt.executeUpdate();
				pl("삭제된 행 수 : " + rows);
				
				pstmt.close();
			}catch (SQLException se) {
				
			}catch (Exception e) {
				
			}
		}else if(choice.equals("n") || choice.equals("N")) {
			pl("삭제를 취소했습니다. 목록으로 돌아갑니다.");
			list();
		}else {
			pl("잘못누르셨습니다. 목록으로 돌아갑니다.");
			list();
		}
	}
}
