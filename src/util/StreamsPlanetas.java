package util;

import entidades.Planeta;

import java.util.*;
import java.util.stream.*;

public class StreamsPlanetas {

	// 1. Lista os nomes dos planetas que possuem atmosfera.
	public static List<String> filtrarComAtmosfera(List<Planeta> planetas) {
	    return planetas.stream()
	                   .filter(Planeta::isTemAtmosfera)
	                   .map(Planeta::getNome)
	                   .collect(Collectors.toList());
	}


    // 2. Lista os nomes dos planetas com diâmetro > 10.000 km.
    public static List<String> nomesDiametroMaior10000(List<Planeta> planetas) {
        return planetas.stream()
                       .filter(p -> p.getDiametro() > 10_000)
                       .map(Planeta::getNome)
                       .collect(Collectors.toList());
    }

    // 3. Retorna o nome do planeta mais próximo do Sol.
    public static String maisProximoDoSol(List<Planeta> planetas) {
        return planetas.stream()
                       .min(Comparator.comparingDouble(Planeta::getDistanciaSol))
                       .map(Planeta::getNome)
                       .orElse(null);
    }

    // 4. Verifica se existe algum planeta com massa > 1000.
    public static boolean existeMassaMaiorQue1000(List<Planeta> planetas) {
        return planetas.stream()
                       .anyMatch(p -> p.getMassa() > 1000);
    }

    // 5. Calcula a massa total de todos os planetas como String formatada.
    public static String massaTotal(List<Planeta> planetas) {
        double soma = planetas.stream()
                              .mapToDouble(Planeta::getMassa)
                              .sum();
        return String.format("%.3f", soma);
    }

    // 6. Calcula a média das distâncias dos planetas ao Sol como String formatada.
    public static String mediaDistanciaSol(List<Planeta> planetas) {
        double media = planetas.stream()
                               .mapToDouble(Planeta::getDistanciaSol)
                               .average()
                               .orElse(0);
        return String.format("%.2f", media);
    }

    // 7. Lista os nomes dos planetas ordenados por massa em ordem decrescente.
    public static List<String> ordenarPorMassaDecrescente(List<Planeta> planetas) {
        return planetas.stream()
                       .sorted(Comparator.comparingDouble(Planeta::getMassa).reversed())
                       .map(Planeta::getNome)
                       .collect(Collectors.toList());
    }

    // 8. Agrupa os planetas de acordo com a presença ou ausência de atmosfera.
    public static Map<Boolean, List<Planeta>> agruparPorAtmosfera(List<Planeta> planetas) {
        return planetas.stream()
                       .collect(Collectors.groupingBy(Planeta::isTemAtmosfera));
    }

    // 9. Lista os nomes dos três planetas mais distantes do Sol.
    public static List<String> tresMaisDistantes(List<Planeta> planetas) {
        return planetas.stream()
                       .sorted(Comparator.comparingDouble(Planeta::getDistanciaSol).reversed())
                       .limit(3)
                       .map(Planeta::getNome)
                       .collect(Collectors.toList());
    }

    // 10. Cria uma única String com os nomes de todos os planetas, separados por vírgulas.
    public static String concatenarNomes(List<Planeta> planetas) {
        return planetas.stream()
                       .map(Planeta::getNome)
                       .collect(Collectors.joining(", "));
    }
}
