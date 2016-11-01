package com.fiapbank.objects;

import java.math.BigDecimal;

public class Conta {
	private Long agencia;
	private Long numero;
	private Long digito;
	private TipoConta conta;
	private BigDecimal saldo;
	
	public Long getAgencia() {
		return agencia;
	}
	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getDigito() {
		return digito;
	}
	public void setDigito(Long digito) {
		this.digito = digito;
	}
	public TipoConta getConta() {
		return conta;
	}
	public void setConta(TipoConta conta) {
		this.conta = conta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
