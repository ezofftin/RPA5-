package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/list.do")
public class UserListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		ArrayList<UserDTO> list = dao.userList();
		
		// 리스트 출력하기
		System.out.println(list);
		
		// 응답로직(프리젠테이션 로직 - View)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>                                                                                          ");
		out.print("<html>                                                                                                        ");
		out.print("<head>                                                                                                        ");
		out.print("<meta charset='UTF-8'>                                                                                        ");
		out.print("<title>Insert title here</title>                                                                              ");
		out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>        ");
		out.print("</head>                                                                                                       ");
		out.print("<body>                                                                                                        ");
		out.print("	<div class='container mt-5'>                                                                                 ");
		out.print("		<h2>회원 리스트</h2>                                                                                     ");
		out.print("		<table class='table'>                                                                                    ");
		out.print("			<thead class='table-dark'>                                                                           ");
		out.print("				<tr>                                                                                             ");
		out.print("					<th>번호</th>                                                                                ");
		out.print("					<th>아이디</th>                                                                              ");
		out.print("					<th>비밀번호</th>                                                                            ");
		out.print("					<th>이름</th>                                                                                ");
		out.print("					<th>나이</th>                                                                                ");
		out.print("					<th>이메일</th>                                                                              ");
		out.print("					<th>전화번호</th>                                                                            ");
		out.print("					<th>삭제</th>                                                                            ");
		out.print("				</tr>                                                                                            ");
		out.print("			</thead>                                                                                             ");
		out.print("			<tbody>                                                                                              ");
		out.print("			                                                                                                     ");
		
		for( UserDTO dto : list) {
			out.print("				<tr>                                                                                             ");
			out.print("					<td>"+dto.getUno()+"</td>                                                                                    ");
			out.print("					<td><a href='/day03/userInfo.do?uno="+dto.getUno()+"'>"+dto.getId()+"</a></td>");
			out.print("					<td>"+dto.getPw()+"</td>                                                                                    ");
			out.print("					<td>"+dto.getName()+"</td>                                                                                    ");
			out.print("					<td>"+dto.getAge()+"</td>                                                                                    ");
			out.print("					<td>"+dto.getEmail()+"</td>                                                                                    ");
			out.print("					<td>"+dto.getTel()+"</td>                                                                                    ");
			out.print("					<td><a href='/day03/delete.do?uno="+dto.getUno()+"' class='btn btn-danger btn-sm'>삭제</a></td>                                                                                    ");
			out.print("				</tr>                                                                                            ");
		}
		out.print("				<tr>                                                                                             ");
		out.print("					<td colspan='8' class='text-center'><a href='user.jsp' class='btn btn-primary'>회원가입</a></td>                                                                                             ");
		out.print("				</tr>                                                                                             ");
		out.print("			</tbody>                                                                                             ");
		out.print("		</table>                                                                                                 ");
		out.print("	</div>	                                                                                                     ");
		out.print("</body>                                                                                                       ");
		out.print("</html>                                                                                                       ");
		                                                                                                                         
   }

}
