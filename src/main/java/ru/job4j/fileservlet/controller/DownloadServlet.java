package ru.job4j.fileservlet.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Error number 14");
        String name = req.getParameter("name");
        System.out.println("Error number 15");
        resp.setContentType("name" + name);
        System.out.println("Error number 16");
        resp.setContentType("image/png");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
        System.out.println("Error number 17");
        File file = new File("images" + File.separator + name);

        try(FileInputStream stream = new FileInputStream(file)) {
            resp.getOutputStream().write(stream.read());
        }
    }
}
