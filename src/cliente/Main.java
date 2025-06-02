package cliente;

import entidades.Planeta;
import util.StreamsPlanetas;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Planeta> planetas = Arrays.asList(
            new Planeta("Mercúrio", 0.33, 4879, 58,  false),
            new Planeta("Vênus",     4.87,12104,108, true),
            new Planeta("Terra",     5.97,12756,150, true),
            new Planeta("Marte",     0.642,6792,228, true),
            new Planeta("Júpiter", 1898,142984,778, true),
            new Planeta("Saturno",  568,120536,1430,true),
            new Planeta("Urano",    86.8,51118,2870, true),
            new Planeta("Netuno",   102,49528,4490, true)
        );

        // 1. Nomes dos planetas com atmosfera
        System.out.println("1. Com atmosfera: " +
            StreamsPlanetas.filtrarComAtmosfera(planetas));

        // 2. Nomes de planetas com diâmetro > 10.000 km
        System.out.println("2. Diâmetro >10k: " +
            StreamsPlanetas.nomesDiametroMaior10000(planetas));

        // 3. Nome do planeta mais próximo do Sol
        System.out.println("3. Mais próximo do Sol: " +
            StreamsPlanetas.maisProximoDoSol(planetas));

        // 4. Existe massa >1000?
        System.out.println("4. Massa >1000? " +
            StreamsPlanetas.existeMassaMaiorQue1000(planetas));

        // 5. Massa total
        System.out.println("5. Massa total: " +
            StreamsPlanetas.massaTotal(planetas));

        // 6. Média das distâncias ao Sol
        System.out.println("6. Média distância: " +
            StreamsPlanetas.mediaDistanciaSol(planetas));

        // 7. Nomes ordenados por massa decrescente
        System.out.println("7. Massa desc: " +
            StreamsPlanetas.ordenarPorMassaDecrescente(planetas));

        // 8. Agrupamento por atmosfera (nomes)
        System.out.println("8. Agrupado por atmosfera: " +
            StreamsPlanetas.agruparPorAtmosfera(planetas));

        // 9. Nomes dos três planetas mais distantes
        System.out.println("9. Três mais distantes: " +
            StreamsPlanetas.tresMaisDistantes(planetas));

        // 10. Todos os nomes concatenados
        System.out.println("10. Todos os nomes: " +
            StreamsPlanetas.concatenarNomes(planetas));
    }
}
