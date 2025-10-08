package com.alvarez.formulario.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.time.LocalDate;

public class GeneradorClaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaStr = request.getParameter("fecha");

        LocalDate fecha = LocalDate.parse(fechaStr);
        int anio = fecha.getYear();
        int mes = fecha.getMonthValue();
        int dia = fecha.getDayOfMonth();

        String clave = nombre.substring(0, 2) +
                       apellido.charAt(0) +
                       String.format("%02d", anio % 100) +
                       String.format("%02d", mes) +
                       String.format("%02d", dia);

        response.setContentType("text/html");
        response.getWriter().println(
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "    <meta charset='UTF-8'>" +
            "    <title>CLAVE GENERADA</title>" +
            "    <style>" +
            "        body { " +
            "            font-family: 'Times New Roman', serif;" +
            "            background-color: #3b5998;" +
            "            display: flex;" +
            "            justify-content: center;" +
            "            align-items: center;" +
            "            height: 100vh;" +
            "            margin: 0;" +
            "            color: #2c3e50;" +
            "            text-transform: uppercase;" +
            "        }" +
            "        .resultado {" +
            "            background-color: #ffffff;" +
            "            padding: 30px 40px;" +
            "            border-radius: 12px;" +
            "            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);" +
            "            text-align: center;" +
            "            width: 400px;" +
            "        }" +
            "        .clave { " +
            "            font-size: 24px; " +
            "            font-weight: bold; " +
            "            color: #1e2e4f;" +
            "            text-transform: none;" + // ← Esto mantiene la clave como es
            "        }" +
            "        .volver {" +
            "            margin-top: 20px;" +
            "            display: inline-block;" +
            "            padding: 10px 20px;" +
            "            background-color: #2a4270;" +
            "            color: white;" +
            "            text-decoration: none;" +
            "            border-radius: 8px;" +
            "        }" +
            "        .volver:hover {" +
            "            background-color: #1e2e4f;" +
            "        }" +
            "    </style>" +
            "</head>" +
            "<body>" +
            "    <div class='resultado'>" +
            "        <h2>CLAVE GENERADA CORRECTAMENTE</h2>" +
            "        <p class='clave'>" + clave + "</p>" +
            "        <a class='volver' href='/index.html'>VOLVER</a>" +
            "    </div>" +
            "</body>" +
            "</html>"
        );
    }
}