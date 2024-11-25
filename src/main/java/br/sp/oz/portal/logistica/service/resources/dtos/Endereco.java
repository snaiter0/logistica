package br.sp.oz.portal.logistica.service.resources.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Endereco {

	private String nomeEndereco;
	private boolean pessoaJuridica;;
	private String rua;
	private String bairro; 
	private String cidade; 
	private String estado; 
	private String pais; 
	private String numero;
	private String complemento;
	private String referencia;
	
}
