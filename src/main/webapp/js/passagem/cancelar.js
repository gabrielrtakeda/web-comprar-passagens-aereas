jQuery(function($) {

    $('#consultar-passagem').submit(passagem.consultar.get.request);
    $('form#cancelar-passagem').submit(passagem.delete.confirmation);

});

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
                passagem.consultar.get.partial.get();
                $(window).on(
                    'after-get-cancelar-passagem-consulta',
                    {response: response},
                    passagem.consultar.get.afterGetPartial
                );
            },
            afterGetPartial: function(e) {
                e.stopImmediatePropagation();
                sessionStorage.setItem(
                    'cancelarPassagemResponse',
                    JSON.stringify(e.data.response)
                );

                if (e.data.response.statusOperation === true) {
                    $('#dados-passagem').html(
                        passagem.consultar.get.partial.hydrate(
                            passagem.consultar.get.partial.html,
                            e.data.response
                        )
                    );
                    $('#id').val(e.data.response.id);
                } else
                    swal('Erro', e.data.response.successMessage, 'error');
            },


            partial: {
                path: '/passagem/partials/cancelar-dados-voo.jsp',
                html: null,
                get: function() {
                    if (passagem.consultar.get.partial.html === null)
                        AsynchronousRequestHandler.partial(
                            passagem.consultar.get.partial.path,
                            passagem.consultar.get.partial.callback
                        );
                    else
                        $(window).trigger('after-get-cancelar-passagem-consulta');
                },
                callback: function(responsePartial) {
                    passagem.consultar.get.partial.html = responsePartial;
                    $(window).trigger('after-get-cancelar-passagem-consulta');
                },
                hydrate: function(partial, data) {
                    return partial
                        .replace(new RegExp('{{aeronaveId}}', 'g'), data.voo.aeronave.id)
                        .replace(new RegExp('{{aeronaveCodigo}}', 'g'), data.voo.aeronave.codigo)
                        .replace(new RegExp('{{aeronaveNome}}', 'g'), data.voo.aeronave.nome)
                        .replace(new RegExp('{{aeronaveQuantidadeAssentosFileira}}', 'g'), data.voo.aeronave.quantidadeAssentosFileira)
                        .replace(new RegExp('{{aeronaveQuantidadeFileiras}}', 'g'), data.voo.aeronave.quantidadeFileiras)
                        .replace(new RegExp('{{aeronaveQuantidadeTotal}}', 'g'), data.voo.aeronave.quantidadeAssentosFileira * data.voo.aeronave.quantidadeFileiras)

                        .replace(new RegExp('{{destinoAeroportoId}}', 'g'), data.voo.destinoAeroporto.id)
                        .replace(new RegExp('{{destinoAeroportoNomeBrief}}', 'g'), data.voo.destinoAeroporto.nome.split(' - ')[0])
                        .replace(new RegExp('{{destinoAeroportoNome}}', 'g'), data.voo.destinoAeroporto.nome)

                        .replace(new RegExp('{{origemAeroportoId}}', 'g'), data.voo.origemAeroporto.id)
                        .replace(new RegExp('{{origemAeroportoNomeBrief}}', 'g'), data.voo.origemAeroporto.nome.split(' - ')[0])
                        .replace(new RegExp('{{origemAeroportoNome}}', 'g'), data.voo.origemAeroporto.nome)

                        .replace(new RegExp('{{passageiroDataNascimento}}', 'g'), data.passageiro.dataNascimento)
                        .replace(new RegExp('{{passageiroFormaTratamento}}', 'g'), data.passageiro.formaTratamento)
                        .replace(new RegExp('{{passageiroNome}}', 'g'), data.passageiro.nome)
                        .replace(new RegExp('{{passageiroSobrenome}}', 'g'), data.passageiro.sobrenome)
                        .replace(new RegExp('{{passageiroTipoPassageiro}}', 'g'), data.passageiro.tipoPassageiro)

                        .replace(new RegExp('{{passageiroResponsavelDataNascimento}}', 'g'), data.passageiroResponsavel.dataNascimento)
                        .replace(new RegExp('{{passageiroResponsavelDdd}}', 'g'), data.passageiroResponsavel.ddd)
                        .replace(new RegExp('{{passageiroResponsavelEmail}}', 'g'), data.passageiroResponsavel.email)
                        .replace(new RegExp('{{passageiroResponsavelFormaTratamento}}', 'g'), data.passageiroResponsavel.formaTratamento)
                        .replace(new RegExp('{{passageiroResponsavelNome}}', 'g'), data.passageiroResponsavel.nome)
                        .replace(new RegExp('{{passageiroResponsavelSobrenome}}', 'g'), data.passageiroResponsavel.sobrenome)
                        .replace(new RegExp('{{passageiroResponsavelTelefone}}', 'g'), data.passageiroResponsavel.telefone)
                        .replace(new RegExp('{{passageiroResponsavelTipoPassageiro}}', 'g'), data.passageiroResponsavel.tipoPassageiro)

                        .replace(new RegExp('{{vooEscalas}}', 'g'), data.voo.escalas)
                        .replace(new RegExp('{{vooDataHora}}', 'g'), date.format.mysql(data.voo.dataHora))
                        .replace(new RegExp('{{vooSituacao}}', 'g'), data.voo.situacao)
                        .replace(new RegExp('{{vooValor}}', 'g'), data.voo.valor)
                        .replace(new RegExp('{{vooValorText}}', 'g'), currency(data.voo.valor))
                        .replace(new RegExp('{{vooCodigo}}', 'g'), data.voo.codigo);
                }
            }
        }
    },

    delete: {
        data: null,

        confirmation: function(e) {
            e.preventDefault();
            passagem.delete.data = $(this).serializeArray();

            swal(
                passagem.delete.confirmAttributes,
                passagem.delete.confirmCallback
            );
        },
        confirmAttributes: {
            title: 'Você tem certeza?',
            text: 'Não será possível reverter esta ação. Deseja continuar com \
                    o cancelamento da passagem?',
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sim, continuar!",
            cancelButtonText: "Não, mudei de ideia!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
        confirmCallback: function(isConfirm) {
            if (isConfirm)
                passagem.delete.request();
            else
                swal('Revertido',
                    'O cancelamento da passagem foi interrompido',
                    'error');
        },
        responseOkAttributes: function(message) {
            return {
                title: 'Cancelado',
                text: message,
                type: 'success'
            }
        },
        responseOkCallback: function() {
            window.location = BASE_PATH + '/passagem/reembolso.jsp';
        },
        request: function() {
            console.log(passagem.delete.data);
            console.log(Serializer.serializePath(passagem.delete.data));
            AsynchronousRequestHandler.delete(
                Serializer.serializePath(passagem.delete.data),
                passagem.delete.response,
                '/api/passagem'
            );
        },
        response: function(response) {
            if (response.statusOperation === true)
                swal(
                    passagem.delete.responseOkAttributes(response.successMessage),
                    passagem.delete.responseOkCallback);
            else
                swal('Erro', response.errorMessage, 'error');
        }
    }
};
