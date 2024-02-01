package com.example.ss_11_quan_ly_san_pham.controllers;

import com.example.ss_11_quan_ly_san_pham.models.Product;
import com.example.ss_11_quan_ly_san_pham.service.IProductService;
import com.example.ss_11_quan_ly_san_pham.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "view":
                showDetailProduct(req, resp);
                break;
            case "searchByName":
                showSearchName(req,resp);
                break;
            default:
                showFormList(req, resp);
                break;
        }
    }

    private void showSearchName(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchByName.jsp");
        String nameProduct = req.getParameter("nameProduct");
        List<Product> products = iProductService.findByName(nameProduct);
        req.setAttribute("product",products);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDetailProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.iProductService.findById(id);
        req.setAttribute("productView",product);
        dispatcher.forward(req,resp);
    }


    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = iProductService.findById(id);
        iProductService.remove(product);
        try {
            resp.sendRedirect("product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Product product = this.iProductService.findById(id);
        req.setAttribute("productUp", product);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<Product> productList = iProductService.findAll();
        req.setAttribute("list", productList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String nameProduct = req.getParameter("name_product");
        float priceProduct = Float.parseFloat(req.getParameter("price_product"));
        String description = req.getParameter("description_product");
        String company = req.getParameter("company_product");
        Product product = new Product(id, nameProduct, priceProduct, description, company);
        iProductService.update(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id_p"));
        String nameProduct = req.getParameter("name_product");
        float priceProduct = Float.parseFloat(req.getParameter("price_product"));
        String description = req.getParameter("description_product");
        String company = req.getParameter("company_product");
        Product product = new Product(id, nameProduct, priceProduct, description, company);
        iProductService.save(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
