function traerInformacion(){
    $.ajax({
        url:"http://193.123.98.240/api/Reservation/all",
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
    myTable += '<th>' + "FECHA DE INICIO" + '</th>';
    myTable += '<th>' + "FECHA DE ENTREGA" + '</th>';
    myTable += '<th>' + "STATUS" + '</th>';
    myTable += '<th>' + "MOTO" + '</th>';
    myTable += '<th>' + "CLIENTE" + '</th>';
    myTable += '<th>' + "CALIFICACION" + '</th>';
    for (i = 0; i < items.length; i++) {
        myTable+="<tr>";
        myTable+="<td>"+items[i].idReservation+"</td>";
        myTable+="<td>"+items[i].startDate+"</td>";
        myTable+="<td>"+items[i].devolutionDate+"</td>";
        myTable+="<td>"+items[i].status+"</td>";
        myTable+="<td>"+items[i].motorbike+"</td>";
        myTable+="<td>"+items[i].client+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarInformacion(){
    let myData={
        idReservation:$("#idReservation").val(),
        startDate:$("#startDate").val(),
        devolutionDate:$("#devolutionDate").val(),
        motorbike:$("#motorbike").val(),
        client:$("#client").val(),
    };
    let datosJson=JSON.stringify(myData);
    $.ajax(
        'http://193.123.98.240/api/Reservation/save',
        {data:datosJson,
        type:"POST",
        datatype:"json",
        contentType: "application/json; charset=utf-8",

        statusCode : {
			201 :  function() {
                alert("Se ha guardado.");
                $("#idReservation").val(""),
                $("#startDate").val(""),
                $("#devolutionDate").val(""),
                $("#motorbike").val(""),
                $("#client").val(""),
                traerInformacion();
            }
        }
        });
}

