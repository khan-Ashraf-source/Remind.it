/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.ToDo;
import Model.User;
import Service.RegistrationVerify;
import Service.TodoService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ash
 */
public class ToDoController extends HttpServlet {
    private TodoService todoService;
    
    
    public void init(){
        todoService=new TodoService();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
            String action=request.getServletPath();
            try{
                switch(action){
                    case "/new":
                        showNewTodoForm(request,response);
                        break;
                    case "/insert":
                        insertNewTodo(request,response);
                        break;
                    case "/delete":
                        deleteTodo(request,response);
                        break;
                    case "/edit":
                        System.out.println("Edit called in controller");
                        showEditTodo(request,response);
                        break;
                    case "/update":
                        System.out.println("Update called in controller");
                        updateTodo(request,response);
                        break;
                    case "/list":
                        System.out.println("/list called");
                        listTodo(request,response);
                        break;
                    case "/validateRegistration":
                        System.out.println("/validateRegistration called");
                        validateRegister(request,response);
                        break;
                    default:
                        response.sendRedirect(request.getContextPath()+"/welcome");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            
    }
    
    private void listTodo(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<ToDo> todoList=new ArrayList<ToDo>();
        HttpSession session=request.getSession(false);
        User user=(User)session.getAttribute("user");
        todoList= todoService.getTodoList(user.getUid());
        if(todoList!=null){
            System.out.println("todolist is not null");
        }
        request.setAttribute("todoList", todoList);
        RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
    }
    
    private void showEditTodo(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException{
        int todoId=Integer.parseInt(request.getParameter("id"));
        ToDo existingTodo=todoService.selectTodo(todoId);
        request.setAttribute("todo", existingTodo);
        RequestDispatcher rd=request.getRequestDispatcher("addTodo.jsp");
        rd.forward(request, response);
    }
    
    
    private void showNewTodoForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher rd=request.getRequestDispatcher("addTodo.jsp");
        rd.forward(request, response);
    }
    
    private void insertNewTodo(HttpServletRequest request, HttpServletResponse response) throws ParseException,IOException{
        String title=request.getParameter("todoName");
        String desc=request.getParameter("todoDesc");
        boolean status=Boolean.valueOf(request.getParameter("status"));
        String date=request.getParameter("targetDate");
        LocalDate targetDate=LocalDate.parse(date);
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        int uid=user.getUid();
        ToDo newTodo=new ToDo(null,title,desc,status,targetDate,uid);
        todoService.insertTodo(newTodo);
        response.sendRedirect("list");
    }
    
    private void deleteTodo(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        todoService.deleteTodo(id);
        response.sendRedirect("list");
    }
    
    private void updateTodo(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
        int todoId=Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("todoName");
        String desc=request.getParameter("todoDesc");
        boolean status=Boolean.valueOf(request.getParameter("status"));
        String date=request.getParameter("targetDate");
        LocalDate targetDate=LocalDate.parse(date);
        User user=(User)request.getSession().getAttribute("user");
        int uid=user.getUid();
        ToDo todo=new ToDo(todoId,title,desc,status,targetDate,uid);
        todoService.updateTodo(todo);
        response.sendRedirect("list");
    }
    
    private void validateRegister(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
        RegistrationVerify rf=new RegistrationVerify();
        rf.verifyRegistration(code);
        response.sendRedirect("login.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ToDoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ToDoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
