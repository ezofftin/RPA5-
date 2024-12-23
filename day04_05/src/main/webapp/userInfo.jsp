<%@page import="model.UserDAO"%>
<%@page import="model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 조회할 회원의 uno 파라미터를 수집
	int uno = Integer.parseInt(request.getParameter("uno"));
	
	UserDAO dao = new UserDAO();
	// 조회할 uno를 dao에 전달해서 해당 uno의 UserDTO를 가져오기
	UserDTO dto = dao.userInfo(uno);
%>    
<!DOCTYPE html>                                                                                       
<html>                                                                                                
<head>                                                                                                
<meta charset='UTF-8'>                                                                                    
<title>Insert title here</title>                                                                          
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>    
</head>                                                                                                   
<body>                                                                                                    
<div class='container'>                                                                                   
	<form action='userUpdate.jsp' method='get' class='mx-auto w-75 border mt-5 p-5 rounded shadow'>     
		<h3 class='text-center'><%=dto.getName() %>님 회원정보</h3>                                                             
		<input type='hidden' name='uno' value='<%=dto.getUno()%>'/>                                        
		<table class='mt-3 w-100'>	                                                 
			<tbody>                                                                                       
				<tr>                                                                                      
					<td>회원번호</td>                                                                     
					<td><input class='mb-2 ms-2 form-control' type='text' value='<%=dto.getUno()%>' disabled/></td>                                                             
				</tr>                                                                                     
				<tr>                                                                                      
					<td>아이디 </td>             
					<td><input class='mb-2 ms-2 form-control' type='text' value='<%=dto.getId()%>' disabled/></td>     
				</tr>                            
				<tr>                             
					<td>이름</td>                
					<td><input class='mb-2 ms-2 form-control' type='text' value='<%=dto.getName()%>' disabled/></td>   
				</tr>                            
				<tr>                                                                                      
					<td>이메일 </td>                                                                      
					<td><input class='mb-2 ms-2 form-control' type='text' name='email' value='<%=dto.getEmail()%>'/></td>    
				</tr>                                                                                    
				<tr>                                                                                     
					<td>나이 </td>                                                                       
					<td><input class='mb-2 ms-2 form-control' type='text' name='age' value='<%=dto.getAge()%>'/></td>        
				</tr>                                                                                   
				<tr>                                                                                    
					<td>전화번호 </td>                                                                  
					<td><input class='mb-2 ms-2 form-control' type='text' name='tel' value='<%=dto.getTel()%>'/></td>        
				</tr>                                                                                  
			</tbody>                                                                                   
		</table>                                                                                       
		<div class='mt-5 text-center'>                                                                 
			<input type='submit' class='btn btn-primary' value='수정하기'>                             
			<input type='reset' class='btn btn-warning' value='취소'>                                  
			<a href='userList.jsp' class='btn btn-info'>리스트</a>                                   
		</div>                                                                                         
	</form>                                                                                            
</div>	                                                                                               
</body>                                                                                                
</html>                                                                                                
