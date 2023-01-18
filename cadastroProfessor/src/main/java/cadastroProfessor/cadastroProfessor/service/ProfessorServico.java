package cadastroProfessor.cadastroProfessor.service;

import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import cadastroProfessor.cadastroProfessor.model.Professor;

public class ProfessorServico {	
	
	public double calculaSalario(double qtdHoras, double valorHoras) {
		
		return qtdHoras * valorHoras;
	}

}
