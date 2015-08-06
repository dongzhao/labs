/*
package com.dzhao.exams.servlet;

import com.dzhao.exams.beans.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Home on 4/08/2015.
 *//*

public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<UserBean> users = (List<UserBean>)req.getSession().getAttribute("users");
        if(users==null){
            users = new ArrayList<UserBean>();
        }
        PrintWriter pw = resp.getWriter();
        UserBean user = (UserBean)req.getSession().getAttribute("user");
        users.add(user);
        req.getSession().setAttribute("users", users);
        pw.print(user);
        req.getRequestDispatcher("/viewRegister.jsp").forward(req, resp);
    }

}
*/
