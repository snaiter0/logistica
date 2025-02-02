package br.sp.oz.portal.logistica.controller.rest.resources.routes;

public interface Rotas {

	public static String API_LOGISTICA = "/logistica";
	
    // Prefixo base para todas as rotas
	public static String API_BASE = "/api/v1";

    // Rotas para o módulo de produtos
    public interface Produtos {
       public static String BASE = API_BASE + "/produtos";
       public static String ADICIONAR = BASE + ":atualizar";
       public static String PRODUTOS_POR_DIA = BASE + "/dia";
       public static String PRODUTOS_POR_DATA_JANELA = BASE + "/janela-data";
    }

    // Adicione outros módulos aqui
}