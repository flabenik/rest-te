package br.com.flavia.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.flavia.converters.NumberConverter;
import br.com.flavia.exception.UnsupportedMathOperationException;
import br.com.flavia.math.SimpleMath;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{num1}/{num2}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="num1") String num1 ,
			@PathVariable(value="num2") String num2) throws Exception {
		
		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");			
		}
		return math.sum(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@RequestMapping(value = "/subtraction/{num1}/{num2}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value="num1") String num1 ,
			@PathVariable(value="num2") String num2) throws Exception {
		
		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");			
		}
		return math.subtraction(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
		
	@RequestMapping(value = "/multiplication/{num1}/{num2}", method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value="num1") String num1 ,
			@PathVariable(value="num2") String num2) throws Exception {
		
		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");			
		}
		return math.multiplication(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
			
	@RequestMapping(value = "/division/{num1}/{num2}", method=RequestMethod.GET)
	public Double division(
			@PathVariable(value="num1") String num1 ,
			@PathVariable(value="num2") String num2) throws Exception {
		
		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");			
		}
		return math.division(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@RequestMapping(value = "/mean/{num1}/{num2}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value="num1") String num1 ,
			@PathVariable(value="num2") String num2) throws Exception {
		
		if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");			
		}
		return math.mean(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
	}
	
	@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value="number") String number) throws Exception {
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");			
		}
		return math.squareRoot(NumberConverter.convertToDouble(number)) ;
	}
	

	
	
	                                               
}
