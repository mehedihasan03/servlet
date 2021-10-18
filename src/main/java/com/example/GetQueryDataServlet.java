/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Instructor
 */
public class GetQueryDataServlet extends HttpServlet {
    
    private List<User> users = new ArrayList<>();
    
    @Override
    public void init() throws ServletException {
        users.add(new User(1, "Khalilullah"));
        users.add(new User(2, "Amina Khatun"));
        users.add(new User(3, "Bodrul Amin"));
        users.add(new User(4, "Nayeem"));
        users.add(new User(5, "Yakub"));
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = printQueryData(req);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        out.write(gson.toJson(user));
        out.flush();
        out.close();
    }
    
    public User printQueryData(HttpServletRequest req) {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            System.out.println("Your Id is : " + id);
            
            for (User user : users) {
                if (user.getId() == id) {
                    return user;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
