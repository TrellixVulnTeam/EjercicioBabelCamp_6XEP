package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	AlumnosDao alumnosDao;
	
	public AlumnosServiceImpl(@Autowired AlumnosDao alumnosDao) {
		super();
		this.alumnosDao = alumnosDao;
	}

	@Override
	public void altaAlumno(Alumno alumno) {
		alumnosDao.save(alumno);
	}

	@Override
	public Alumno buscarAlumno(int idAlumno) {
		return alumnosDao.getById(idAlumno);
	}

	@Override
	public boolean eliminarAlumno(int idAlumno) {
		alumnosDao.deleteById(idAlumno);
		return true;
	}

	@Override
	public boolean actualizarAlumno(int idAlumno, String curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Alumno> todosAlumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<String> cursos() {
		return alumnosDao.findAll().stream()
			.map(a->a.getCurso())
			.distinct()
			.collect(Collectors.toList());
	}

}
