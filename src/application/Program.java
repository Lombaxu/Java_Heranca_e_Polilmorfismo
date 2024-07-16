package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> lista = new ArrayList<>();
		
		System.out.print("Insira o número de pagadores de impostos: ");
		int pag = sc.nextInt();
		
		for (int i = 1; i <= pag; i++) {
			System.out.println("Dados do #" + i + " pagador:");
			System.out.print("Pessoa Física ou Jurídica (f/j)? ");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			
			if (resp == 'f') {
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Renda anual: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Gastos com Saúde: ");
				Double gastosSaude = sc.nextDouble();
				lista.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
			else {
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Renda anual: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Número de funcionários: ");
				int funcionarios = sc.nextInt();
				lista.add(new PessoaJuridica(nome, rendaAnual, funcionarios));
			}
		}
		
		System.out.println();
		
		System.out.println("IMPOSTOS PAGOS:");
		
		double somaTotal = 0;
		
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getNome() + ": $ " + String.format("%.2f", pessoa.imposto()));
			somaTotal += pessoa.imposto();
		}
		
		System.out.println();
		
		System.out.printf("TOTAL DE IMPOSTOS: $ %.2f", somaTotal);
		
		sc.close();
		
	}

}
