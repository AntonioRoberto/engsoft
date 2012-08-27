<form action="adicionaItem">
	<fieldset>
		<legend>Adicionar Item</legend>
		
		<label for="nome">Descricao:</label>
		<input id="nome" type="text" name="item.descricao"/>
		
		<label for="descricao">Quantidade:</label>
		<textarea id="descricao" name="item.quantidade"></textarea>
		
		<label for="descricao">Valor:</label>
		<textarea id="descricao" name="item.valor"></textarea>
				
		<button type="submit">Adicionar Itens</button>
	</fieldset>
</form>

				<td><a href="remove?id=${pedido.id}">Adicionar mais um item</a></td>
				<td><a href="detalhes?id=${pedido.id}">Enviar pedido</a></td>