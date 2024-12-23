<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 날짜 관련 객체 : Date, Calendar 
	// java8이후 추가된 날짜 관련객체 : LocalDate, LocalDateTime
	
	// Calendar 추상클래스(new 를 이용한 객체생성 불가)
	// 이미 구현된 객체를 가져오는 방식
	// (getInstance()를 이용해서 객체를 얻어오는 방식: 싱글톤)
	Calendar cal = Calendar.getInstance();

	int year =cal.get(Calendar.YEAR);

	// 0 ~ 11 : 0은 1월 ~ 11은 12월
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DATE);
	
	int h = cal.get(Calendar.HOUR);
	int hh = cal.get(Calendar.HOUR_OF_DAY); // 24시 표기
	int mi = cal.get(Calendar.MINUTE);
	int sec = cal.get(Calendar.SECOND);
	
	out.print("=================<br/>");
	Date now = new Date();
	out.print("now : " + now + "<br/>");
	
	// 날짜 포맷 설정 클래스 SimpleDateFormat
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy년 MM월 dd일");
	SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
	
	out.print("sdf.format : "+sdf.format(now)+"<br/>");	
	out.print("sdf2.format : "+sdf2.format(now)+"<br/>");	
	
	out.print("java8 이후에 추가된 날짜 객체 =================<br/>");
	LocalDate today = LocalDate.now();
	out.print("today : " + today + "<br/>");
	LocalDateTime curtime= LocalDateTime.now();
	out.print("curtime : " + curtime + "<br/>");
	
	// 형식지정 클래스 DateTimeFormatter
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
	String strDate1 = curtime.format(dtf);
	out.println("strDate1 : " +strDate1+ "<br/>");
	
	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd");
	String strDate2 = today.format(dtf2);
	out.println("strDate2 : " +strDate2+ "<br/>");
	// a 오전 오후 표기, 대문자 HH 24시 표기
	DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("a HH:mm:ss");
	String strDate3 = curtime.format(dtf3);
	out.println("strDate3 : " +strDate3+ "<br/>");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<%=year%>년
	<%=month+1%>월
	<%=day%>일
	<%=h%>시
	<%=hh%>시
	<%=mi%>분
	<%=sec%>초
</body>
</html>