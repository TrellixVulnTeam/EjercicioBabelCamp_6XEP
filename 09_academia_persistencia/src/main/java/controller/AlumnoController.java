package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.AlumnoService;

@CrossOrigin("*")
@Controller
public class AlumnoController {

	@Autowired
	AlumnoService service;
	
	@GetMapping(value="Buscador", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso){
		return service.buscarPorCurso(curso);
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Alumno a){
		if(service.insertar(a)) {
			return "alta";
		}else {
			return "error";
		}
		
	}
	
	@GetMapping(value="Cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> listarCursos(){
		return service.listaCursos();
	}
	
}
