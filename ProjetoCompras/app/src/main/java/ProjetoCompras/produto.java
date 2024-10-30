/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoCompras;

/**
 *
 * @author thiago
 */
 public abstract class produto {


    protected String nome;
    protected double preco;
    protected String validade;

    public produto(String nome, double preco, String validade) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    public String getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco + validade;
    }
} 

