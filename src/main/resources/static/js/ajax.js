function obtenerUsuarios() {

	let resultados = document.getElementById("resultados");
	resultados.replaceChildren();

	fetch('/todos', { headers: { "Content-Type": "application/json; charset=utf-8" } })
		.then(res => res.json()) // parse response as JSON (can be res.text() for plain response)
		.then(response => {

			for (let usuario of response) {
				let li = document.createElement('li');
				li.textContent = usuario.nombre + " email:" + usuario.email;
				resultados.appendChild(li);
			}
		})
}


function limpiarTabla() {

	let resultados = document.getElementById("resultados");
	resultados.replaceChildren();
}

function creaUsuario() {

	if ($('#inputNombre').val() != "" && $('#inputEmail').val() != "") {

		fetch('/crear2', {
			headers: {
				'Content-type': 'application/json'
			},
			method: 'POST',
			body: JSON.stringify({ nombre: $('#inputNombre').val(), email: $('#inputEmail').val() })
		})
			.then(res => res.json())
			.then(data => {
				let resultados = document.getElementById("resultados");
				let li = document.createElement('li');
				li.textContent = data.nombre + " email:" + data.email;
				resultados.appendChild(li);
			}).catch(function(error) {

				$("#erroDiv").innerHtml('<div class="alert alert-dismissible alert-danger">' +
					'< button type = "button" class= "btn-close" data - bs - dismiss="alert" ></button >' +
					'<strong>Error!</strong> <a href="#" class="alert-link">'+
					error.messsage +'</a> Prueba otra vez</div > ');


				console.log(`Error: ${error.message}`);
			});
	}
}


document.addEventListener("DOMContentLoaded", function() {

	$("#registrar").click(creaUsuario);

	$("#refrescar").click(obtenerUsuarios);
	
	$("#limpiar").click(limpiarTabla);
	

});

