package util;

import entidades.Planeta;

import java.util.*;
import java.util.stream.*;

public class StreamsPlanetas {

	public static List<Planeta> filtrarComAtmosfera(List<Planeta> planetas) {
		return planetas.stream().filter(Planeta::isTemAtmosfera).collect(Collectors.toList());
	}

	public static List<Planeta> diametroMaior10000(List<Planeta> planetas) {
		return planetas.stream().filter(p -> p.getDiametro() > 10_000)
				.collect(Collectors.toList());
	}

	public static Planeta maisProximoDoSol(List<Planeta> planetas) {
		return planetas.stream().min(Comparator.comparingDouble(Planeta::getDistanciaSol)).orElse(null);
	}

	public static boolean existeMassaMaiorQue1000(List<Planeta> planetas) {
		return planetas.stream().anyMatch(p -> p.getMassa() > 1000);
	}

	public static double massaTotal(List<Planeta> planetas) {
		return planetas.stream().mapToDouble(Planeta::getMassa).sum();
	}

	public static double mediaDistanciaSol(List<Planeta> planetas) {
		return planetas.stream().mapToDouble(Planeta::getDistanciaSol).average().orElse(0);
	}

	public static List<Planeta> ordenarPorMassaDecrescente(List<Planeta> planetas) {
		return planetas.stream().sorted(Comparator.comparingDouble(Planeta::getMassa).reversed()).collect(Collectors.toList());
	}

	public static Map<Boolean, List<Planeta>> agruparPorAtmosfera(List<Planeta> planetas) {
		return planetas.stream().collect(Collectors.groupingBy(Planeta::isTemAtmosfera));
	}

	public static List<Planeta> tresMaisDistantes(List<Planeta> planetas) {
		return planetas.stream().sorted(Comparator.comparingDouble(Planeta::getDistanciaSol).reversed()).limit(3)
				.collect(Collectors.toList());
	}

	public static List<Planeta> concatenarNomes(List<Planeta> planetas) {
		return planetas;
	}
}
