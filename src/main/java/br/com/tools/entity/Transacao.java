package br.com.tools.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import br.com.tools.enums.TipoFormaPagamento;
import br.com.tools.enums.TipoStatusTransacao;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Transacao extends AbstractPersistable<Long> {
	
	@NotBlank
    private String cartao;
	private Double descricaoValor;
	private String descricaoDataHora;
	private String descricaoEstabelecimento;
	private Long descricaoNsu;
	private Long descricaoCodigoAutorizacao;
	private TipoStatusTransacao descricaoStatus;
	private TipoFormaPagamento formaPagamentoTipo;
	private Long formaPagamentoParcelas;
	
	public Transacao(long id, @NotBlank String cartao, Double descricaoValor, String descricaoDataHora,
			String descricaoEstabelecimento, Long descricaoNsu, Long descricaoCodigoAutorizacao,
			TipoStatusTransacao descricaoStatus, TipoFormaPagamento formaPagamentoTipo, Long formaPagamentoParcelas) {
		super();
		super.setId(id);
		this.cartao = cartao;
		this.descricaoValor = descricaoValor;
		this.descricaoDataHora = descricaoDataHora;
		this.descricaoEstabelecimento = descricaoEstabelecimento;
		this.descricaoNsu = descricaoNsu;
		this.descricaoCodigoAutorizacao = descricaoCodigoAutorizacao;
		this.descricaoStatus = descricaoStatus;
		this.formaPagamentoTipo = formaPagamentoTipo;
		this.formaPagamentoParcelas = formaPagamentoParcelas;
	}

	public Transacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public Double getDescricaoValor() {
		return descricaoValor;
	}
	public void setDescricaoValor(Double descricaoValor) {
		this.descricaoValor = descricaoValor;
	}
	public String getDescricaoDataHora() {
		return descricaoDataHora;
	}
	public void setDescricaoDataHora(String descricaoDataHora) {
		this.descricaoDataHora = descricaoDataHora;
	}
	public String getDescricaoEstabelecimento() {
		return descricaoEstabelecimento;
	}
	public void setDescricaoEstabelecimento(String descricaoEstabelecimento) {
		this.descricaoEstabelecimento = descricaoEstabelecimento;
	}
	public Long getDescricaoNsu() {
		return descricaoNsu;
	}
	public void setDescricaoNsu(Long descricaoNsu) {
		this.descricaoNsu = descricaoNsu;
	}
	public Long getDescricaoCodigoAutorizacao() {
		return descricaoCodigoAutorizacao;
	}
	public void setDescricaoCodigoAutorizacao(Long descricaoCodigoAutorizacao) {
		this.descricaoCodigoAutorizacao = descricaoCodigoAutorizacao;
	}
	public TipoStatusTransacao getDescricaoStatus() {
		return descricaoStatus;
	}
	public void setDescricaoStatus(TipoStatusTransacao descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}
	public TipoFormaPagamento getFormaPagamentoTipo() {
		return formaPagamentoTipo;
	}
	public void setFormaPagamentoTipo(TipoFormaPagamento formaPagamentoTipo) {
		this.formaPagamentoTipo = formaPagamentoTipo;
	}
	public Long getFormaPagamentoParcelas() {
		return formaPagamentoParcelas;
	}
	public void setFormaPagamentoParcelas(Long formaPagamentoParcelas) {
		this.formaPagamentoParcelas = formaPagamentoParcelas;
	}
}