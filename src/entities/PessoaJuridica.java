package entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer funcionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}

	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Double imposto() {
		double imposto = 0;
		if (funcionarios > 10) {
			imposto = getRendaAnual() * 0.14; 
		}
		else {
			imposto = getRendaAnual() * 0.16;
		}
		return imposto;
	}

}
