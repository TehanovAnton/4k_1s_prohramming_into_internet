/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-10-24 20:24:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/night.jsp", Long.valueOf(1666641188453L));
    _jspx_dependants.put("/afternoon.jsp", Long.valueOf(1666641188464L));
    _jspx_dependants.put("/evening.jsp", Long.valueOf(1666641188453L));
    _jspx_dependants.put("/morning.jsp", Long.valueOf(1666641188453L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!%@ page import=\"org.apache.commons.lang3.time.DateUtils\" %>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<Context allowLinking=\"true\">\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>        \r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <title>First JSP App</title>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("            TABLE {\r\n");
      out.write("                border-collapse: collapse;\r\n");
      out.write("                border: 4px solid black;\r\n");
      out.write("            }\r\n");
      out.write("            TD, TH {\r\n");
      out.write("                padding: 5px;\r\n");
      out.write("                border: 2px solid green;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <p>Today ");
      out.print( new Date() );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("        ");
 
            int h = (new Date()).getHours();
            if (h > 3 && h < 7)
                out.println("<h2>Good night</h2>");
            if (h > 6 && h < 12)
                out.println("<h2>Good morning</h2>");
            if (h > 11 && h < 17)
                out.println("<h2>Good afternoon</h2>");
            if (h > 16 && h < 24)
                out.println("<h2>Good evening</h2>");
            if (h > 23 || h < 4 )
                out.println("<h2>Good night</h2>");
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
SimpleDateFormat yy = new SimpleDateFormat("dd/MM/yyyy"); 
      out.write("\r\n");
      out.write("        ");
SimpleDateFormat u = new SimpleDateFormat("u' ('E') '"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <table>\r\n");
      out.write("            ");
 for (int i=0; i < 7; i++) { 
      out.write("\r\n");
      out.write("                ");
 Date dateNext = new Date(new Date().getTime() + 60*60*24*1000*i); 
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
 out.print(yy.format(dateNext)); 
      out.write("</td>\r\n");
      out.write("                    <td>");
 out.print(u.format(dateNext)); 
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("        ");
 if (h > 3 && h < 7) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Night</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/webapp/localLog"));
            writer.write("Night");
            writer.append("\n");
            writer.close();
        
      out.write("\n");
      out.write("        <h1>Night</h1>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "night.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
 if (h > 6 && h < 12) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Morning</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/webapp/localLog"));
            writer.write("Morning");
            writer.append("\n");
            writer.close();
        
      out.write("\n");
      out.write("        <h1>Morning</h1>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "morning.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
 if (h > 11 && h < 17) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Afternoon</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/webapp/localLog"));
            writer.append("Afternoon");
            writer.append("\n");
            writer.close();
        
      out.write("\n");
      out.write("        <h1>Afternoon</h1>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "afternoon.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
 if (h > 16 && h < 24) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Evening</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/webapp/localLog"));
            writer.write("Evening");
            writer.append("\n");
            writer.close();
        
      out.write("\n");
      out.write("        <h1>Evening</h1>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "evening.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("        <hr>\r\n");
      out.write("        \r\n");
      out.write("        <a>Afternoon servlet is here: </a>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/Afternoon", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
