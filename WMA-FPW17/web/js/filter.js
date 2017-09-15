/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    // ogni volta che l'utente digita un carattere nel text field, 
    // chiamiamo la servlet Filter
    
    $("#ricerca").keyup(function(){
        // recupera la chiave di ricerca dall'input
        var str = $("#ricerca").val();
        
        // inviamo la richiesta al server in modo asincrono
        
        $.ajax({
            url: 'Filter',
            
            // in data ci vanno i parametri della GET/POST
            data: {
                q: str
            },
            
            success: function(data, state){
                // la richiesta è stata gestita correttamente (codici 200)
                $("#listaFilm").empty();
                for(var i in data){
                    var f = data[i];
                    console.log("<li><a href='FactorySecondoAccessoDB?id=" + f.id + ">" +
                        f.titolo + "</a></li>");
                    $("#listaFilm").append(
                        "<li><a href='FactorySecondoAccessoDB?id=" + f.id + "'>" +
                        f.titolo + "</a></li>"
                    );
                }
            },
            
            error: function(data, state){
                // la richiesta non è stata gestita correttamente
            }
        });
        
    });
});

