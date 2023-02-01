package cadastroProfessor.cadastroProfessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cadastroProfessor.cadastroProfessor.model.Professor;
import cadastroProfessor.cadastroProfessor.model.Turma;
import cadastroProfessor.cadastroProfessor.repository.ProfessorRepository;
import cadastroProfessor.cadastroProfessor.repository.TurmaRepository;

@Controller
public class TurmaControllerMono {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	TurmaRepository turmaRepository;

	@RequestMapping(value ="cadastrarTurma/{codigo}", method = RequestMethod.GET)
	public ModelAndView cadastrarTurmaMetodo(@PathVariable("codigo") long codigo) {
		Professor professor = professorRepository.findById(codigo);
		ModelAndView modelAndViewAluno = new ModelAndView("cadastrarTurma");
		modelAndViewAluno.addObject("professor", professor);
		return modelAndViewAluno;
		
	}
	
	@RequestMapping(value ="cadastrarTurma/{codigo}", method = RequestMethod.POST)
	public String cadastrarTurmaMetodoPost(@PathVariable("codigo") long codigo, Turma turma) {
		turma.setProfessor(professorRepository.findById(codigo));
		
		turmaRepository.save(turma);
		
		return "redirect:/";
		
	}
	
}
