/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danielchow
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession HttpSession = request.getSession();
        
        
        //The action when user click the logout button
        if (action != null || action == "logout") {
            HttpSession.invalidate();
            request.setAttribute("LogoutMessage", "You have successfully logged out");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String name = request.getParameter("username");
        HttpSession session = request.getSession();

        //The action when user click the Register button
        if (action != null && action.equals("register")) {
            if (name == null || name.equals("")) {
                request.setAttribute("errorMessage", "Invalid username");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                        .forward(request, response);
            } else {
                session.setAttribute("username", name);
            }
        }

        
        String item = request.getParameter("item");
        String selectedItem = request.getParameter("selectedItem");
        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");
        
        
        //The action when user click the add button
        if (action != null && action.equals("add")) {
            if (itemList == null) {
                itemList = new ArrayList<String>();
            }
            if (item == null || item.equals("")) {
                request.setAttribute("noitemMessage", "*Please enter an item name*");
            } else{
                itemList.add(item);
                session.setAttribute("itemList", itemList);
            }
        }
        
//        
//        if (action != null && action.equals("next")){
//            
//        }
//        
//        
//         if (action != null && action.equals("last")){
//            
//        }
        
        
        //The action when user click the delete button
        if (action != null && action.equals("delete")) {
            if (selectedItem == null || selectedItem.equals("")) {
                request.setAttribute("noitemMessage", "*Please choose an item to delete*");
            } else{
                itemList.remove(selectedItem);
                session.setAttribute("itemList", itemList);
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
    }

}
