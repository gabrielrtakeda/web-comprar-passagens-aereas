jQuery(function($) {
    initMaskedInputs();
    initDateTimePicker();

    $('form#consultar-aeronave').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.get(
            this,
            Serializer.serializePath($(this).serializeArray()),
            AeronaveConsultaHelper.appendTableRowsDataonly,
            '/api/aeronave/list'
        );
        $('#aeronave-id').val('');
    });

    $('#aeronave-consultar-table-dataonly').on('click', 'tbody tr', function(e) {
        e.preventDefault();
        RowDataExtractHelper.make(e, this, '#aeronave-id', 'id');
    });

    $('#cadastrar-voo').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.post(this, formAtualizarCallback);
    });

    $('#consultar-voo').submit(voo.consultar.getListByCodigo.request);
    $('#voo-consultar-result tbody').on('click', 'tr',
        voo.consultar.table.event.click);
    $('#alterar-voo').submit(voo.alterar.post.request);
    $('#voo-consultar-result tbody').on('click', '.voo-delete', voo.delete.request);
});

var voo = {
    consultar: {
        table: {
            event: {
                click: function(e) {
                    var self = this;
                    $.when(voo.alterar.scrollToAlterarForm())
                        .done(function() {
                            RowDataExtractHelper.assemble(e, self,
                                voo.consultar.getListByCodigo.deliverToForm);
                        });
                }
            }
        },

        getListByCodigo: {
            data: null,
            partial: {
                path: '/voo/partials/consultar-table-row.jsp',
                html: null
            },

            request: function(e) {
                e.preventDefault();
                AsynchronousRequestHandler.get(
                    this,
                    Serializer.serializePath($(this).serializeArray()),
                    voo.consultar.getListByCodigo.response,
                    '/api/voo/list'
                );
            },

            response: function(response) {
                console.log(response);
                voo.consultar.getListByCodigo.getPartial();
                voo.consultar.getListByCodigo.data = response;
                $('#voo-consultar-result tbody').html('');

                $(window).on('get-voo-consultar-partial', function(e) {
                    e.stopImmediatePropagation();
                    var voos = voo.consultar.getListByCodigo.data;

                    for (var vooData of voos) {
                        if (vooData.statusOperation === true) {
                            $('#voo-consultar-result tbody').append(
                                voo.consultar.getListByCodigo.hydrate(
                                    voo.consultar.getListByCodigo.partial.html,
                                    vooData
                                )
                            );
                        }
                    }
                    html5tooltips.refresh();
                });
            },

            hydrate: function(partial, data) {
                return partial
                    .replace(new RegExp('{{aeronaveCodigo}}', 'g'), data.aeronave.codigo)
                    .replace(new RegExp('{{aeronaveId}}', 'g'), data.aeronave.id)
                    .replace(new RegExp('{{aeronaveNome}}', 'g'), data.aeronave.nome)
                    .replace(new RegExp('{{codigo}}', 'g'), data.codigo)
                    .replace(new RegExp('{{dataHora}}', 'g'), date.format.mysql(data.dataHora))
                    .replace(new RegExp('{{destinoAeroporotId}}', 'g'), data.destinoAeroporto.id)
                    .replace(new RegExp('{{destinoAeroportoNomeBrief}}', 'g'), data.destinoAeroporto.nome.split(' - ')[0])
                    .replace(new RegExp('{{destinoAeroportoNome}}', 'g'), data.destinoAeroporto.nome)
                    .replace(new RegExp('{{escalas}}', 'g'), data.escalas)
                    .replace(new RegExp('{{id}}', 'g'), data.id)
                    .replace(new RegExp('{{origemAeroportoId}}', 'g'), data.origemAeroporto.id)
                    .replace(new RegExp('{{origemAeroportoNomeBrief}}', 'g'), data.origemAeroporto.nome.split(' - ')[0])
                    .replace(new RegExp('{{origemAeroportoNome}}', 'g'), data.origemAeroporto.nome)
                    .replace(new RegExp('{{situacao}}', 'g'), data.situacao)
                    .replace(new RegExp('{{valorText}}', 'g'), currency(data.valor))
                    .replace(new RegExp('{{valor}}', 'g'), data.valor);
            },

            deliverToForm: function(data) {
                $('#voo-id').val(data.id);
                $('#input-codigo-voo').val(data.codigo);
                $('#input-voo-situacao').val(data.situacao);
                $('#voo-cadastrar-datetimepicker').val(date.format.mysql(data.dataHora));
                $('#input-voo-escalas').val(data.escalas);
                $('#origem-aeroporto-list').val(data.origemAeroportoId);
                $('#destino-aeroporto-list').val(data.destinoAeroportoId);
                $('#voo-valor').val(data.valor);
                $('#input-codigo-aeronave').val(data.aeronaveCodigo);
                $('#consultar-aeronave').submit();

                $(window).on(
                    'after-aeronave-list-codigo',
                    {data: data},
                    voo.consultar.getListByCodigo.selectAeronaveRow
                );
            },

            selectAeronaveRow: function(e) {
                e.stopImmediatePropagation();

                var tableSelector = '#aeronave-consultar-table-dataonly';
                var aeronaveRowSelector = 'tr[data-id="{{aeronaveId}}"]';
                var aeronaveRow = $('{{table}} {{row}}'
                        .replace('{{table}}', tableSelector)
                        .replace('{{row}}', aeronaveRowSelector)
                        .replace('{{aeronaveId}}', e.data.data.aeronaveId)
                    );

                if (!aeronaveRow.hasClass('info')) aeronaveRow.click();
            },

            getPartial: function() {
                if (voo.consultar.getListByCodigo.partial.html === null)
                    AsynchronousRequestHandler.partial(
                        voo.consultar.getListByCodigo.partial.path,
                        function(html) {
                            console.log(html);
                            voo.consultar.getListByCodigo.partial.html = html;
                            $(window).trigger('get-voo-consultar-partial');
                        }
                    );
                else
                    $(window).trigger('get-voo-consultar-partial');
            }
        }
    },

    alterar: {
        scrollToAlterarForm: function() {
            var deferred = $.Deferred();
            $('#voo-alterar-container').removeClass('hide');
            $('body>article').animate({
                scrollTop: $('body>article').scrollTop()
                    + $('#voo-alterar-container').position().top
            }).promise().done(function() {
                deferred.resolve();
            });
            return deferred.promise();
        },

        post: {
            request: function(e) {
                e.preventDefault();
                AsynchronousRequestHandler.post(this, voo.alterar.post.response);
            },

            response: function(response) {
                if (response.statusOperation === true) {
                    sessionStorage.setItem('successMessage', response.successMessage);
                    goHome();
                } else
                    AlertHelper.initError(response.errorMessage);
            }
        }
    },

    delete: {
        request: function(e) {
            e.preventDefault();
            var data = $(this).closest('tr').data();
            var sure = confirm('Tem certeza que deseja deletar o vôo com \
                    origem de {{origemAeroportoNome}} para \
                    {{destinoAeroportoNome}} agendado na data de {{dataHora}}?'
                    .replace('{{origemAeroportoNome}}', data.origemAeroportoNome)
                    .replace('{{destinoAeroportoNome}}', data.destinoAeroportoNome)
                    .replace('{{dataHora}}', data.dataHora)
                );

            if (sure)
                AsynchronousRequestHandler.delete(
                    Serializer.serializePath([{ name: 'id', value: data.id }]),
                    voo.delete.response,
                    '/api/voo'
                );
        },

        response: function(response) {
            if (response.statusOperation === true) {
                AlertHelper.initSuccess(response.successMessage);
                $('#voo-consultar-result tbody')
                    .find('tr[data-id="{{id}}"]'.replace('{{id}}', response.id))
                    .remove();
            } else
                AlertHelper.initError(response.errorMessage);
        }
    }
};

var aeronave = {
    consultar: {
        getListByCodigo: {
            request: function(e) {
                e.preventDefault();
                AsynchronousRequestHandler.get(
                    this,
                    Serializer.serializePath($(this).serializeArray()),
                    function(response) {
                        console.log(response);
                    },
                    '/api/aeronave/list'
                );
            }
        }
    }
};

var formAtualizarCallback = function(response) {
    if (response.status === true) {
        sessionStorage.setItem('successMessage', 'Vôo cadastrado com sucesso!');
        goHome();
    } else
        AlertHelper.initError('Ops! Ocorreu um erro. Aguarde alguns momentos e \
            tento novamente.');
}

var initMaskedInputs = function() {
    $('#valor').maskNumber({decimal: '.', thousands: ''});
}

var initDateTimePicker = function() {
    $('#voo-cadastrar-datetimepicker')
        .datetimepicker({ format: 'YYYY-MM-DD HH:mm:ss' });
}
