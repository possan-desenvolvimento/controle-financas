package br.com.controlefinanceiro;

import br.com.controlefinanceiro.model.ContaMes;
import br.com.controlefinanceiro.service.ContaMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
   private ContaMesService service;

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Sistema de Controle Financeiro!");

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Verificar dados da tabela");
            System.out.println("2 - Adicionar nova conta");
            System.out.println("3 - Alterar conta existente");
            System.out.println("4 - Excluir conta");
            System.out.println("5 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    service.listarTodas().forEach(System.out::println);
                }
                case 2 -> {
                    ContaMes novaConta = new ContaMes();
                    System.out.print("Tipo da conta: ");
                    novaConta.setTipoConta(scanner.nextLine());
                    System.out.print("Valor da conta: ");
                    novaConta.setValorConta(scanner.nextBigDecimal());
                    scanner.nextLine();
                    System.out.print("Situação da conta: ");
                    novaConta.setSituacaoConta(scanner.nextLine());
                    System.out.print("Quantidade de parcelas: ");
                    novaConta.setQtdParcelas(scanner.nextLine());
                    System.out.print("Data de vencimento (AAAA-MM-DD): ");
                    novaConta.setVencimentoConta(LocalDate.parse(scanner.nextLine()));
                    service.salvar(novaConta);
                    System.out.println("Conta adicionada com sucesso!");
                }
                case 3 -> {
                    System.out.print("ID da conta a alterar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    var contaOpt = service.buscarPorId(id);
                    if (contaOpt.isPresent()) {
                        ContaMes conta = contaOpt.get();
                        System.out.print("Novo tipo: ");
                        conta.setTipoConta(scanner.nextLine());
                        System.out.print("Novo valor: ");
                        conta.setValorConta(scanner.nextBigDecimal());
                        scanner.nextLine();
                        System.out.print("Nova situação: ");
                        conta.setSituacaoConta(scanner.nextLine());
                        System.out.print("Nova quantidade de parcelas: ");
                        conta.setQtdParcelas(scanner.nextLine());
                        System.out.print("Nova data de vencimento: ");
                        conta.setVencimentoConta(LocalDate.parse(scanner.nextLine()));
                        service.salvar(conta);
                        System.out.println("Conta atualizada!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                }
                case 4 -> {
                    System.out.print("ID da conta a excluir: ");
                    int id = scanner.nextInt();
                    service.deletar(id);
                    System.out.println("Conta excluída!");
                }
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }
}