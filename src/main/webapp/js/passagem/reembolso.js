jQuery(function($) {

    var formaPagamentoModel = new FormaPagamentoModel();
    $('.forma-pagamento-selection').click(formaPagamentoModel.initFormaPagamento);
    $('.forma-pagamento input[type="radio"]').change(formaPagamentoModel.initDadosPagamento);
    $('#dados-pagamento-debito').submit(reembolso.put.request);

});

var reembolso = {
    put: {
        request: function(e) {
            e.preventDefault();
            var data = $(this).serializeObject();
            var passagem = JSON.parse(sessionStorage.getItem('cancelarPassagemResponse'));
            data.voo = passagem.voo;
            data.valor = passagem.valor;

            AsynchronousRequestHandler.put(this, data, reembolso.put.response);
        },
        response: function(response) {
            if (response.statusOperation === true)
                swal(
                    reembolso.put.responseOkAttributes(response.successMessage),
                    reembolso.put.responseOkCallback);
            else
                swal('Erro', response.errorMessage, 'error');
        },
        responseOkAttributes: function(message) {
            return {
                title: 'Reembolso efetuado!',
                text: message,
                type: 'success'
            }
        },
        responseOkCallback: function() {
            goHome();
        },
    }
};
