package com.control;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dispatcher_Servlet")
public class Dispatcher_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Default_Handler> map = new HashMap<>();

    public Dispatcher_Servlet() { super(); }
    
    public void init(ServletConfig config) throws ServletException {
    	String iparam = config.getInitParameter("prop");
    	Properties prop = new Properties(); 
    	try(FileReader fr = new FileReader(iparam)) {
    		prop.load(fr);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	Iterator<?> key = prop.keySet().iterator();
    	while(key.hasNext()) {
    		String cmd = (String)key.next();
    		String value = (String)prop.getProperty(cmd);
    		try {
    			Class<?> hclass = Class.forName(value);
    			Default_Handler hinst = (Default_Handler)hclass.newInstance();
    			map.put(cmd, hinst);
    		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			System.out.println(e);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Dispatcher_Servlet action");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String str = uri.substring(path.length() + 1);
		System.out.println(str);
		Default_Handler mh = map.get(str);
		String view = null;
		if(mh == null) {
			view = "/index.jsp";
		}
		try {
			view = mh.action(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(view != null) {
			RequestDispatcher dsp = request.getRequestDispatcher(view);
			dsp.forward(request, response);
		}
	}
}
