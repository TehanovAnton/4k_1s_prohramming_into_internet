package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Find;

public class Sss extends HttpServlet {

    BufferedWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получение параметра инициации
        String filename = req.getParameter("file");
        String docdir = getServletContext().getInitParameter("docs");

        if (filename == null) {
            Find files = new Find(docdir, "doc");
            resp.setContentType("text/html");

            StringBuilder result = new StringBuilder();
            for (String file : files.list) {
                result.append("<br>")
                      .append("<a href='/lab13/Sss?file=")
                      .append(file)
                      .append("' >")
                      .append(file)
                      .append("</a>");
            }
            resp.getWriter().println(result);
        } 
        else {
            System.out.println(filename);
            try {
                File doc = new File(docdir.concat("/").concat(filename));
                resp.setContentType("application/msword");
                resp.addHeader("Content-Disposition", "attachment; filename="+ doc.getName());
                resp.setContentLength((int) doc.length());

                System.out.println(doc.exists());
                System.out.println(doc.getAbsolutePath());
                System.out.println(doc.length());                

                FileInputStream in = new FileInputStream(doc);
                BufferedInputStream buf = new BufferedInputStream(in);
                ServletOutputStream out = resp.getOutputStream();
                
                int readBytes = 0;
                while ((readBytes = buf.read()) != -1) {
                    out.write(readBytes);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
