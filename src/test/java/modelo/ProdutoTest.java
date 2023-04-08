package modelo;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoTest {
    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto produto = produtoDao.find(1l);
        System.out.println(produto.getPreco());

        List<Produto> todos = produtoDao.findAll();
        todos.forEach(prod1 -> System.out.println(prod1.getNome()));

        List<Produto> todosPorNome = produtoDao.findByName("Xiaomi Redmi");
        todosPorNome.forEach(prod2 -> System.out.println(prod2.getNome()));

        List<Produto> PorCategoria = produtoDao.findByName("Celulares");
        PorCategoria.forEach(prod3 -> System.out.println(prod3.getNome()));

        double precoDoProduto = produtoDao.findByAttributePrice("Xiaomi Redmi");
        System.out.println("Preço do produto: " + precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria();
        Produto celular = new Produto("Xiaomi Redmi", "64GB", 1.299, celulares);

        // Para fazer qualquer operação (deletar, salvar...) no bd precisará dessa classe
        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin(); // Para iniciar a transaçãp

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit(); // Ao terminar a transação
        em.close();
    }
}
