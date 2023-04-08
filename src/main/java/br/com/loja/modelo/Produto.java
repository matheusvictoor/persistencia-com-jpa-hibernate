package br.com.loja.modelo;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity  // Significa que tem uma tabela no banco de dados para essa entidade
@Table (name = "produtos")  // Esse é como tá o nome da tabela no banco de dado não "Produto"
public class Produto {
    @Id // Preciso informar para a JPA qual dos atributos é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz que quem vai gerar esse id é o bd e não a aplicação.
    // A geração do id fica a depender do bd, mas geralmente se usa IDENTIFY ou SEQUENCY(para ser gerado em sequencia)
    private Long id;
    private String nome;

    // @Column(name = "desc") Caso esse fosse o nome da coluna lá no banco de dado
    private String descricao;
    private double preco;
    private LocalDate dataCadastro = LocalDate.now();

    // @Enumerated(EnumType.STRING) // Para salvar o nome da categoria no bd e não a ordem em que aparece no enum
    @ManyToOne // De produtos para categoria - Muitos para Um
    private Categoria categoria;

    public Produto(String nome, String descricao, double preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
    public Produto() {

    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
