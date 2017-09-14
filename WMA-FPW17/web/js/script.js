/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

x = {}; // è un oggetto

x = 5; // ora la stessa variabile è un intero. 


y = {}; // nuovo oggetto
y.nome = "Davide";
y.cognome = "Spano"; // i campi di un oggetto si costruiscono dinamicamente 

z = []; // vettore indicizzato per posizione

z[0] = "Ciccio";
z[1] = 21;
z[2] = y;

z[2].nome;

add = function(x, y){
    return x + y;
};

z[3] = add;

somma = z[3](1,3);


// tre sintassi equivalenti
rettangolo = {
    latoA: 3,
    latoB: 4,
    
    perimetro : function(){
        return 2* this.latoA + 2 *this.latoB;
    }
};


rettangolo = {};
rettangolo.latoA = 3;
rettangolo.latoB = 4;
rettangolo.perimetro = function(){
    return 2* this.latoA + 2 *this.latoB;
};


rettangolo = {};
rettangolo['latoA'] = 3;
rettangolo['latoB'] = 4;
rettangolo['perimetro'] = function(){
    return 2* this.latoA + 2 *this.latoB;
};


rettangolo2 ={
    latoA: 5,
    latoB :7
};

rettangolo2.testPerimetro = rettangolo.perimetro;

function Rectangle(){
    var latoA = 0;
    var latoB = 1;
    
    this.setLatoA = function(x){
        latoA = x;
    };
    
    this.getLatoA = function(){
        return latoA;  
    };
    
};

primoRettangolo = new Rectangle();
secondoRettangolo = new Rectangle();

primoRettangolo.setLatoA(5);
secondoRettangolo.setLatoA(5);
secondoRettangolo.getLatoA = function(){
    return 10;
 };
 
 if(primoRettangolo.getLatoA() == secondoRettangolo.getLatoA()){
     
 }


