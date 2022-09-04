package servicos;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Prestacao;

public class ContratoServico {
private ServicoPagamentoOnline servicoPagamentoOnline;
	
	public ContratoServico(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	
	}

	public void contratoProcesso(Contrato contrato, int meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
        for (int i = 1; i <= meses; i++) {
            Date data = addMeses(contrato.getData(), i);
            double cotaAtualizada = cotaBasica + servicoPagamentoOnline.interesse(cotaBasica, i);
            double cotaCompleta =  cotaAtualizada + servicoPagamentoOnline.taxaPagamento(cotaAtualizada);
            contrato.addPrestacao(new Prestacao(data, cotaCompleta));
        }
	}
	
	private Date addMeses(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
