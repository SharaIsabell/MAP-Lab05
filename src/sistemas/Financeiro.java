package sistemas;

import java.time.LocalDate;
import java.util.ArrayList;

import sistemas.entities.BalancoConta;
import sistemas.entities.FolhaPagamento;

public class Financeiro {
	private static BalancoConta balancoContas = new BalancoConta();
	private static ArrayList<FolhaPagamento> folhasPagamento = new ArrayList<FolhaPagamento>();
	
	public static void adicionarFolhaPagamento(LocalDate data, double ganhoPorHora, int horasTrabalhadas, String nome) {
		FolhaPagamento folhaPag = new FolhaPagamento(data, ganhoPorHora, horasTrabalhadas, nome);
		folhasPagamento.add(folhaPag);
	}
	
	public static double calcularTotalSalarios() {
		double total = 0;
		for(FolhaPagamento folhaPag : folhasPagamento) {
			total += folhaPag.calcularSalario();
		}
		
		return total;
	}
	
	public static void criarBalancoContas() {
		balancoContas = new BalancoConta();
	}

	public static BalancoConta getBalancoContas() {
		return balancoContas;
	}

	public static ArrayList<FolhaPagamento> getFolhasPagamento() {
		return folhasPagamento;
	}

}
