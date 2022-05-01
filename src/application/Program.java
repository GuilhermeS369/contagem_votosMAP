package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try (BufferedReader leitor = new BufferedReader(
				new FileReader("D:\\MegaSync\\Docs e Projetos\\Java\\in.txt"))) {
				//LEITOR
			Map<String, Integer> candidatos = new HashMap<>();
			// O MAP EM HASH
			String line = leitor.readLine();
			//LER A LINHA
			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer votos = Integer.parseInt(fields[1]);
				//MANJADINHO PRA DIVIDIR EM UM VETOR
				if (candidatos.containsKey(nome)) {
					//SE JA EXISTIR O NOME DENTRO DA LISTA, ELE PEGA E SOMA OS VOTOS
					Integer votosomado = candidatos.get(nome) + votos;
					candidatos.put(nome, votosomado);
				}
				else {// SENAO, ELE INSERE
					candidatos.put(nome, votos);
				}
				//LE A PROXIMA LINHA
				line = leitor.readLine();

			}

			for (String chave : candidatos.keySet()) { //FOR PARA PERCORRER E EXIBIR
				System.out.println(chave + ": " + candidatos.get(chave));
			}

		} catch (IOException e) {
			System.out.println("errou manito: " + e.getMessage());
		}
		sc.close();

	}

}
