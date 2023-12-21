package desafioAtletaJava;

import java.util.Scanner;

public class relatorioAtletas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de atletas: ");
        int n = scanner.nextInt();

        double pesoTotal = 0;
        double alturaMediaMulheres = 0;
        String atletaMaisAltoNome = "";
        double atletaMaisAltoAltura = 0;
        int mulheresCadastradas = 0;
        int homensCadastrados = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nDados do Atleta " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.next();

            String sexo;
            do {
                System.out.print("Sexo (F/M): ");
                sexo = scanner.next().toUpperCase();
            } while (!sexo.equals("F") && !sexo.equals("M"));
            double altura;
            do {
                System.out.print("Altura (em metros): ");
                altura = scanner.nextDouble();
            } while (altura <= 0);
            double peso;
            do {
                System.out.print("Peso (em kg): ");
                peso = scanner.nextDouble();
            } while (peso <= 0);
            pesoTotal += peso;

            if (sexo.equals("F")) {
                alturaMediaMulheres += altura;
                mulheresCadastradas++;
            } else {
                homensCadastrados++;
            }

            if (altura > atletaMaisAltoAltura) {
                atletaMaisAltoAltura = altura;
                atletaMaisAltoNome = nome;
            }
        }

        System.out.println("\nRelatório:");
        System.out.println("Peso médio dos atletas: " + (pesoTotal / n));
        
        if (atletaMaisAltoNome.equals("")) {
            System.out.println("Não há atletas cadastrados.");
        } else {
            System.out.println("Nome do atleta mais alto: " + atletaMaisAltoNome);
        }

        System.out.println("Porcentagem de homens: " + ((homensCadastrados * 100.0) / n) + "%");

        if (mulheresCadastradas > 0) {
            System.out.println("Altura média das mulheres: " + (alturaMediaMulheres / mulheresCadastradas));
        } else {
            System.out.println("Não há mulheres cadastradas.");
        }
    }
	
}

