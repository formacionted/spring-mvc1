package com.telefonica.jee.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	
	/**
	 * Ejemplo Hola Mundo, solo devuelve la hora
	 * @param model
	 * @return
	 */
	@GetMapping("/example1")
	public String example1(ModelMap model) {
		//Cargamos el modelo
		model.put("this_time",new Date().toString());
		//Devolvemos la vista
		return "index";
	}
	
	/**
	 * Ejemplo Hola Mundo, solo devuelve la hora
	 * @param model
	 * @return
	 */
	@GetMapping("/example2")
	public String example2(Model model) {
		//Cargamos el modelo
		model.addAttribute("this_time",new Date().toString());
		//Devolvemos la vista
		return "index";
	}
	
	/**
	 * Ejemplo Hola Mundo, solo devuelve la hora
	 * @param model
	 * @return
	 */
	@GetMapping("/example3")
	public ModelAndView example3() {
		/* Primer parametro especifica la vista, el segundo el nombre del modelo y el tercero el valor*/
		ModelAndView modelAndView = new ModelAndView("index", "this_time", new Date().toString());
		return modelAndView;
	}
	
	/**
	 * El siguiente ejemplo utiliza RequestMapping con el atributo GET en lugar de la anotación GetMapping --> El efecto es el mismo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/example4", method = RequestMethod.GET)
	public String example4(Model model) {
		//Cargamos el modelo
		model.addAttribute("this_time",new Date().toString());
		//Devolvemos la vista
		return "index";
	}
	
	/**
	 * Ejemplo Hola Mundo, solo devuelve la hora
	 * @param model
	 * @return
	 */
	@GetMapping("/example5/{id}")
	public ModelAndView example5(@PathVariable("id") String id) {
		log.info("Id obtenido en example5: {}", id);
		/* Primer parametro especifica la vista, el segundo el nombre del modelo y el tercero el valor*/
		ModelAndView modelAndView = new ModelAndView("index", "this_time", new Date().toString());
		return modelAndView;
	}
	
}
