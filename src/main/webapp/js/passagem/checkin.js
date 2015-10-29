jQuery(function($) {

    $('form#consultar-passagem').submit(passagem.consultar.get.request);

});

var passagem = {
    consultar: {
        data: null,
        get: {
            request: function(e) {
                e.preventDefault();
                AsynchronousRequestHandler.get(
                    this,
                    Serializer.serializePath($(this).serializeArray()),
                    passagem.consultar.get.response,
                    '/api/passagem/bilhete'
                );
            },
            response: function(response) {
                passagem.consultar.get.data = response;
                passagem.consultar.get.partial.get();
                console.log(passagem.consultar.get.data);

                if (response.statusOperation === true)
                    $(window).on(
                        'get-dados-passagem-partial',
                        passagem.consultar.get.onGetDadosPassagemPartial
                    );
                else
                    passagem.consultar.get.responseError(response);
            },
            responseError: function(response) {
                $(window).unbind('get-dados-passagem-partial');
                swal('Erro', response.errorMessage, 'error');
            },
            onGetDadosPassagemPartial: function(e) {
                // e.stopImmediatePropagation();
                // $(window).unbind('get-dados-passagem-partial');
                console.log(passagem.consultar.get.data);
                $('.dados-passagem .content').html(
                    passagem.consultar.get.partial.hydrate(
                        passagem.consultar.get.partial.html,
                        passagem.consultar.get.data
                    )
                );
            },

            partial: {
                path: '/passagem/partials/dados-passagem-rasterized.jsp',
                html: null,
                get: function() {
                    if (passagem.consultar.get.partial.html === null) {
                        AsynchronousRequestHandler.partial(
                            passagem.consultar.get.partial.path,
                            passagem.consultar.get.partial.response
                        )
                    } else
                        $(window).trigger('get-dados-passagem-partial');
                },
                response: function(partial) {
                    passagem.consultar.get.partial.html = partial;
                    $(window).trigger('get-dados-passagem-partial');
                },

                hydrate: function(partial, data) {
                    return partial
                        .replace(new RegExp('{{id}}'), data.id)
                        .replace(new RegExp(
                            '{{origemAeroportoNome}}'),
                            data.voo.origemAeroporto.nome
                        )
                        .replace(new RegExp(
                            '{{destinoAeroportoNome}}'),
                            data.voo.destinoAeroporto.nome
                        )
                        .replace(new RegExp(
                            '{{tipoPassageiro}}'),
                            data.passageiro.tipoPassageiro
                        )
                        .replace(new RegExp(
                            '{{formaTratamento}}'),
                            data.passageiro.formaTratamento
                        )
                        .replace(new RegExp(
                            '{{nome}}'),
                            data.passageiro.nome
                        )
                        .replace(new RegExp(
                            '{{sobrenome}}'),
                            data.passageiro.sobrenome
                        )
                        .replace(new RegExp(
                            '{{formaTratamentoPassageiroResponsavel}}'),
                            data.passageiroResponsavel.formaTratamento
                        )
                        .replace(new RegExp(
                            '{{nomePassageiroResponsavel}}'),
                            data.passageiroResponsavel.nome
                        )
                        .replace(new RegExp(
                            '{{sobrenomePassageiroResponsavel}}'),
                            data.passageiroResponsavel.sobrenome
                        );
                }
            }
        }
    },
}
