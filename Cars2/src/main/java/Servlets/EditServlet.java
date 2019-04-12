package Servlets;

import DBClasses.Car;
import Queries.CarDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String brand = request.getParameter("brand");
            int user_id = Integer.parseInt(request.getParameter("user_id"));
            Car car = new Car(id, brand, user_id);
            CarDB.update(car);
            response.sendRedirect(request.getContextPath() + "/");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/404.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Car car = CarDB.selectOne(id);
            if(car!=null) {
                request.setAttribute("car", car);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
