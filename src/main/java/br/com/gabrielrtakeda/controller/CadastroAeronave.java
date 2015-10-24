// package controller;

// import java.io.IOException;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import model.AeronaveModel;
// import to.AeronaveTO;

// @WebServlet("/cadastro-aeronave")
// public class CadastroAeronave extends HttpServlet {
//     private static final long serialVersionUID = 1L;

//     /**
//      * @see HttpServlet#HttpServlet()
//      */
//     public CadastroAeronave() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

//     /**
//      * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//      */
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         doPost(request,response);
//     }

//     /**
//      * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//      */
//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//         String codigo = request.getParameter("codigo");
//         String nome = request.getParameter("nome");
//         int quantidade = Integer.parseInt(request.getParameter("quantidade"));

//         AeronaveTO to = new AeronaveTO()
//             .setCodigo(codigo)
//             .setNome(nome)
//             .setQuantidadePassageiros(quantidade);

//         AeronaveAeronaveDAO dao = new AeronaveAeronaveDAO();
//         dao.insert(to);

//         AeronaveModel model  = new AeronaveModel();
//         model.insert(nome, codigo, quantidade);
//         //int perfil = (int)request.getSession().getAttribute("PerfilAcesso");
//         //aeroto.setPerfil(perfil);
//         request.getSession().setAttribute("Status", aeroto.getStatus());
//         request.setAttribute("status", 1);
//         response.sendRedirect("aeronave/cadastrar.jsp");

//     }

// }
