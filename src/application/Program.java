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

			Map<String, Integer> candidatos = new HashMap<>();

			String line = leitor.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer votos = Integer.parseInt(fields[1]);

				if (candidatos.containsKey(nome)) {
					Integer votosomado = candidatos.get(nome) + votos;
					candidatos.put(nome, votosomado);
				}
				else {
					candidatos.put(nome, votos);
				}

				line = leitor.readLine();

			}

			for (String chave : candidatos.keySet()) {
				System.out.println(chave + ": " + candidatos.get(chave));
			}

		} catch (IOException e) {
			System.out.println("errou manito: " + e.getMessage());
		}
		sc.close();

	}

}
