// package controller;

// import java.io.IOException;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import model.Voo;
// import model.VooModel;
// import to.VooTO;

// @WebServlet("/CadastroVoo")
// public class CadastroVoo extends HttpServlet {
// 	private static final long serialVersionUID = 1L;

//     /**
//      * @see HttpServlet#HttpServlet()
//      */
//     public CadastroVoo() {
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

// 		String codigo = request.getParameter("codigo");
// 		String origem = request.getParameter("origem");
// 		String destino = request.getParameter("destino");
// 		int escalas = Integer.parseInt(request.getParameter("escalas"));
// 		String dataHora = request.getParameter("dataHora");
// 		String aeronave = request.getParameter("aeronave");
// 		String situacao = request.getParameter("situacao");

// 		VooTO vooto = new VooTO();
// 		VooModel vc  = new VooModel();
// 	vc.insereVoo(codigo, origem, destino, escalas, dataHora, aeronave, situacao);


// 		request.getSession().setAttribute("StatusVoo",vooto.getStatus());
// 	    response.sendRedirect("RegistrarVoo.jsp");

// 	}

// }
