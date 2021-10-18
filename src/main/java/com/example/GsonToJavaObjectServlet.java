/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Instructor
 */
public class GsonToJavaObjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            System.out.println(jb);
        } catch (Exception e) {
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User user = gson.fromJson(jb.toString(), User.class);
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.write(user.toString());
        out.flush();
        out.close();
    }

}
