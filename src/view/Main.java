package view;

import model.Cliente;
import model.ContaCorrente;
import model.Endereco;
import model.PessoaFisica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        Cliente cliente = new PessoaFisica(1000,
                new Endereco("Rua A", 30, "Cajazeiras"),
                "111.111.111-01", "João",
                LocalDate.of(1990, 1, 1));

        ContaCorrente contaCorrente = new ContaCorrente(1, 1,
                0, LocalDate.now(), cliente, 20);

        do {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Aplicar Taxa");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    contaCorrente.depositar(valorDeposito);
                    System.out.println("Depósito efetuado. Saldo atual: " + contaCorrente.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (contaCorrente.sacar(valorSaque)) {
                        System.out.println("Saque efetuado. Saldo atual: " + contaCorrente.getSaldo());
                    } else {
                        System.out.println("Saque não permitido devido a saldo insuficiente.");
                    }
                    break;
                case 3:
                    contaCorrente.aplicarTaxa();
                    System.out.println("Taxa de manutenção aplicada. Saldo atual: " + contaCorrente.getSaldo());
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    //        //Para ajudar com as datas
//        DateTimeFormatter formatter = DateTimeFormatter
//                .ofPattern("dd/MM/yyyy");
//        String string = "29/02/2000";
//        //Ler
//        LocalDate localDate = LocalDate.parse(string, formatter);
//        //Escrever
//        System.out.println(localDate.format(formatter));

}


