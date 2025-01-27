package br.sp.oz.portal.logistica.configurations;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.sp.oz.portal.logistica.service.repositories.ProdutosRepository;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;
import jakarta.annotation.PostConstruct;

@Component
public class PostMigrationComponent {

    @Autowired
    private ProdutosRepository produto;

    /**
     * Solução temporaria para impedimento devido a erro no flyway.
     */
    @PostConstruct
    private void insertProdutos() {
        Set<Produtos> produtos = Set.of(
            Produtos.builder().nome("Produto A").dataHoraEntrada(LocalDateTime.now().minusDays(1)).dataHoraSaida(LocalDateTime.now().plusDays(30)).descricao("Descricao do Produto A").precoCompra(10.5f).precoMedio(12.0f).precoVenda(15.0f).validadeLoteData(LocalDate.now().plusDays(90)).qtdLote(100).build(),
            Produtos.builder().nome("Produto B").dataHoraEntrada(LocalDateTime.now().minusDays(2)).dataHoraSaida(LocalDateTime.now().plusDays(40)).descricao("Descricao do Produto B").precoCompra(20.0f).precoMedio(22.5f).precoVenda(28.0f).validadeLoteData(LocalDate.now().plusDays(80)).qtdLote(200).build(),
            Produtos.builder().nome("Produto C").dataHoraEntrada(LocalDateTime.now().minusDays(3)).dataHoraSaida(LocalDateTime.now().plusDays(35)).descricao("Descricao do Produto C").precoCompra(30.0f).precoMedio(35.0f).precoVenda(40.0f).validadeLoteData(LocalDate.now().plusDays(70)).qtdLote(150).build(),
            Produtos.builder().nome("Produto D").dataHoraEntrada(LocalDateTime.now().minusDays(1)).dataHoraSaida(LocalDateTime.now().plusDays(20)).descricao("Descricao do Produto D").precoCompra(15.0f).precoMedio(16.5f).precoVenda(20.0f).validadeLoteData(LocalDate.now().plusDays(100)).qtdLote(50).build(),
            Produtos.builder().nome("Produto E").dataHoraEntrada(LocalDateTime.now().minusDays(4)).dataHoraSaida(LocalDateTime.now().plusDays(50)).descricao("Descricao do Produto E").precoCompra(25.0f).precoMedio(30.0f).precoVenda(35.0f).validadeLoteData(LocalDate.now().plusDays(85)).qtdLote(300).build(),
            Produtos.builder().nome("Produto F").dataHoraEntrada(LocalDateTime.now().minusDays(5)).dataHoraSaida(LocalDateTime.now().plusDays(45)).descricao("Descricao do Produto F").precoCompra(5.5f).precoMedio(6.5f).precoVenda(10.0f).validadeLoteData(LocalDate.now().plusDays(120)).qtdLote(80).build(),
            Produtos.builder().nome("Produto G").dataHoraEntrada(LocalDateTime.now().minusDays(6)).dataHoraSaida(LocalDateTime.now().plusDays(60)).descricao("Descricao do Produto G").precoCompra(50.0f).precoMedio(55.0f).precoVenda(60.0f).validadeLoteData(LocalDate.now().plusDays(150)).qtdLote(250).build(),
            Produtos.builder().nome("Produto H").dataHoraEntrada(LocalDateTime.now().minusDays(7)).dataHoraSaida(LocalDateTime.now().plusDays(70)).descricao("Descricao do Produto H").precoCompra(40.0f).precoMedio(45.0f).precoVenda(50.0f).validadeLoteData(LocalDate.now().plusDays(180)).qtdLote(400).build(),
            Produtos.builder().nome("Produto I").dataHoraEntrada(LocalDateTime.now().minusDays(8)).dataHoraSaida(LocalDateTime.now().plusDays(15)).descricao("Descricao do Produto I").precoCompra(12.0f).precoMedio(13.5f).precoVenda(18.0f).validadeLoteData(LocalDate.now().plusDays(130)).qtdLote(120).build(),
            Produtos.builder().nome("Produto J").dataHoraEntrada(LocalDateTime.now().minusDays(9)).dataHoraSaida(LocalDateTime.now().plusDays(90)).descricao("Descricao do Produto J").precoCompra(35.0f).precoMedio(40.0f).precoVenda(45.0f).validadeLoteData(LocalDate.now().plusDays(200)).qtdLote(180).build()
        );
        produto.saveAll(produtos);
    }

}