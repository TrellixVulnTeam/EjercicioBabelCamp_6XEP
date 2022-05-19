package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {

	@Autowired
	FormacionService service;
	
	@GetMapping(value="BuscadorAlumnos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscarAlumnos(@RequestParam("curso") String curso){
		return service.alumnosDelCurso(curso);
	}
	
	@GetMapping(value="BuscadorCursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> buscarCursos(@RequestParam("usuario") String usuario){
		return service.cursosDelAlumno(usuario);
	}
	
	@GetMapping(value="Cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> listarCursos(){
		return service.findAllCursos();
	}
	
	@GetMapping(value="Alumnos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> listarAlumnos(){
		return service.findAllAlumnos();
	}
	
	@PostMapping(value="Login")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password){
		Alumno a = service.validarUsuario(usuario, password);
		
		if(a==null) {
			return "error";
		}else {
			return "menu";
		}
	}
	
	@PostMapping(value="AltaAlumno")
	public String altaAlumno(@ModelAttribute Alumno a){
		boolean alta = service.altaAlumno(a);
		
		if(alta) {
			return "menu";
		}else {
			return "errorAltaAlumno";
		}
	}
	
	@PostMapping(value="AltaCurso")
	public String altaCurso(@ModelAttribute Curso c){
		boolean alta = service.altaCurso(c);
		
		if(alta) {
			return "menu";
		}else {
			return "errorAltaCurso";
		}
	}
	
	@GetMapping(value="ConsultarMatriculas", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> consultarMatriculas(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
			@RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin){
		return service.consultarMatriculas(inicio,fin);
	}
	
	@GetMapping(value="CursosNoMatriculado", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursosNoMatriculado(@RequestParam("usuario") String usuario){
		return service.findCursosNoMatriculados(usuario);
	}
	
}
