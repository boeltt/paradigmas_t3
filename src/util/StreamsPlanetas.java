package util;

import entidades.Planeta;

import java.util.*;
import java.util.stream.*;

public class StreamsPlanetas {
	// A ideia aqui foi padronizar e seprar bem as responsabilidades de cada classe,
	// sendo assim, todas as Streams trabalham com objetos ou listas desses objetos
	// Aqui a lógica ta no return pra evitar instancias desnecessarias

	// A stream o .filter lê o boolean e usa o collect pra armazenar em uma lista,
	// seria como fazer um loop que testa isso e usa o add
	public static List<Planeta> filtrarComAtmosfera(List<Planeta> planetas) {
		return planetas.stream().filter(Planeta::isTemAtmosfera).collect(Collectors.toList());
	}

	// Nessa o filter instancia um objeto do tipo Planeta, pra cada Planeta na lista
	// plaetas, igual um forEach e testa se o atributo diametro, através do getter,
	// é maior que 10 mil
	// depois o collector de novo pra adicionar na lista de retorno
	public static List<Planeta> diametroMaior10000(List<Planeta> planetas) {
		return planetas.stream().filter(p -> p.getDiametro() > 10_000).collect(Collectors.toList());
	}

	// Aqui o min vai filtrar o menor, pra isso, a gente usa o
	// Comparator.comparingDouble entre os objetos da lista que ele recebe e, no
	// final dessa validação, retorna só o menor (min)
	public static Planeta maisProximoDoSol(List<Planeta> planetas) {
		return planetas.stream().min(Comparator.comparingDouble(Planeta::getDistanciaSol)).orElse(null);
	}

	// anyMatch funciona aqui porque desde que tenhamos um Planeta sequer com a
	// condição, o teste está satisfeito.
	public static boolean existeMassaMaiorQue1000(List<Planeta> planetas) {
		return planetas.stream().anyMatch(p -> p.getMassa() > 1000);
	}

	// Aqui a stream transforma a stream inicial do tipo Planeta em uma stream de
	// Double, usando o mapToDouble que vai receber a massa de cada objteo na stream
	// e somar
	public static double massaTotal(List<Planeta> planetas) {
		return planetas.stream().mapToDouble(Planeta::getMassa).sum();
	}

	// Mesma lógica anterior mas com o .average() pra fazer a média, o orEslse é o
	// default
	public static double mediaDistanciaSol(List<Planeta> planetas) {
		return planetas.stream().mapToDouble(Planeta::getDistanciaSol).average().orElse(0);
	}

	// A stream usa o sorted pra ordenar, comparando por massa e o reversed serve
	// pra deixar decrescente, no final o collect de novo
	public static List<Planeta> ordenarPorMassaDecrescente(List<Planeta> planetas) {
		return planetas.stream().sorted(Comparator.comparingDouble(Planeta::getMassa).reversed())
				.collect(Collectors.toList());
	}

	// aqui o collect com esse .groupingBy seleciona dessa forma mais simples porque
	// o atributo da atmosfera é boolean
	public static Map<Boolean, List<Planeta>> agruparPorAtmosfera(List<Planeta> planetas) {
		return planetas.stream().collect(Collectors.groupingBy(Planeta::isTemAtmosfera));
	}

	// de novo o sorted, a lógica é a mesma mas dessa vez só adiciona o limit, como
	// são os mais distantes, é decrescente tb, por isso o reversed()
	public static List<Planeta> tresMaisDistantes(List<Planeta> planetas) {
		return planetas.stream().sorted(Comparator.comparingDouble(Planeta::getDistanciaSol).reversed()).limit(3)
				.collect(Collectors.toList());
	}

	// Aqui vai ter que ser tratado nos testes, pra manter a responsabilidade e
	// reusabilidade do cógico, boa prática.
	public static List<Planeta> concatenarNomes(List<Planeta> planetas) {
		return planetas;
	}
}
