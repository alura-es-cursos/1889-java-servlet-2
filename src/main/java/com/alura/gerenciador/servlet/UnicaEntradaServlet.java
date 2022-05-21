package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.accion.Accion;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAccion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		
		Boolean esUnUsuarioNoLogado = (sesion.getAttribute("loginUsuario")==null);
		Boolean esUnaAccionProtegida = !(paramAccion.equals("Login") || paramAccion.equals("LoginForm"));
		
		if(esUnUsuarioNoLogado && esUnaAccionProtegida) {
			response.sendRedirect("entrada?accion=LoginForm");
			return;
		}
		
		String nombreDeClase = "com.alura.gerenciador.accion."+paramAccion;
		String nombre;
		
		try {
			Class clase = Class.forName(nombreDeClase);
			Accion accion = (Accion)clase.newInstance();
			nombre = accion.ejecutar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		
		String[] tipoYDireccion = nombre.split(":");
		
		if(tipoYDireccion[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoYDireccion[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoYDireccion[1]);
		}
		
		
		/*if(paramAccion.equals("ListaEmpresas")) {
			ListaEmpresas accion = new ListaEmpresas();
			nombre = accion.ejecutar(request, response);
		}else if(paramAccion.equals("MostrarEmpresa")) {
			MostrarEmpresa accion = new MostrarEmpresa();
			nombre = accion.ejecutar(request, response);
		}else if(paramAccion.equals("EliminarEmpresa")) {
			EliminarEmpresa accion = new EliminarEmpresa();
			nombre = accion.ejecutar(request, response);
		}else if(paramAccion.equals("ModificarEmpresa")) {
			ModificarEmpresa accion = new ModificarEmpresa();
			nombre = accion.ejecutar(request, response);
		}else if(paramAccion.equals("NuevaEmpresa")) {
			NuevaEmpresa accion = new NuevaEmpresa();
			nombre = accion.ejecutar(request, response);
		}else if(paramAccion.equals("NuevaEmpresaForm")) {
			NuevaEmpresaForm accion = new NuevaEmpresaForm();
			nombre = accion.ejecutar(request, response);
		}*/
	}

}
