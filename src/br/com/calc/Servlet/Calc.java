package br.com.calc.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String svalorA = request.getParameter("valorA");
		String svalorB = request.getParameter("valorB");
		String opcao = request.getParameter("opcao");
		
		double dvalorA = Double.parseDouble(svalorA);
		double dvalorB = Double.parseDouble(svalorB);
		double resultado = 0;
		
		if(opcao.equals("+")) {
			resultado = dvalorA + dvalorB;
		} else if(opcao.equals("-")) {
			resultado = dvalorA - dvalorB;
		} else if(opcao.equals("*")) {
			resultado = dvalorA * dvalorB;
		} else if(opcao.equals("/")) {
			resultado = dvalorA / dvalorB;
		}
		
		request.setAttribute("resultado", resultado);
		
		int contador = 1;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("contador")) {				
				contador = Integer.parseInt(cookie.getValue()) + 1;
				break;
			}
		}
		Cookie cookie = new Cookie("contador", String.valueOf(contador));
		response.addCookie(cookie);
		request.setAttribute("contador", contador);
		
		request.getRequestDispatcher("./resultado.jsp").forward(request, response);
		
	}



}
