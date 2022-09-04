package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Prestacao;
import servicos.ContratoServico;
import servicos.ServicoPaypal;

public class Programa {

	public static void main(String[] args)  throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Digite os dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor contrato: ");
		Double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Digite o número de parcelas: ");
		int n = sc.nextInt();
		
		ContratoServico cs = new ContratoServico(new ServicoPaypal());
		
		cs.contratoProcesso(contrato, n);
		
		System.out.println("Parcelas:");
		for (Prestacao x : contrato.getParcela()) {
			System.out.println(x);
		}
		
		sc.close();

	}

}
