package br.com.tools.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tools.converter.TransacaoConverter;
import br.com.tools.dto.TransacaoDto;
import br.com.tools.entity.Transacao;
import br.com.tools.enums.TipoStatusTransacao;
import br.com.tools.repository.TransacaoRepository;

@Service
public class TransacaoService {
	private TransacaoRepository transacaoRepository;
	private TransacaoConverter transacaoConverter;

	@Autowired
	public TransacaoService(TransacaoRepository transacaoRepository, TransacaoConverter transacaoConverter) {
		this.transacaoRepository = transacaoRepository;
		this.transacaoConverter = transacaoConverter;
	}

	public List<TransacaoDto> buscarTodosOsRegistros() {
		List<Transacao> transacaoList = transacaoRepository
				.findAllByDescricaoStatusIn(List.of(TipoStatusTransacao.AUTORIZADO, TipoStatusTransacao.NEGADO));
		return transacaoConverter.converterModelList(transacaoList);
	}

	public TransacaoDto buscarTransacaoPorId(final String id) {
		try {
			Transacao transacao = transacaoRepository.findByIdAndDescricaoStatusIn(Long.parseLong(id),
					Arrays.asList(TipoStatusTransacao.AUTORIZADO, TipoStatusTransacao.NEGADO)).orElse(null);
			return transacaoConverter.converterModel(transacao);
		} catch (Exception e) {
			return null;
		}
	}

	public TransacaoDto buscarEstornoPorId(final String id) {
		try {
			Transacao transacao = transacaoRepository
					.findByIdAndDescricaoStatusIn(Long.parseLong(id), List.of(TipoStatusTransacao.CANCELADO))
					.orElseThrow(() -> null);
			return transacaoConverter.converterModel(transacao);
		} catch (Exception e) {
			return null;
		}
	}

	public TransacaoDto processarTransacao(TransacaoDto transacao) {
		Transacao transacaoModel = transacaoConverter.converterDto(transacao);
		if (transacaoModel == null)
			return null;

		if (transacaoModel.getDescricaoStatus() == null) {
			transacaoModel.setDescricaoStatus(TipoStatusTransacao.AUTORIZADO);
		}
		long random6 = (long) (Math.random() * 1000000 + 1);
		long random8 = (long) (Math.random() * 100000000 + 1);
		transacaoModel.setDescricaoNsu(random6);
		transacaoModel.setDescricaoCodigoAutorizacao(random8);

		transacaoModel = transacaoRepository.save(transacaoModel);
		return transacaoConverter.converterModel(transacaoModel);
	}
}
