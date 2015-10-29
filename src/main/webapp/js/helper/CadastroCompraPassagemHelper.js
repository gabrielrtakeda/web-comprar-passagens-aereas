var CadastroCompraPassagemHelper = {
    put: function(response) {
        sessionStorage.setItem('compra', JSON.stringify(response));
        console.log(response);
        window.location = BASE_PATH + '/passagem/pagamento.jsp';
    }
};
