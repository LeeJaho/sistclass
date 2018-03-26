package com.newlecture.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.Controller;
import com.newlecture.controller.note.ListController;


public class DispatcherController extends HttpServlet {
	
	private Map<String, Controller> urlMap;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		String pathUrl = config.getInitParameter("path");
		
		if(pathUrl == null)
			pathUrl = "/WEB-INF/mapper.properties";
	
		String pathSystem = config.getServletContext().getRealPath(pathUrl);
		
		
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(pathSystem);
			Properties properties = new Properties();
			properties.load(fis);
			
			urlMap = new HashMap<>();
			//urlMap.put("/index.htm",new IndexController());
			//urlMap.put("/notice/list.htm",new ListController());
			for(Object key : properties.keySet()) {
				   
				   try {
				      String url = String.valueOf(key);
				      String className = String.valueOf(properties.get(key));
				      Controller controller = (Controller)Class.forName(className).newInstance();
				      urlMap.put(url, controller);
				      
				   } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				      // TODO Auto-generated catch blsock
				      e.printStackTrace();
				   }   
				}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
		PrintWriter out = response.getWriter();
		String requestUrl = request.getRequestURI();
		String contextPath = request.getContextPath();
		requestUrl = requestUrl.replaceAll(contextPath, "");
		String viewUrl = null;
	    //out.printf("getRequestURL : %s<br />\n", request.getRequestURL());
	    //out.printf("getRequestURI : %s<br />\n", request.getRequestURI());
	    //out.printf("getContextPath : %s<br />\n", request.getContextPath());
	    //out.printf("getMethod : %s<br />\n", request.getMethod());
	    //out.printf("getQueryString : %s<br />\n", request.getQueryString());
		
		
		
		
		//Map<String, Controller> urlMap = (Map)properties;

		
		Controller controller = urlMap.get(requestUrl);
		if(controller != null) {
			viewUrl = controller.service(request, response);
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher(viewUrl);
		    //dispatch를 통해서 forward한다	. 
		    dispatcher.forward(request, response);
		}
		else
			response.sendRedirect("/error404");
			    
		
		
	}

}
