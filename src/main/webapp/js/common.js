function DataHora() {
    var data = new Date();
    tempo.innerHTML = data;
    setTimeout("DataHora()", 1000)
}

function currency(price) {
    return 'R$ ' + $.number(price, 2, ',', '.');
}
