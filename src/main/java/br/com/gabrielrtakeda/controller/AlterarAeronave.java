// package controller;

// import java.io.IOException;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import model.AeronaveModel;
// import to.AeronaveTO;

// /**
//  * Servlet implementation class AlterarAeronave
//  */
// @WebServlet("/AlterarAeronave")
// public class AlterarAeronave extends HttpServlet {
// 	private static final long serialVersionUID = 1L;

//     /**
//      * @see HttpServlet#HttpServlet()
//      */
//     public AlterarAeronave() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

// 	/**
// 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
// 	 */
// 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		// TODO Auto-generated method stub
// 		doPost(request,response);
// 	}

// 	/**
// 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
// 	 */
// 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		// TODO Auto-generated method stub
// 		String codigo = request.getParameter("cod");
// 		String nome = request.getParameter("nome");
// 		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
// 		String ids = request.getParameter("id");

// 		AeronaveTO aeroto = new AeronaveTO();
// 		AeronaveModel cae  = new AeronaveModel();
// 		cae.updAeronave(ids, nome, codigo, quantidade);
// 		//int perfil = (int)request.getSession().getAttribute("PerfilAcesso");
// 		//aeroto.setPerfil(perfil);
// 		//request.getSession().setAttribute("Status",aeroto.getStatus());
// 	    response.sendRedirect("RegistrarAeronave.jsp");
// 	}

// }
