package org.serratec.projeto01.controllers;

import org.serratec.projeto01.models.CalculadoraModel;
import org.serratec.projeto01.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@Autowired
	CalculadoraService service;
	
	@GetMapping("/somar/{operando1}/{operando2}")
	public CalculadoraModel somar(@PathVariable int operando1, @PathVariable int operando2) {
				
		return service.somar(operando1, operando2);
	}
	
	@GetMapping("/subtrair/{operando1}/{operando2}")
	public CalculadoraModel subtrair(@PathVariable int operando1, @PathVariable int operando2) {
				
		return service.subtrair(operando1, operando2);
	}
	
	@GetMapping("/multiplicar/{operando1}/{operando2}")
	public CalculadoraModel multiplicar(@PathVariable int operando1, @PathVariable int operando2) {
				
		return service.multiplicar(operando1, operando2);
	}
	
	@GetMapping("/dividir/{operando1}/{operando2}")
	public CalculadoraModel dividir(@PathVariable int operando1, @PathVariable int operando2) {
				
		return service.dividir(operando1, operando2);
	}
	
}
