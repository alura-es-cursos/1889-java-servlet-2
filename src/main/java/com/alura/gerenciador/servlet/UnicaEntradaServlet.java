package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.accion.EliminarEmpresa;
import com.alura.gerenciador.accion.ListaEmpresas;
import com.alura.gerenciador.accion.ModificarEmpresa;
import com.alura.gerenciador.accion.MostrarEmpresa;
import com.alura.gerenciador.accion.NuevaEmpresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAccion = request.getParameter("accion");
		
		if(paramAccion.equals("ListaEmpresas")) {
			ListaEmpresas accion = new ListaEmpresas();
			accion.ejecutar(request, response);
		}else if(paramAccion.equals("MostrarEmpresa")) {
			MostrarEmpresa accion = new MostrarEmpresa();
			accion.ejecutar(request, response);
		}else if(paramAccion.equals("EliminarEmpresa")) {
			EliminarEmpresa accion = new EliminarEmpresa();
			accion.ejecutar(request, response);
		}else if(paramAccion.equals("ModificarEmpresa")) {
			ModificarEmpresa accion = new ModificarEmpresa();
			accion.ejecutar(request, response);
		}else if(paramAccion.equals("NuevaEmpresa")) {
			NuevaEmpresa accion = new NuevaEmpresa();
			accion.ejecutar(request, response);
		}
	}

}
