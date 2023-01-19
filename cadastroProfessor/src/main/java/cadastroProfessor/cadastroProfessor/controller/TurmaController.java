package cadastroProfessor.cadastroProfessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cadastroProfessor.cadastroProfessor.model.Turma;
import cadastroProfessor.cadastroProfessor.repository.ProfessorRepository;
import cadastroProfessor.cadastroProfessor.repository.TurmaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TurmaController {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@PutMapping("/cadastrarTurma/{codigo}")
	public void cadastrarTurma (@RequestBody Turma turma,  @PathVariable long codigo) {
		turma.setProfessor(professorRepository.findById(codigo));
		
		turmaRepository.save(turma);
		
	}
	
	@GetMapping("/listarTurma")
	public List<Turma> listarTurma() {
		List<Turma> turma =   (List<Turma>) turmaRepository.findAll();
		
		return turma;
	}
	
	
	


}
