package br.com.tools.converter;

import org.springframework.stereotype.Component;

import br.com.tools.dto.TransacaoDto;
import br.com.tools.entity.Transacao;

@Component
public class TransacaoConverter extends Converter<TransacaoDto, Transacao> {

	public TransacaoConverter() {
		super(TransacaoConverter::converterModel, TransacaoConverter::converterDto);
	}

	private static Transacao converterModel(TransacaoDto dto) {
		if (dto == null)
			return null;

		return new Transacao(Long.parseLong(dto.id()), dto.cartao(), dto.descricaoValor(), dto.descricaoDataHora(),
				dto.descricaoEstabelecimento(), dto.descricaoNsu(), dto.descricaoCodigoAutorizacao(),
				dto.descricaoStatus(), dto.formaPagamentoTipo(), dto.formaPagamentoParcelas());
	}

	private static TransacaoDto converterDto(Transacao model) {
		if (model == null)
			return null;

		return new TransacaoDto(model.getId().toString(), model.getCartao(), model.getDescricaoValor(),
				model.getDescricaoDataHora(), model.getDescricaoEstabelecimento(), model.getDescricaoNsu(),
				model.getDescricaoCodigoAutorizacao(), model.getDescricaoStatus(), model.getFormaPagamentoTipo(),
				model.getFormaPagamentoParcelas());
	}

}
