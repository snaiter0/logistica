package br.sp.oz.portal.logistica.application.dtos.produto;

public record EnderecoDto(String nomeEndereco,
						  boolean pessoaJuridica,
						  String rua,
						  String bairro,
						  String cidade,
						  String estado,
						  String pais,
						  String numero,
						  String complemento,
						  String referencia) {

	
}
