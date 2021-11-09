function traerInformacion(){
    $.ajax({
        url:"http://193.123.98.240/api/Motorbike/all",
        type:"GET",
        datatype:"JSON",
        contentType: "application/json; charset=utf-8",

        success:function(respuesta){
            console.log(respuesta);
            $("#resultado").empty();
            pintarRespuesta(respuesta);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema:'+ status);
        }
    });
}

function pintarRespuesta(items){
    let myTable="<table>";
    myTable += '<th>' + "MARCA" + '</th>';
    myTable += '<th>' + "NOMBRE" + '</th>';
    myTable += '<th>' + "AÑO" + '</th>';
    myTable += '<th>' + "DESCRIPCIÓN" + '</th>';
    myTable += '<th>' + "CATEGORIA" + '</th>';
    for (i = 0; i < items.length; i++) {
        myTable+="<tr>";
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].year+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        myTable+="<td>"+items[i].category.name+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
    pintarSelect();
}

function guardarInformacion(){
    let selected = $("#cat").children(":selected").attr("value");
	if (selected.length > 0) {
    let myData={
        id:$("#id").val(),
        brand:$("#brand").val(),
        name:$("#name").val(),
        year:$("#year").val(),
        description:$("#description").val(),
        category:{
            id: selected
        }
    };
    let datosJson=JSON.stringify(myData);
    $.ajax(
        'http://193.123.98.240/api/Motorbike/save',
        {data:datosJson,
        type:"POST",
        datatype:"json",
        contentType: "application/json; charset=utf-8",

        statusCode : {
			201 :  function() {
                alert("Se ha guardado.");
                $("#id").val(""),
                $("#brand").val(""),
                $("#name").val(""),
                $("#year").val(""),
                $("#description").val(""),
                $("#cat").val(""),
                traerInformacion();
            }
        }
        });
    }
    else{
		alert('Debe escoger categoria');
    }
}

function pintarSelect(){
	$.ajax({
    url : 'http://193.123.98.240/api/Category/all',
    type : 'GET',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",

    success : function(respuesta) {
		console.log(respuesta);
		$("#cat").empty();
		miSelect='<option id="" >Seleccione...</option>';
		for (i=0; i<respuesta.length; i++){
	        miSelect += '<option value='+ respuesta[i].id+ '>'+respuesta[i].name+'</option>';
		}
	    $("#cat").append(miSelect);
	},
    error : function(xhr, status) {
        alert('ha sucedido un problema:'+ status);
    }
});

}

function editarInformacion() {
    let myData = {
        brand: $("#brand").val(),
        name: $("#name").val(),
        year: $("#year").val(),
        description:$("#description").val(),
        cat: $("#cat").val(),
    };
    console.log(myData);
    let dataTosend = JSON.stringify(myData);
    $.ajax({
        url: "http://193.123.98.240/api/Motorbike/update",
        type: "PUT",
        data: dataTosend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function (respuesta) {
            $("#resultado").empty();
            $("#brand").val("");
            $("#name").val("");
            $("#year").val("");
            $("#description ").val("");
            $("#cat").val("");
            traerInformacion();
            alert("se ha Actualizado")

        }
    });

}
