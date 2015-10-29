jQuery(function($) {

    $('#consultar-passagem').submit(passagem.consultar.get.request);
    $('#transferir-passagem tbody').on('click', 'tr', function(e) {
        e.preventDefault();
        RowDataExtractHelper.make(
            e, this,
            '#transferir-passagem input[name="vooId"]',
            'id'
        );
    });
    $('#transferir-passagem').submit(passagem.transferir.post.request);

});

window.dadosPassagemRasterizedPartial = null;
window.dadosPassagem = null;
var passagem = {
    consultar: {
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
                console.log(response);
                window.dadosPassagem = response;
                passagem.partial.get();
                $(window).on('get-dados-passagem-partial', function(e) {
                    e.stopImmediatePropagation();
                    $('#transferir-passagem .dados-passagem').html(
                        passagem.partial.hydrate(
                            window.dadosPassagemRasterizedPartial,
                            window.dadosPassagem
                        )
                    );
                    AsynchronousRequestHandler.get(
                        this,
                        Serializer.serializePath([
                            {
                                name: 'quantidadePassageiros',
                                value: 1
                            }, {
                                name: 'origemAeroportoId',
                                value: window.dadosPassagem.voo.origemAeroporto.id
                            }, {
                                name: 'destinoAeroportoId',
                                value: window.dadosPassagem.voo.destinoAeroporto.id
                            }, {
                                name: 'valor',
                                value: window.dadosPassagem.voo.valor
                            }
                        ]),
                        voo.consultar.get.response,
                        '/api/voo/list-valor'
                    );
                });
            }
        }
    },

    partial: {
        get: function() {
            if (window.dadosPassagemRasterizedPartial === null) {
                AsynchronousRequestHandler.partial(
                    '/passagem/partials/dados-passagem-rasterized.jsp',
                    function(partial) {
                        window.dadosPassagemRasterizedPartial = partial;
                        $(window).trigger('get-dados-passagem-partial');
                    }
                )
            } else
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
    },

    transferir: {
        post: {
            request: function(e) {
                e.preventDefault();
                $('#transferir-passagem input[name="id"]')
                    .val(window.dadosPassagem.id);

                AsynchronousRequestHandler
                    .post(this, passagem.transferir.post.response);
            },

            response: function(response) {
                console.log(response);
                if (response.statusOperation === true) {
                    sessionStorage.setItem('successMessage', 'Transferência de \
                        passagem efetuada com sucesso!');
                    goHome();
                }
                else if (response.errorMessage)
                    AlertHelper.initError(response.errorMessage);
                else
                    AlertHelper.initError('Ops! Ocorreu algum erro ao efetuar \
                        a transferência da passagem. Aguarde alguns instantes \
                        e tente novamente.');
            }
        }
    }
};

window.consultarTableRowDataOnlyPartial = null;
window.listConsultarVoo = null;
var voo = {
    consultar: {
        get: {
            response: function(response) {
                voo.partial.get();
                window.listConsultarVoo = response;

                $(window).on('get-consultar-table-row-dataonly', function(e) {
                    e.stopImmediatePropagation();

                    $('#consultar-result tbody').html('');
                    for (var vooData of window.listConsultarVoo) {
                        console.log(vooData);
                        $('#consultar-result tbody').append(
                            voo.partial.hydrate(
                                window.consultarTableRowDataOnlyPartial,
                                vooData
                            )
                        );
                    }
                    $(window).trigger('get-dados-voo-disponivel');
                });
            }
        }
    },

    partial: {
        get: function() {
            if (window.consultarTableRowDataOnlyPartial === null) {
                AsynchronousRequestHandler.partial(
                    '/voo/partials/consultar-table-row-dataonly.jsp',
                    function(partial) {
                        window.consultarTableRowDataOnlyPartial = partial;
                        $(window).trigger('get-consultar-table-row-dataonly');
                    }
                );
            } else
                $(window).trigger('get-consultar-table-row-dataonly');
        },

        hydrate: function(partial, data) {
            return partial
                .replace(new RegExp('{{id}}', 'g'), data.id)
                .replace(new RegExp('{{codigo}}', 'g'), data.codigo)
                .replace(new RegExp('{{aeronaveNome}}', 'g'), data.aeronave.nome)
                .replace(new RegExp('{{escalas}}', 'g'), data.escalas)
                .replace(new RegExp('{{dataHora}}', 'g'), data.dataHora)
                .replace(new RegExp('{{assentosDisponiveis}}', 'g'), data.assentosDisponiveis)
                .replace(new RegExp('{{situacao}}', 'g'), data.situacao)
                .replace(new RegExp('{{valor}}', 'g'), data.valor)
                .replace(new RegExp('{{valorText}}', 'g'), currency(data.valor));
        }
    }
};
