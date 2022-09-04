package servicos; 

public class ServicoPaypal implements ServicoPagamentoOnline {

		private static final double FEE_PERCENTAGE = 0.02;
		private static final double MONTHLY_INTEREST = 0.01;

		@Override
		public double taxaPagamento(double amount) {
			return amount * FEE_PERCENTAGE;
		}

		@Override
		public double interesse(double amount, int months) {
			return amount * MONTHLY_INTEREST * months;
		}
}
