package com.leirbaggr.java.App;

import java.io.Console;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Exercicio 1:
 João é um comerciante que vende laranjas 
 Ele precisa fazer uma entrega de algumas caixas
 cada laranja ele vende por 0.50 centavos, cada caixa tem 50 laranjas.

 Faça um programa que peça a quantidade de caixas para o João e dê o total a receber.

 Exercicio 2:
 Perguntar se o pagamento é a vista, caso seja a vista e valor for maior que R$ 100 reais dar um desconto de 10%
 Caso o pagamento seja parcelado acrescentar 15% sobre a valor total segundo a tabela
 2x = 5%
 3x = 8%
 4x = 10%
 5x = 13%
 maior que 5% = 15%

 Obs: aceitar parcelas no maximo até 12 meses, e mostrar o valor de cada parcela já com acrescimo

 o lucro do comerciante será de 45% em suas vendas

 Dar um relatorio final sobre a operação acima
*/

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		System.out.println("==================================");
		System.out.println("Seja bem-vindo ao software");
		System.out.println("==================================");

		Console cnsl = System.console();
		// quantidadeCaixas
		int quantityBoxes = Integer
				.parseInt(cnsl.readLine("Digite a quantidade de caixas que você pretende vender?\n"));
		System.out.println("[" + quantityBoxes + "]");

		// valorLaranja
		double valueOrange = 0.50;
		// quantidadeCaixasPromoção
		int quantityBoxesPromotion = 10;
		// quantidadeLaranjasPorCaixa
		int quantityOrangesPerBox = 50;
		// lucro
		int profit = 40;
		// parcelamentoDesconto
		int installmentDiscount = 10;
		// porcentagemAdição
		int percentageAddition = 15;
		// máximoParcelas
		int maximumInstallments = 12;
		// valorParaDesconto
		double valueForDiscount = 100;
		// parcelada
		int installments = 0;
		int totalNumberOfOranges = quantityBoxes * quantityOrangesPerBox;
		double valorTotal = totalNumberOfOranges * valueOrange;
		double totalvaluechanged = valorTotal;

		String typePayment = cnsl.readLine("Você deseja pagar a vista ou parcelado ?\n A - A vista\n P - Parcelado\n");

		boolean aVista = typePayment.toUpperCase().equals("A");

		if (aVista) {
			System.out.println("O seu pagamento será a vista\n");
			if (valorTotal > valueForDiscount || quantityBoxes == quantityBoxesPromotion) {
				totalvaluechanged -= (valorTotal * installmentDiscount / 100);
			}
		} else {
			installments = Integer
					.parseInt(cnsl.readLine("O seu pagamento será parcelado, digite a quantidade de parcelas\n"));
			if (installments > maximumInstallments) {
				System.out.println(
						"Quantidade de parcelas inválidas, iremos assumir em " + maximumInstallments + " vezes");
				installments = maximumInstallments;
			}

			if (installments == 1) {
				System.out.println("O seu pagamento será a vista\n");
				if (valorTotal > valueForDiscount || quantityBoxes == quantityBoxesPromotion) {
					totalvaluechanged -= (valorTotal * installmentDiscount / 100);
				}
			}

			else if (installments > 5) {
				totalvaluechanged += (valorTotal * percentageAddition / 100);
			} else {
				switch (installments) {
					case 2:
						percentageAddition = 5;
						break;
					case 3:
						percentageAddition = 8;
						break;
					case 4:
						percentageAddition = 10;
						break;
					case 5:
						percentageAddition = 13;
						break;
				}
				totalvaluechanged += (valorTotal * percentageAddition / 100);
			}
		}

		double profitReceive = (totalvaluechanged * profit / 100);
		System.out.println("==================================");
		System.out.println("Muito bom, parabéns pela venda");
		System.out.println("O seu lucro vai ser de: R$ " + profitReceive);
		System.out.println("O valor total da venda a Cobrar do cliente é de: R$ " + totalvaluechanged);
		System.out.println("O cliente escolheu o tipo de pagamento: "
				+ (aVista ? "A vista" : "Parcelado em " + installments + "x"));
		if (aVista) {
			System.out.println("Para o pagamento a vista demos o desconto de: R$ " + (valorTotal - totalvaluechanged));
		} else {
			System.out.println(
					"Para o pagamento parcelado colocamos um acrescimo de: R$ " + (totalvaluechanged - valorTotal));
			System.out.println("O valor da parcela será de: R$ " + (totalvaluechanged / installments));
		}
		System.out.println("==================================");
		// SpringApplication.run(AppApplication.class, args);
	}

}
