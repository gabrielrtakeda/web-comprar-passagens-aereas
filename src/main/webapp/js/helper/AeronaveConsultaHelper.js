window.consultarTableRowDataonlyPartial = null;

var AeronaveConsultaHelper = {
    appendTableRowsDataonly: function(response) {
        if (response.length > 0) {
            var tableBody = $('#aeronave-consultar-table-dataonly tbody').html('');
            $.each(response, function(i, aeronave) {
                if (window.consultarTableRowDataonlyPartial === null) {
                    $.ajax({
                        url: window.BASE_PATH + '/aeronave/partials/consultar-table-row-dataonly.jsp',
                        method: 'GET',
                        dataType: 'html',
                        success: function(partial) {
                            window.consultarTableRowDataonlyPartial = partial;
                            tableBody.append(
                                AeronaveConsultaHelper.assignVariables(aeronave)
                            );
                            $(window).trigger('after-aeronave-list-codigo');
                        },
                        error: AsynchronousRequestHandler.error
                    });
                } else {
                    tableBody.append(
                        AeronaveConsultaHelper.assignVariables(aeronave)
                    );
                    $(window).trigger('after-aeronave-list-codigo');
                }
            });
        }
    },

    assignVariables: function(aeronave) {
        return window.consultarTableRowDataonlyPartial
            .replace(new RegExp('{{id}}', 'g'), aeronave.id)
            .replace(new RegExp('{{codigo}}', 'g'), aeronave.codigo)
            .replace(new RegExp('{{nome}}', 'g'), aeronave.nome)
            .replace(new RegExp('{{aeronaveQuantidadeFileiras}}', 'g'),
                aeronave.quantidadeFileiras)
            .replace(new RegExp('{{aeronaveQuantidadeAssentosFileira}}', 'g'),
                aeronave.quantidadeAssentosFileira)
            .replace(
                new RegExp('{{aeronaveQuantidadeTotalPassageiros}}', 'g'),
                aeronave.quantidadeFileiras *
                aeronave.quantidadeAssentosFileira
            );
    }
};
