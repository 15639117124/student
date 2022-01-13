package com.example.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {


    //HttpServletRequest和HttpServletResponse的实现类对象（req，resp）由tomcat服务器来创建
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("处理学生信息");
        //System.out.println(req.getRemoteAddr());
        //获取学生信息
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        //把学生信息保存在文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\workspace2\\student\\student.txt",true));
        bw.write(name+","+age+","+score);
        bw.newLine();
        bw.close();

        //响应
        PrintWriter pw = resp.getWriter();
        pw.println("save success");
        pw.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
