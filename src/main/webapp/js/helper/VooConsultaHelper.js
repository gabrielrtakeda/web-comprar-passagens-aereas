window.vooConsultaTableRowDataonlyPartial = null;

var VooConsultaHelper = {
    appendTableRowsDataonly: function(response) {
        console.log(response);
        if (response.length > 0) {
            var tableBody = $('#consultar-voo #consultar-result tbody').html('');
            $.each(response, function(i, voo) {
                if (window.vooConsultaTableRowDataonlyPartial === null) {
                    $.ajax({
                        url: window.BASE_PATH + '/voo/partials/consultar-table-row-dataonly.jsp',
                        method: 'GET',
                        dataType: 'html',
                        success: function(partial) {
                            window.vooConsultaTableRowDataonlyPartial = partial;
                            tableBody.append(
                                VooConsultaHelper.assignVariables(voo)
                            );
                        },
                        error: AsynchronousRequestHandler.error
                    });
                } else {
                    tableBody.append(
                        VooConsultaHelper.assignVariables(voo)
                    );
                }
            });
        }
    },

    assignVariables: function(voo) {
        return window.vooConsultaTableRowDataonlyPartial
            .replace(new RegExp('{{id}}', 'g'), voo.id)
            .replace(new RegExp('{{codigo}}', 'g'), voo.codigo)
            .replace(new RegExp('{{aeronaveNome}}', 'g'), voo.aeronave.nome)
            .replace(new RegExp('{{escalas}}', 'g'), voo.escalas)
            .replace(new RegExp('{{dataHora}}', 'g'), voo.dataHora)
            .replace(new RegExp('{{assentosDisponiveis}}', 'g'), voo.assentosDisponiveis)
            .replace(new RegExp('{{situacao}}', 'g'), voo.situacao)
            .replace(new RegExp('{{valor}}', 'g'), voo.valor)
            .replace(new RegExp('{{valorText}}', 'g'), currency(voo.valor));
    },

    initDateTimePicker: function() {
        $('#voo-consultar-datetimepicker')
            .datetimepicker({ format: 'YYYY-MM-DD HH:mm:ss' });
    }
};
