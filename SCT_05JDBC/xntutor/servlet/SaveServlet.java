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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        // 请求解决乱码
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        // System.out.println("name=>"+name);
        Employee e = new Employee();
        e.setName(name);
        e.setPassword(password);
        e.setEmail(email);
        e.setCountry(country);

        int status = EmployeeDao.save(e);
        if (status > 0) {
            out.print("<p>新增记录成功!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.println("抱歉，新增记录失败!");
        }

        out.close();
    }

}