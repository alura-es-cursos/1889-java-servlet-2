package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas {
	
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Listando empresas");
		
		DB baseDeDatos = new DB();
		List<Empresa> listaEmpresas = baseDeDatos.getEmpresas();
		
		request.setAttribute("empresas", listaEmpresas);
		
		return "forward:listaEmpresas.jsp";
		
	}
	
}
