package com.telefonica.jee.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EmployeeController {

	/**
	 * Ejemplo Hola Mundo, solo devuelve la hora
	 * @param model
	 * @return
	 */
	@GetMapping("/employee")
	public String example1(ModelMap model) {
		//Cargamos el modelo
		model.put("this_time",new Date().toString());
		//Devolvemos la vista
		return "index";
	}
	
}
