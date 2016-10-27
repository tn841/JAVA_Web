package com.itwill.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HttpServletRequestDemo")
public class HttpServletRequestDemo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = response.getWriter();
		
		String method = request.getMethod();
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		StringBuffer stringB = request.getRequestURL();
		Enumeration<String> headerNames = request.getHeaderNames();
		
		/***** 소켓의 정보 *****/
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		/***** 소켓의 정보 *****/
		
		
		stringB.append("===> StringBuffer사용");		
		out.println("<h1>HttpServletRequest</h1><hr/><br/><br/>");
		out.println("<ol type='a'>");
		out.println("<li>method:"+method+"</li>");
		out.println("<li>contextPath:"+contextPath+"</li>");
		out.println("<li>requestURI:"+requestURI+"</li>");
		out.println("<li>getRequestURL:"+stringB.toString()+"</li><br>");
		while(headerNames.hasMoreElements()){
			String headerName  = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println("<li>"+headerName+":"+headerValue+"</li>");
		}
		out.println("<li>remoteAddr : "+ remoteAddr +"</li>");
		out.println("<li>remoteHost : "+ remoteHost +"</li>");
		out.println("<li>remotePort : "+ remotePort +"</li>");
		out.println("<li>remoteUser : "+ remoteUser +"</li>");
		out.println("</ol>");
	}
}
