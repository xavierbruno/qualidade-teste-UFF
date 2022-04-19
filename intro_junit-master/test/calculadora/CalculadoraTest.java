package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
// Somando
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int res = calc.soma(4, 5);		
		Assertions.assertEquals(9, res);	
	}


	@DisplayName("Testa a soma de dois números negativos")
	@Test 
	public void testSomaDoisNumerosNegativos() {
		int res = calc.soma(-4, -5);
		Assertions.assertEquals(-9, res);
	}

	@DisplayName("Testa a soma de um número negativo com um positivo")
	@Test 
	public void testSomaUmNumeroNegativoComUmPositivo() {
		int res = calc.soma(-4, 5);
		Assertions.assertEquals(1, res);
	}

	@DisplayName("Testa a soma de um número positivo com um negativo")
	@Test 
	public void testSomaUmNumeroPositivoComUmNegativo() {
		int res = calc.soma(4, -5);
		Assertions.assertEquals(-1, res);
	}

	// Subtraindo

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int res = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, res);		
	}

	@DisplayName("Testa a subtração de dois números negativos")
	@Test 
	public void testSubtracaoDoisNumerosNegativos() {
		int res = calc.subtracao(-4, -5);
		Assertions.assertEquals(1, res);
	}

	@DisplayName("Testa a subtração de um número negativo com um positivo")
	@Test 
	public void testSubtracaoUmNumeroNegativoComUmPositivo() {
		int res = calc.subtracao(-4, 5);
		Assertions.assertEquals(-9, res);
	}

	@DisplayName("Testa a subtração de um número positivo com um negativo")
	@Test 
	public void testSubtracaoUmNumeroPositivoComUmNegativo() {
		int res = calc.subtracao(4, -5);
		Assertions.assertEquals(9, res);
	}

	// Dividindo
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@DisplayName("Testa a divisao de dois números negativos")
	@Test 
	public void testDivisaoDoisNumerosNegativos() {
		int res = calc.divisao(-40, -5);
		Assertions.assertEquals(8, res);
	}

	@DisplayName("Testa a divisao de um número negativo com um positivo")
	@Test 
	public void testDivisaoUmNumeroNegativoComUmPositivo() {
		int res = calc.divisao(-40, 5);
		Assertions.assertEquals(-8, res);
	}

	@DisplayName("Testa a divisao de um número positivo com um negativo")
	@Test 
	public void testDivisaoUmNumeroPositivoComUmNegativo() {
		int res = calc.divisao(40, -5);
		Assertions.assertEquals(-8, res);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	// Multiplicando

	@DisplayName("Testa a multiplicação de dois números positivos")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int res = calc.multiplicacao(8, 5);
		Assertions.assertEquals(40, res);
	}

	@DisplayName("Testa a multiplicação de dois números negativos")
	@Test 
	public void testMultiplicacaoDoisNumerosNegativos() {
		int res = calc.multiplicacao(-8, -5);
		Assertions.assertEquals(40, res);
	}

	@DisplayName("Testa a multiplicação de um número negativo com um positivo")
	@Test 
	public void testMultiplicacaoUmNumeroNegativoComUmPositivo() {
		int res = calc.multiplicacao(-8, 5);
		Assertions.assertEquals(-40, res);
	}

	@DisplayName("Testa a multiplicação de um número positivo com um negativo")
	@Test 
	public void testMultiplicacaoUmNumeroPositivoComUmNegativo() {
		int res = calc.multiplicacao(8, -5);
		Assertions.assertEquals(-40, res);
	}

	// Fazendo Somatória

	@DisplayName("Testa a somatoria de um número positivo")
	@Test 
	public void testSomatorioUmNumeroPositivo() {
		int res = calc.somatoria(8);
		Assertions.assertEquals(36, res);
	}

	@DisplayName("Testa a somatoria de um número negativo")
	@Test 
	public void testSomatorioUmNumeroNegativo() {
		int res = calc.somatoria(-8);
		Assertions.assertEquals(0, res);
	}

	// Verificando se é positivo

	@DisplayName("Testa se número é positivo de um número positvo")
	@Test 
	public void testEhPositivoDeNumeroPositivo() {
		boolean res = calc.ehPositivo(8);
		Assertions.assertEquals(true, res);
	}

	@DisplayName("Testa se número é positivo de um número negativo")
	@Test 
	public void testEhPositivoDeNumeroNegativo() {
		boolean res = calc.ehPositivo(-8);
		Assertions.assertEquals(false, res);
	}

	@DisplayName("Testa se número é positivo de zero")
	@Test 
	public void testEhPositivoDeZero() {
		boolean res = calc.ehPositivo(0);
		Assertions.assertEquals(true, res);
	}

	// Comparando

	@DisplayName("Compara dois números iguais")
	@Test 
	public void testComparaDoisIguais() {
		int res = calc.compara(8,8);
		Assertions.assertEquals(0, res);
	}

	@DisplayName("Compara com um número maior")
	@Test 
	public void testComparaPrimeiroMenor() {
		int res = calc.compara(1,8);
		Assertions.assertEquals(-1, res);
	}

	@DisplayName("Compara com um número menor")
	@Test 
	public void testComparaPrimeiroMaior() {
		int res = calc.compara(8,1);
		Assertions.assertEquals(1, res);
	}

}
