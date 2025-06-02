package util;

import entidades.Planeta;
import util.StreamsPlanetas;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPlanetsTest {

    private static List<Planeta> planetas;

    @BeforeClass
    public static void setup() {
        planetas = Arrays.asList(
            new Planeta("Mercúrio", 0.33, 4879, 58,  false),
            new Planeta("Vênus",     4.87,12104,108, true),
            new Planeta("Terra",     5.97,12756,150, true),
            new Planeta("Marte",     0.642,6792,228, true),
            new Planeta("Júpiter", 1898,142984,778, true),
            new Planeta("Saturno",  568,120536,1430,true),
            new Planeta("Urano",    86.8,51118,2870, true),
            new Planeta("Netuno",   102,49528,4490, true)
        );
    }

    @Test
    public void t1_comAtmosfera() {
        List<String> nomes = StreamsPlanetas.filtrarComAtmosfera(planetas);
        assertEquals(
            Arrays.asList("Vênus","Terra","Marte","Júpiter","Saturno","Urano","Netuno"),
            nomes
        );
    }

    @Test
    public void t2_diametroMaior() {
        assertEquals(
            Arrays.asList("Vênus","Terra","Júpiter","Saturno","Urano","Netuno"),
            StreamsPlanetas.nomesDiametroMaior10000(planetas)
        );
    }

    @Test
    public void t3_maisProximo() {
        assertEquals("Mercúrio",
            StreamsPlanetas.maisProximoDoSol(planetas));
    }

    @Test
    public void t4_massaMaior1000() {
        assertTrue(StreamsPlanetas.existeMassaMaiorQue1000(planetas));
    }

    @Test
    public void t5_massaTotal() {
        assertEquals(
            "2666.612",
            StreamsPlanetas.massaTotal(planetas)
        );
    }

    @Test
    public void t6_mediaDistancia() {
        assertEquals(
            "1249.25",
            StreamsPlanetas.mediaDistanciaSol(planetas)
        );
    }

    @Test
    public void t7_ordenarMassa() {
        List<String> nomes = StreamsPlanetas.ordenarPorMassaDecrescente(planetas);
        assertEquals(
            Arrays.asList("Júpiter","Saturno","Netuno","Urano","Terra","Vênus","Marte","Mercúrio"),
            nomes
        );
    }

    @Test
    public void t8_agruparAtmosfera() {
        Map<Boolean, List<Planeta>> mapa = StreamsPlanetas.agruparPorAtmosfera(planetas);
        List<String> sem = mapa.get(false)
                               .stream().map(Planeta::getNome)
                               .collect(Collectors.toList());
        List<String> com = mapa.get(true)
                               .stream().map(Planeta::getNome)
                               .collect(Collectors.toList());
        assertEquals(Arrays.asList("Mercúrio"), sem);
        assertEquals(7, com.size());
    }

    @Test
    public void t9_tresMaisDistantes() {
        assertEquals(
            Arrays.asList("Netuno","Urano","Saturno"),
            StreamsPlanetas.tresMaisDistantes(planetas)
        );
    }

    @Test
    public void t10_concatenarNomes() {
        assertEquals(
            "Mercúrio, Vênus, Terra, Marte, Júpiter, Saturno, Urano, Netuno",
            StreamsPlanetas.concatenarNomes(planetas)
        );
    }
}
