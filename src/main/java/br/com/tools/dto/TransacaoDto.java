package br.com.tools.dto;

import org.springframework.lang.Nullable;

import br.com.tools.enums.TipoFormaPagamento;
import br.com.tools.enums.TipoStatusTransacao;
import jakarta.validation.constraints.NotBlank;

public record TransacaoDto(
		@NotBlank String id,
        @NotBlank String cartao,
        @Nullable Double descricaoValor,
        @Nullable String descricaoDataHora,
		@Nullable String descricaoEstabelecimento,
		@Nullable Long descricaoNsu,
		@Nullable Long descricaoCodigoAutorizacao,
		@Nullable TipoStatusTransacao descricaoStatus,
		@Nullable TipoFormaPagamento formaPagamentoTipo,
		@Nullable Long formaPagamentoParcelas
) {

}
