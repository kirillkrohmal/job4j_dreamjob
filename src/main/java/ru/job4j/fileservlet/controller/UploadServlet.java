package ru.job4j.fileservlet.controller;



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.sendRedirect(req.getContextPath() + "/upload.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        System.out.println("Error number 1");

        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        System.out.println("Error number 2");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        System.out.println("Error number 3");
        try {
            System.out.println("Error number 4");
            List<FileItem> items = upload.parseRequest(req);
            System.out.println("Error number 5");
            File folder = new File("images");
            if (!folder.exists()) {
                System.out.println("Error number 6");
                folder.mkdir();
            }
            System.out.println("Error number 7");
            for (FileItem item : items) {
                System.out.println("Error number 8");
                if (!item.isFormField()) {
                    System.out.println("Error number 9");
                    File file = new File(folder + File.separator + item.getName());
                    System.out.println("Error number 10");
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        out.write(item.getInputStream().readAllBytes());
                    }
                    System.out.println("Error number 11");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        System.out.println("Error number 12");
        doGet(req, resp);
        System.out.println("Error number 13");
    }
}
