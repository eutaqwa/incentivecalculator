package com.siemo.insentif.calculator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.http.client.HttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;

import com.siemo.insentif.calculator.dao.IncentiveDataAccessObject;
import com.siemo.insentif.calculator.model.IncentiveCalculatorModel;






/**
 * Servlet implementation class IncentiveCalculatorController
 */
@WebServlet("/IncentiveCalculatorController")
public class IncentiveCalculatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncentiveCalculatorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String gol = request.getParameter("gol");
		//response.getWriter().append(gol+1);
		//HttpClient httpclient = HttpClientBuilder.create().build();
		PrintWriter pw = response.getWriter();
		String grade = request.getParameter("grade");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		IncentiveCalculatorModel model = new IncentiveCalculatorModel();
		model.setGrade(grade);
		model.setSalary(salary);
		
		IncentiveDataAccessObject dao = new IncentiveDataAccessObject();
		float incentivePercentage = dao.getIncentivePercentage(grade);
		
		float incentiveResult = (float)(salary * incentivePercentage);
		int incentive = Math.round(incentiveResult);
		pw.println("The Incentive for Your Achievement (in IDR) is = "+"Rp. "+incentive);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
