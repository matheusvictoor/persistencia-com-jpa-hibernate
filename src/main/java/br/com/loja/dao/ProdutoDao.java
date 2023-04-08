package br.com.loja.dao;

import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }
    public void remover(Produto produto) {
        produto = em.merge(produto);
        this.em.remove(produto);
    }
    public Produto find(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> findByName(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Produto.class).setParameter(1, nome).getResultList();
    }

    public List<Produto> findByCategory(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :OuPorApelido";
        return em.createQuery(jpql, Produto.class).setParameter("OuPorApelido", nome).getResultList();
    }

    public Double findByAttributePrice(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Double.class).setParameter(1, nome).getSingleResult();
    }
}
