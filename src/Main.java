import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		Curso curso1 = new Curso();
		curso1.setTitulo("curso java");
		curso1.setDescricao("descrição curso java");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("curso js");
		curso2.setDescricao("descrição curso js");
		curso2.setCargaHoraria(4);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("descrição mentoria java");
		mentoria.setData(LocalDate.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		List<Dev> devs = new ArrayList<>();
		int op = 0;

		System.out.println("------------------ MENU BOOTCAMP-------------------");
		System.out.print("1 - para incluir o nome do dev: ");
		System.out.println("\n--------------------------------------------------");
		System.out.print("2 - para incluir no Bootcamp: ");
		System.out.println("\n--------------------------------------------------");
		System.out.print("3 - para progredir: ");
		System.out.println("\n--------------------------------------------------");
		System.out.print("4 - para mostrar os conteudos inscritos: ");
		System.out.println("\n--------------------------------------------------");
		System.out.print("5 -  para mostrar os conteudos concluidos: ");
		System.out.println("\n--------------------------------------------------");
		System.out.print("6 - para mostrar o total de XP: ");
		System.out.println("\n--------------------------------------------------");
		System.out.println("7 - para sair: ");
		do {
			System.out.print("\nSelecione uma opção: ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.print("Insira o nome do dev: ");
				String name = sc.nextLine();
				devs.add(new Dev(name));
				break;
			case 2:
				System.out.print("Insira o nome do dev que voce deseja incluir no Bootcamp: ");
				name = sc.nextLine();
				for (Dev dev : devs) {
					if (dev.getNome().equals(name)) {
						dev.inscreverBootcamp(bootcamp);
						System.out.println("Dev Inscrito com Sucesso!!");
					} else {
						System.out.println("Esse dev não está cadastrado");
					}
				}
				break;
			case 3:
				System.out.print("Insira o nome do dev que voce deseja progredir de conteúdo: ");
				name = sc.nextLine();
				for (Dev dev : devs) {
					if (dev.getNome().equals(name)) {
						dev.progredir();
						System.out.println("Progresso Registrado com Sucesso!!");
					} else {
						System.out.println("Esse dev não está cadastrado");
					}
				}
				break;
			case 4:
				System.out.print("Insira o nome do dev que voce deseja ver os conteúdos inscritos: ");
				name = sc.nextLine();
				for (Dev dev : devs) {
					if (dev.getNome().equals(name)) {
						System.out.println(dev.getConteudosInscritos());
					} else {
						System.out.println("Esse dev não está cadastrado");
					}
				}
				break;
			case 5:
				System.out.print("Insira o nome do dev que voce deseja ver os conteúdos concluidos: ");
				name = sc.nextLine();
				for (Dev dev : devs) {
					if (dev.getNome().equals(name)) {
						System.out.println(dev.getConteudosConcluidos());
					} else {
						System.out.println("Esse dev não está cadastrado");
					}
				}
				break;
			case 6:
				System.out.print("Insira o nome do dev que voce deseja ver o XP total: ");
				name = sc.nextLine();
				for (Dev dev : devs) {
					if (dev.getNome().equals(name)) {
						System.out.println(dev.calcularTotalXp());
					} else {
						System.out.println("Esse dev não está cadastrado");
					}
				}
				break;

			default:
				break;
			}
		} while (op != 7);

		sc.close();

	}

}