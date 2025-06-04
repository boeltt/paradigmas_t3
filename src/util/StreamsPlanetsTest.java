package util;

import entidades.Planeta;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPlanetsTest {

	private static List<Planeta> planetas;

	// esse @ eu não sei exatamente o porque dele, mas a lib dos testes exige
	@BeforeClass
	public static void setup() {
		planetas = Arrays.asList(new Planeta("Mercúrio", 0.33, 4879, 58, false),
				new Planeta("Vênus", 4.87, 12104, 108, true), new Planeta("Terra", 5.97, 12756, 150, true),
				new Planeta("Marte", 0.642, 6792, 228, true), new Planeta("Júpiter", 1898, 142984, 778, true),
				new Planeta("Saturno", 568, 120536, 1430, true), new Planeta("Urano", 86.8, 51118, 2870, true),
				new Planeta("Netuno", 102, 49528, 4490, true));
	}

	// Aqui nos testes não tem nada muito de mais, no geral é enviar os objetos e
	// tratar eles pra fazer as comparações aqui mesmo, pelo princípio da única
	// responsabilidade
	// Não fiquei instanciando objetos de mais aqui tb, tentei minimizar isso por
	// boa prática mesmo

	@Test
	public void t1_comAtmosfera() {
		assertEquals(Arrays.asList("Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno"), StreamsPlanetas
				.filtrarComAtmosfera(planetas).stream().map(Planeta::getNome).collect(Collectors.toList()));
	}

	@Test
	public void t2_diametroMaior() {
		assertEquals(Arrays.asList("Vênus", "Terra", "Júpiter", "Saturno", "Urano", "Netuno"), StreamsPlanetas
				.diametroMaior10000(planetas).stream().map(Planeta::getNome).collect(Collectors.toList()));
	}

	@Test
	public void t3_maisProximo() {
		assertEquals("Mercúrio", StreamsPlanetas.maisProximoDoSol(planetas).getNome());
	}

	@Test
	public void t4_massaMaior1000() {
		assertTrue(StreamsPlanetas.existeMassaMaiorQue1000(planetas));
	}

	@Test
	public void t5_massaTotal() {
		assertEquals(2666.612, StreamsPlanetas.massaTotal(planetas), 0.001);
	}

	@Test
	public void t6_mediaDistancia() {
		assertEquals(1264.0, StreamsPlanetas.mediaDistanciaSol(planetas), 0.001);
	}

	@Test
	public void t7_ordenarMassa() {
		List<String> nomes = StreamsPlanetas.ordenarPorMassaDecrescente(planetas).stream().map(Planeta::getNome)
				.collect(Collectors.toList());
		assertEquals(Arrays.asList("Júpiter", "Saturno", "Netuno", "Urano", "Terra", "Vênus", "Marte", "Mercúrio"),
				nomes);
	}

	// Aqui eu tive que instanciar o mapa, não sei se teria como fazer sem ele, não consegui. As listas eu deixei no próprio teste porque a strem tem o .toList de qqr forma
	@Test
	public void t8_agruparAtmosfera() {
		Map<Boolean, List<Planeta>> mapa = StreamsPlanetas.agruparPorAtmosfera(planetas);
		assertEquals(Arrays.asList("Mercúrio"), mapa.get(false).stream().map(Planeta::getNome).collect(Collectors.toList()));
		assertEquals(7, mapa.get(true).stream().map(Planeta::getNome).collect(Collectors.toList()).size());
	}

	@Test
	public void t9_tresMaisDistantes() {
		assertEquals(Arrays.asList("Netuno", "Urano", "Saturno"), StreamsPlanetas.tresMaisDistantes(planetas).stream()
				.map(Planeta::getNome).collect(Collectors.toList()));
	}

	// esse joining serve pra concatenar os returns e organizar com a ,
	@Test
	public void t10_concatenarNomes() {
		assertEquals("Mercúrio, Vênus, Terra, Marte, Júpiter, Saturno, Urano, Netuno", StreamsPlanetas
				.concatenarNomes(planetas).stream().map(Planeta::getNome).collect(Collectors.joining(", ")));
	}
}
