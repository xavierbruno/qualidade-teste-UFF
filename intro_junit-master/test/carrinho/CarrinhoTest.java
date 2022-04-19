package carrinho;

import produto.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@DisplayName("teste da classe carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}

    // Adicionando item ao carrinho

    @DisplayName("Deve adicionar item ao carrinho")
	@Test
	public void testAdicionarItemAoCarrinho() {
        int qtdAntes = carrinho.getQtdeItems();

        Produto prod = new Produto("teste", 100.00);

		carrinho.addItem(prod);

        int qtdDepois = carrinho.getQtdeItems();

        Assertions.assertEquals(0, qtdAntes);	
		Assertions.assertEquals(1, qtdDepois);	
	}

        // Verificando se é vazia

        @DisplayName("Deve remover todos itens do carrinho")
        @Test
        public void testZerarCarrinho() {
            Produto prod = new Produto("teste", 100.00);
            Produto prod2 = new Produto("teste2", 100.00);
            Produto prod3 = new Produto("teste3", 100.00);
    
            carrinho.addItem(prod);
            carrinho.addItem(prod2);
            carrinho.addItem(prod3);
    
            int qtdAntes = carrinho.getQtdeItems();
            carrinho.esvazia();
            int qtdDepois = carrinho.getQtdeItems();
    
            Assertions.assertEquals(3, qtdAntes);	
            Assertions.assertEquals(0, qtdDepois);	
        }
    
    // Removendo item do carribgo

    @DisplayName("Deve remover item do carrinho")
	@Test
    public void testRemoveItemDoCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 100.00);

		carrinho.addItem(prod);
        carrinho.addItem(prod2);

        int qtdAntes = carrinho.getQtdeItems();

        try {
            carrinho.removeItem(prod);
        } catch(ProdutoNaoEncontradoException e) {
            fail("Exceção lançada");
        }

        int qtdDepois = carrinho.getQtdeItems();

        Assertions.assertEquals(2, qtdAntes);	
		Assertions.assertEquals(1, qtdDepois);	
	}

    @DisplayName("Deve jogar erro se item não existir no carrinho")
	@Test
    public void testRemoveProdutoQueNaoEstaNoCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 100.00);

		carrinho.addItem(prod);

        try {
            carrinho.removeItem(prod2);
            fail("Exceção não lançada");
        } catch(ProdutoNaoEncontradoException e) {
            assertThat(e, instanceOf(ProdutoNaoEncontradoException.class));
        }
	}

    // Pegando Valor Total

    @DisplayName("Deve remover todos itens do carrinho")
	@Test
    public void testPegarValorTotalCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 110.00);
        Produto prod3 = new Produto("teste3", 120.00);

		carrinho.addItem(prod);
        carrinho.addItem(prod2);
        carrinho.addItem(prod3);

        double total = carrinho.getValorTotal();

        Assertions.assertEquals(330.00, total);	
	}
    
}