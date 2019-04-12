package Servlets;

import DBClasses.Car;
import Queries.CarDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletSelect")
public class ServletSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Car> carsList = CarDB.select();
        request.setAttribute("carsL", carsList);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/index.jsp");

        dispatcher.forward(request, response);
    }
}
