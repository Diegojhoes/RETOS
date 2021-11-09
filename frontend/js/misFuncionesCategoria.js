function traerInformacion(){
    $.ajax({
        url:"http://193.123.98.240/api/Category/all",
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
    myTable += '<th>' + "NOMBRE" + '</th>';
    myTable += '<th>' + "DESCRIPCIÓN" + '</th>';
    myTable += '<th>' + "MOTOCICLETA" + '</th>';
    myTable += '<th>' + "MARCA" + '</th>';
    myTable += '<th>' + "DESCRIPCIÓN" + '</th>';
    for (i = 0; i < items.length; i++) {
        myTable+="<tr>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].description+"</td>";
        for (j=0; j<items[i].motorbikes.length; j++) {
            if(j>=1){
                myTable+="<tr>";
                myTable+="<td>"+items[i].name+"</td>";
                myTable+="<td>"+items[i].description+"</td>";
            }
            myTable+="<td>"+items[i].motorbikes[j].name+"</td>";
            myTable+="<td>"+items[i].motorbikes[j].brand+"</td>";
            myTable+="<td>"+items[i].motorbikes[j].description+"</td>";
        }
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarInformacion(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        description:$("#description").val(),
    };
    let datosJson=JSON.stringify(myData);
    $.ajax(
        'http://193.123.98.240/api/Category/save',
        {data:datosJson,
        type:"POST",
        datatype:"json",
        contentType: "application/json; charset=utf-8",

        statusCode : {
			201 :  function() {
                alert("Se ha guardado.");
                $("#id").val(""),
                $("#name").val(""),
                $("#description").val(""),
                traerInformacion();
            }
        }
        });
}

