package dev.erik.restaurante.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import dev.erik.restaurante.dto.ProdutoRequest;
import dev.erik.restaurante.dto.ProdutoResponse;
import dev.erik.restaurante.entity.CategoriaProduto;
import dev.erik.restaurante.entity.Produto;
import dev.erik.restaurante.repository.CategoriaProdutoRepository;
import dev.erik.restaurante.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaProdutoRepository categoriaProdutoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaProdutoRepository categoriaProdutoRepository){
        this.produtoRepository = produtoRepository;
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    public ProdutoResponse cadastrar(ProdutoRequest request){
        CategoriaProduto categoriaProduto = buscarCategoriaPorId(request.categoriaId());
        Produto produto = request.toEntity(categoriaProduto);
        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoResponse.fromEntity(produtoSalvo);
    }

    public Page<ProdutoResponse> listar(Pageable pageable) {
        return produtoRepository.findAll(pageable).map(ProdutoResponse::fromEntity);
    }

    public ProdutoResponse buscarPorId(Long id){
        Produto produto = buscarProdutoPorId(id);
        return ProdutoResponse.fromEntity(produto);
    }

    public ProdutoResponse atualizar(Long id, ProdutoRequest request){
        Produto produto = buscarProdutoPorId(id);
        CategoriaProduto categoriaProduto = buscarCategoriaPorId(request.categoriaId());
        request.preencher(produto, categoriaProduto);
        Produto produtoAtualizado = produtoRepository.save(produto);
        return ProdutoResponse.fromEntity(produtoAtualizado);
    }

    public void excluir(Long id){
        Produto produto = buscarProdutoPorId(id);
        produtoRepository.delete(produto);
    }

    private Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!")); 
    }

    private CategoriaProduto buscarCategoriaPorId(Long id){
        return categoriaProdutoRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
    }
}
