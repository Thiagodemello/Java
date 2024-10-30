/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoCompras;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author thiag
 */
public class areaCompras {
Scanner sc;
ArrayList<produto>produtos = new ArrayList<>();
ArrayList<produto>carrinho = new ArrayList<>();

float dinheiro = 1000000;

public areaCompras(){
    produtos.add(new Alimentos("Salgadinho",15, "30/10/25"));
    produtos.add(new EletroDomesticos("Geladeira",2000, "11/08/2050"));
    produtos.add(new Vestimenta("Terno",600, "Sem validade"));
    produtos.add(new drogas("Gardenal",180, "01/04/2026"));
    produtos.add(new joias("colar De Brilhantes",10000, "Validade de dois anos ate a proxima Revisao."));
    sc = new Scanner (System.in);
}
public void menu(){
while (true) {
            System.out.println("--------------Menu--------------:");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Produto ao Carrinho");
            System.out.println("3. Remover Produto do Carrinho");
            System.out.println("4. Listar Carrinho");
            System.out.println("5. Realizar Pagamento");
            System.out.println("6. Sair");
            System.out.print("---------Escolha uma opcao:--------:");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    adicionarAoCarrinho();
                    break;
                case 3:
                    removerDoCarrinho();
                    break;
                case 4:
                    listarCarrinho();
                    break;
                case 5:
                    realizarPagamento();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void listarProdutos() {
        System.out.println("\nProdutos disponíveis:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }

    public void adicionarAoCarrinho() {
        listarProdutos();
        System.out.print("Escolha o número do produto para adicionar ao carrinho: ");
        int indice = sc.nextInt() - 1;
        if (indice >= 0 && indice < produtos.size()) {
            carrinho.add(produtos.get(indice));
            System.out.println(produtos.get(indice).getNome() + " adicionado ao carrinho.");
        } else {
            System.out.println("Produto inválido.");
        }
    }

    public void removerDoCarrinho() {
        listarCarrinho();
        System.out.print("Escolha o número do produto para remover do carrinho: ");
        int indice = sc.nextInt() - 1;
        if (indice >= 0 && indice < carrinho.size()) {
            System.out.println(carrinho.get(indice).getNome() + " removido do carrinho.");
            carrinho.remove(indice);
        } else {
            System.out.println("Produto inválido.");
        }
    }

    public void listarCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("\nProdutos no carrinho:");
        for (int i = 0; i < carrinho.size(); i++) {
            System.out.println((i + 1) + ". " + carrinho.get(i));
        }
    }

    public float calcularTotal() {
        float total = 0;
        for (produto p : carrinho) {
            total += p.getPreco();
        }
        return total;
    }

    public void realizarPagamento() {
        float total = calcularTotal();
        if (total > 0) {
            if (dinheiro >= total) {
                System.out.println("Pagamento realizado com sucesso! Total: R$ " + total);
                dinheiro -= total; // Deduz o total do dinheiro disponível
                carrinho.clear(); // Limpa o carrinho após o pagamento
            } else {
                System.out.println("Saldo insuficiente. Você precisa de R$ " + (total - dinheiro) + " a mais.");
            }
        } else {
            System.out.println("Carrinho vazio, não é possível realizar o pagamento.");
        }
    }
}


