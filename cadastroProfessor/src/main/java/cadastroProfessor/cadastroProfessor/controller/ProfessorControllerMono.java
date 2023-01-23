package cadastroProfessor.cadastroProfessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroProfessor.cadastroProfessor.model.Professor;
import cadastroProfessor.cadastroProfessor.repository.ProfessorRepository;
import cadastroProfessor.cadastroProfessor.service.ProfessorServico;

@Controller
public class ProfessorControllerMono {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping("/")
	public ModelAndView listarAlunoMetodo() {
		
		ModelAndView modelAndView = new ModelAndView("listarProfessor");
		Iterable<Professor> professores = professorRepository.findAll(); 
		
		modelAndView.addObject("professores", professores);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/cadastrarProfessor", method=RequestMethod.POST)
	public String cadastrarProfessorMetodoPost(Professor professor) {
		
		ProfessorServico processorServico = new ProfessorServico();
		
		professor.setSalario(processorServico.calculaSalario(professor.getQtdHorasTrabalhadas(), professor.getValorHoraTrabalhada()));
	    
		professorRepository.save(professor);
		
		return "redirect:/";
	
	}
	
	@RequestMapping("/cadastrarProfessor")
	public String cadastrarAlunoMetodoGet() {
		
		return "cadastrarProfessor";
		
	}
	
	@RequestMapping("/deletarProfessor")
	public String deletarProfessor(long codigo) {
		Professor professor = professorRepository.findById(codigo);

		professorRepository.delete(professor);

		return "redirect:/";
	}
	
	@RequestMapping(value ="/{codigo}", method = RequestMethod.GET)
	public ModelAndView editarProfessorMetodo(@PathVariable("codigo") long codigo) {
		Professor professor = professorRepository.findById(codigo);
		ModelAndView modelAndViewProfessor = new ModelAndView("editarProfessor");
		modelAndViewProfessor.addObject("professor", professor);
		
		return modelAndViewProfessor;
		
	}
	
	@RequestMapping(value ="/{codigo}", method = RequestMethod.POST)
	public String editarProfessorPost(Professor professor) {
		
		
		ProfessorServico processorServico = new ProfessorServico();
		
		professor.setSalario(processorServico.calculaSalario(professor.getQtdHorasTrabalhadas(), professor.getValorHoraTrabalhada()));
		
		professorRepository.save(professor);
		return "redirect:/";
	}
	
}
