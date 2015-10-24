// package controller;

// import java.io.IOException;

// import javax.servlet.ServletException;
// import javax.servlet.RequestDispatcher;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import model.LoginModel;
// import to.LoginTO;

// @WebServlet("/login")
// public class LoginController extends HttpServlet {

//     private static final long serialVersionUID = 1L;

//     public LoginController() {
//         super();
//     }
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//     throws ServletException, IOException {
//         doPost(request,response);
//     }

//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//     throws ServletException, IOException {
//         RequestDispatcher rd;
//         String usuario = request.getParameter("usuario").trim();
//         String senha = request.getParameter("senha").trim();

//         validateEmpty(request, response, usuario, senha);

//         HttpSession session = request.getSession();
//         LoginModel model = new LoginModel();
//         LoginTO loginTO = model.selecionarLogin(usuario, senha);

//         if (model.authenticate(loginTO)) {
//             session.setAttribute("usuarioAutenticado", loginTO.getUsuario());
//             session.setAttribute("perfilAcesso", loginTO.getPerfil());
//             request
//                 .getRequestDispatcher("home.jsp")
//                 .forward(request, response);
//         } else {
//             request.setAttribute("errorMessage", "Usuário e/ou Senha inválido(s).");
//             request
//                 .getRequestDispatcher("index.jsp")
//                 .forward(request, response);
//         }
//     }

//     private void validateEmpty(
//         HttpServletRequest request,
//         HttpServletResponse response,
//         String usuario,
//         String senha
//     ) {
//         if (usuario.trim().equals("") || senha.trim().equals("")) {
//             try {
//                 request.setAttribute("errorMessage", "O(s) campo(s) estão em branco.");
//                 request
//                     .getRequestDispatcher("index.jsp")
//                     .forward(request, response);
//             }
//             catch (ServletException e) {
//                 e.printStackTrace();
//             }
//             catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }


