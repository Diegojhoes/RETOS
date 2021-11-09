function traerInformacion(){
    $.ajax({
        url:"http://193.123.98.240/api/Client/all",
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
    myTable += '<th>' + "ID" + '</th>';
    myTable += '<th>' + "NOMBRE" + '</th>';
    myTable += '<th>' + "CORREO ELECTRONICO" + '</th>';
    myTable += '<th>' + "EDAD" + '</th>';
    for (i = 0; i < items.length; i++) {
        myTable+="<tr>";
        myTable+="<td>"+items[i].idClient+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarInformacion(){
    let myData={
        idClient:$("#idClient").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
        password:$("#password").val(),
    };
    let datosJson=JSON.stringify(myData);
    $.ajax(
        'http://193.123.98.240/api/Client/save',
        {data:datosJson,
        type:"POST",
        datatype:"json",
        contentType: "application/json; charset=utf-8",

        statusCode : {
			201 :  function() {
                alert("Se ha guardado.");
                $("#idClient").val(""),
                $("#name").val(""),
                $("#email").val(""),
                $("#age").val(""),
                $("#password").val(""),
                traerInformacion();
            }
        }
        });
}

