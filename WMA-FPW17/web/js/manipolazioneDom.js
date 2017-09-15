/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function clickSulLink(e){
    // blocca la navigazione di default al click del link
    e.preventDefault();
    
    // riceve una rappresentazione ad oggetto javascript dell'elemento con
    // identificatore liDaSelezionare
    var li = document.getElementById("liDaSelezionare");
    
    // in style sono presenti tutti gli stili CSS, che possono essere modificati
    li.style.backgroundColor = "red";
    
    
    document.location = "http://www.google.it";
}

window.onload = function(e){
    var link = document.getElementById("clickLink");
    link.onclick = clickSulLink;
};