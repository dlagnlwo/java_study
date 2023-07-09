<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String gen = request.getParameter("gen");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String[] major = request.getParameterValues("major");
	String agree = request.getParameter("agree");
	String memo = request.getParameter("memo");
	
	memo = memo.replace("\n", "<br />");
	
	String str = "";
	if(major != null) {
		for(String temp : major) {
			str = str + temp + " ";
		}
	}
	
	if(agree != null && agree.equals("on")) {
		agree = agree.replace("on", "동의");
	}
	
	if(gen != null && gen.equals("on")){
		gen = gen.replace("on", "남자");
	}
	
	session.setAttribute("name", name);
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("gen", gen);
	session.setAttribute("tel1", tel1);
	session.setAttribute("tel2", tel2);
	session.setAttribute("tel3", tel3);
	session.setAttribute("major", major);
	session.setAttribute("agree", agree);
	session.setAttribute("memo", memo);
	
	response.sendRedirect("memberRegisterResult");
%>
</body>
</html>