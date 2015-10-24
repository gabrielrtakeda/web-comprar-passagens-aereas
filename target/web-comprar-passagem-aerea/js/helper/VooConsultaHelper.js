window.vooConsultaTableRowDataonlyPartial = null;

var VooConsultaHelper = {
    appendTableRowsDataonly: function(response) {
        console.log(response);
        if (response.length > 0) {
            var tableBody = $('#consultar-voo #consultar-result tbody').html('');
            $.each(response, function(i, aeronave) {
                if (window.vooConsultaTableRowDataonlyPartial === null) {
                    $.ajax({
                        url: window.BASE_PATH + '/voo/partials/consultar-table-row-dataonly.html',
                        method: 'GET',
                        dataType: 'html',
                        success: function(partial) {
                            window.vooConsultaTableRowDataonlyPartial = partial;
                            tableBody.append(
                                VooConsultaHelper.assignVariables(aeronave)
                            );
                        },
                        error: AsynchronousRequestHandler.error
                    });
                } else {
                    tableBody.append(
                        VooConsultaHelper.assignVariables(aeronave)
                    );
                }
            });
        }
    },

    assignVariables: function(aeronave) {
        return window.vooConsultaTableRowDataonlyPartial
            .replace(new RegExp('{{id}}', 'g'), aeronave.id)
            .replace(new RegExp('{{codigo}}', 'g'), aeronave.codigo)
            .replace(new RegExp('{{aeronaveNome}}', 'g'), aeronave.aeronaveNome)
            .replace(new RegExp('{{escalas}}', 'g'), aeronave.escalas)
            .replace(new RegExp('{{dataHora}}', 'g'), aeronave.dataHora)
            .replace(new RegExp('{{assentosDisponiveis}}', 'g'), aeronave.assentosDisponiveis)
            .replace(new RegExp('{{situacao}}', 'g'), aeronave.situacao)
            .replace(new RegExp('{{valor}}', 'g'), currency(aeronave.valor));
    },

    initDateTimePicker: function() {
        $('#voo-consultar-datetimepicker')
            .datetimepicker({ format: 'YYYY-MM-DD HH:mm:ss' });
    }
};
