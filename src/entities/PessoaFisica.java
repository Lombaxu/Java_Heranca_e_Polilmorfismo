package entities;

public class PessoaFisica extends Pessoa {
	
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public Double imposto() {
		double imposto = 0;
		if (super.getRendaAnual() > 20000) {
			imposto = super.getRendaAnual() * 0.25;
		}
		else {
			imposto = super.getRendaAnual() * 0.15;
		}
		return imposto - impostoSaude();
	}
	
	public Double impostoSaude() {
		double imposto = 0;
		imposto = getGastosSaude() * 0.5; 
		return imposto;
	}

}
