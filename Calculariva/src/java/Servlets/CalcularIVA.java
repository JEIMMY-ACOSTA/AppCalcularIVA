/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java 
 */
package Servlets;


import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */

@WebServlet("/CalcularIVA")
public class CalcularIVA extends HttpServlet {

    float Iva;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Iva = 19;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Obtener el nombre del producto y el precio sin IVA
            String producto = request.getParameter("producto");
             float PrecioSinIva = Float.parseFloat(request.getParameter("preciosiniva"));
             
             //Calculando IVA y TOTAL del producto
            float ValorIva = PrecioSinIva * Iva / 100;
            float ValorTotal = PrecioSinIva + ValorIva;

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CALCULO DEL IVA</title>");
            
            
            // link Bootstrap para styles - CSS
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
            
            // Bootstrap JS
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</head>");
            out.println("<body class='bg-light d-flex align-items-center justify-content-center' style='height: 100vh;'>");

            // Contenedor principal centrado
            out.println("<div class='container text-center'>");

            // Título principal
            out.println("<h1 class='text-danger mb-5'>CÁLCULO DEL IVA</h1>");

            // Información del cálculo de Producto e IVA
            out.println("<div class='card border-primary mb-2 border-3 rounded bg-white' style='max-width: 600rem;'>");
            out.println("<div class='card-body'>");
            out.println("<h4 class='card-title text-darker'>Producto: " + producto + "</h4>");
            out.println("<h5 class='card-title text-success'>Precio Base: $" + PrecioSinIva + "</h5>");
            out.println("<h5 class='card-title text-danger'>Valor del IVA (19%): $" + ValorIva + "</h5>");
            out.println("<h5 class='card-title text-dark'>Precio Total: $" + ValorTotal + "</h5>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>"); 
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "cálculo del IVA";
    }
}
