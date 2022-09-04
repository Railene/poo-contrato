package servicos;

public interface ServicoPagamentoOnline {
		double taxaPagamento(double quantia);
		double interesse(double quantia, int meses);

}
