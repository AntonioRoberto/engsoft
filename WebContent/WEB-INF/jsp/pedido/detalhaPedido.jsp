
	Cliente: <td>${pedido.cliente }</td><br /> 
	Data: <td>${pedido.data }</td><br /> 
	Valor Total: <td>${pedido.calculaValorTotal() }</td><br /> <br />


<table>
	<thead>
		<tr>
			<th>Item</th>
			<th>Quantidade</th>
			<th>Unitario</th>
			<th>Total</th>
			
		</tr>
	</thead>
		<tbody>
		<c:forEach items="${pedido.getLista()}" var="item">
			<tr>
				<td>${item.getDescricao() }</td>
				<td>${item.getQuantidade() }</td>
				<td>${item.getValor()}</td>
				<td>${item.total()}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

