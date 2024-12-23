<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Member"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Member> map = new HashMap<>();
	map.put("member1", new Member("이길동", "30"));
	map.put("member2", new Member("최길동", "20"));
	
	// 바인딩
	application.setAttribute("map", map);
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Map<String, Member> memberMap= (Map<String, Member>)application.getAttribute("map");
	
	// keySet() : Map의 키값만 가져오는 메소드, 리턴타입은 Set<?>
	Set<String> keys = memberMap.keySet();
	// keys = member1, member2
	for(String key: keys){
		Member member = memberMap.get(key);
		out.print(String.format("이름 : %s, 나이: %s<br/>", member.getUserName(), member.getAge()));
	}
	%>
</body>
</html>