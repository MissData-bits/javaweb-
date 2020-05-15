package com.xntutor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xntutor.dao.Employee;
import com.xntutor.dao.EmployeeDao;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8"); 
        PrintWriter out=response.getWriter();  
        out.println("<h1>更新员工信息</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  

        Employee e=EmployeeDao.getEmployeeById(id);  

        out.print("<form action='DoEditServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>名字:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>密码:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>国家:</td><td>");
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option value='中国'>中国</option>");  
        out.print("<option value='美国'>美国</option>");  
        out.print("<option value='日本'>日本</option>");
        out.print("<option value='英国'>英国</option>");
        out.print("<option value='其他'>其他</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value=\"修改保存\"/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  

        out.close();  
    }
}