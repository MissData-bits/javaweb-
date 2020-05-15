package com.xntutor.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.xntutor.dao.Employee;
import com.xntutor.dao.EmployeeDao;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8"); 
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>�����Ա��</a>");  
        out.println("<h2>Ա�������б�</h2>");  

        List<Employee> list=EmployeeDao.getAllEmployees();  

        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>���</th><th>����</th><th>����</th><th>Email</th><th>����</th><th>����</th></tr>"); 
        if(list.size()>0) {
            for(Employee e:list){  
                out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td>"
                        + "<td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>�༭</a>&nbsp;|&nbsp;<a href='DeleteServlet?id="+e.getId()+"'>ɾ��</a></td></tr>");  
               } 
        }else {
            out.print("<tr><td colspan=6>��������</td></tr>");
        }

        out.print("</table>");  

        out.close();  
    }  
}