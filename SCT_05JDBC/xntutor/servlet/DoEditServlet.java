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

@WebServlet("/DoEditServlet")
public class DoEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        // 请求解决乱码
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setPassword(password);
        e.setEmail(email);
        e.setCountry(country);

        int status = EmployeeDao.update(e);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("抱歉，更新记录失败！");
        }

        out.close();
    }

}