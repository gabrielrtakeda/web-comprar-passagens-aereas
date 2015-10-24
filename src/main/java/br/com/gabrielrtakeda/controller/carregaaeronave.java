// package controller;

// import java.io.IOException;
// import java.util.ArrayList;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import model.AeronaveModel;
// import to.AeronaveTO;

// /**
//  * Servlet implementation class carregaAeronave
//  */
// @WebServlet("/carregaaeronave")
// public class carregaaeronave extends HttpServlet {
// 	private static final long serialVersionUID = 1L;

//     /**
//      * @see HttpServlet#HttpServlet()
//      */
//     public carregaaeronave() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

// 	/**
// 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
// 	 */
// 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		// TODO Auto-generated method stub
// 		//response.getWriter().append("Served at: ").append(request.getContextPath());
// 		doPost(request,response);
// 	}

// 	/**
// 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
// 	 */
// 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		//String urlUsuario = request.getRequestURI();
// 		//String monta[] = new String[3];
// 		//monta = urlUsuario.split("/");
// 		//String viewchamada = monta[2];
// 		AeronaveTO aeroto = new AeronaveTO();
// 		AeronaveModel cae  = new AeronaveModel();
// 				aeroto.aeronave = cae.getAeronave();
// 		        request.getSession().setAttribute("lstAeronave",aeroto.aeronave);
// 			    response.sendRedirect("consultarAeronave.jsp");


// 	}

// }
