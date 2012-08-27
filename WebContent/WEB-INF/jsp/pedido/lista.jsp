<table>
	<thead>
		<tr>
			<th>Cliente</th>
			<th>Data</th>
			<th>Qtd de itens</th>
			<th>Valor Total</th>
			
		</tr>
	</thead>
		<tbody>
		<c:forEach items="${pedidoList}" var="pedido">
			<tr>
				<td>${pedido.cliente }</td>
				<td>${pedido.data }</td>
				<td>${pedido.quantidadeItens()}</td>
				<td>${pedido.calculaValorTotal()}</td>
				
				<td><a href="remove?id=${pedido.id}">Remover</a></td>
				<td><a href="detalhes?id=${pedido.id}">Detalhes</a></td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
