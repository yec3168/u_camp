<%@ page contentType="text/html; charset=UTF-8"%>


<%=
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
%>

{" <% = id %>"" : "<%= pwd %>"}

// 오류발생.