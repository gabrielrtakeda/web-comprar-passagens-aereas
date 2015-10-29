var FormaPagamentoModel = function() {

    this.constructor = function() {
        this.initMask();
    }

    this.initFormaPagamento = function(e) {
        e.preventDefault();
        var ulCurrent = $(this).closest('h4').next('ul');
        var container = $('.forma-pagamento-selection');
        var article = $('body>article');

        if (ulCurrent.hasClass('hide')) {
            container.closest('h4').next('ul').addClass('hide');
            ulCurrent.removeClass('hide');
        } else
            ulCurrent.addClass('hide');

        article.animate({
            scrollTop: article.scrollTop() + container.position().top
        })
        $('.dados-pagamento, #credito, #debito').addClass('hide');
    };

    this.initDadosPagamento = function(e) {
        e.preventDefault();
        var data = $(this).data();
        var bandeiraBanco = $(this).val();

        $('.dados-pagamento').removeClass('hide');

        if (data.type == 'credito') {
            $('#credito').removeClass('hide');
            $('body>article').animate({
                scrollTop: $('body>article').scrollTop()
                    + $('#credito').position().top
            })
            $('#credito input[name="bandeira"]').val(bandeiraBanco);

        } else if (data.type == 'debito') {
            $('#debito').removeClass('hide');
            $('body>article').animate({
                scrollTop: $('body>article').scrollTop()
                    + $('#debito').position().top
            })
            $('#debito input[name="banco"]').val(bandeiraBanco);
        }
    };

    this.credito = {
        put: {
            request: function(e) {
                e.preventDefault();
                AsynchronousRequestHandler.put(
                    this,
                    $(this).serializeObject(),
                    new FormaPagamentoModel().credito.put.response
                );
            },

            response: function(response) {
                if (response.statusOperation === true) {
                    sessionStorage.setItem('successMessage', 'Compra efetuada \
                        com sucesso! Obrigado por utilizar nossos serviços.');
                    window.location = BASE_PATH + '/home.jsp';
                } else
                    AlertHelper.initError('Ocorreu algum erro na requisição. \
                        Aguarde alguns instantes e tente novamente.');
            }
        }
    };

    this.debito = {
        put: {
            request: function(e) {
                e.preventDefault()
                AsynchronousRequestHandler.put(
                    this,
                    $(this).serializeObject(),
                    new FormaPagamentoModel().debito.put.response
                );
            },

            response: function(response) {
                if (response.statusOperation === true) {
                    sessionStorage.setItem('successMessage', 'Compra efetuada \
                        com sucesso! Obrigado por utilizar nossos serviços.');
                    window.location = BASE_PATH + '/home.jsp';
                } else
                    AlertHelper.initError('Ocorreu algum erro na requisição. \
                        Aguarde alguns instantes e tente novamente.');
            }
        }
    };

    this.initMask = function() {
        $('#dados-pagamento-credito input[name="cpf"]').mask('999.999.999-99');
        $('#dados-pagamento-credito input[name="numeroCartao"]').mask('9999 9999 9999 9999');
        $('#dados-pagamento-credito input[name="codigoSeguranca"]').mask('999');

        $('#dados-pagamento-debito input[name="agencia"]').mask('9999');
        $('#dados-pagamento-debito input[name="contaCorrente"]').mask('99999-9');
        $('#dados-pagamento-debito input[name="cpf"]').mask('999.999.999-99');
        $('#dados-pagamento-debito input[name="ddd"]').mask('999');
        $('#dados-pagamento-debito input[name="telefone"]').mask('9999-99999');
    };

    this.constructor();
}
