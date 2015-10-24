window.tableRowPartial = null;
window.alterarFormPartial = null;

jQuery(function($) {

    // Cadastrar
    $('form#insert').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.submitForm(this, insertCallback);
    });

    // Alterar
    $('form#consultar').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.get(this, serializePath(this), appendTableRows);
    });

    $('#consultar-result').on('click', '.aeronave-edit', function(e) {
        e.preventDefault();
        var data = $(this).closest('tr').data();

        $('#alterar #input-id-aeronave').val(data.id);
        $('#alterar #input-codigo-aeronave').val(data.codigo);
        $('#alterar #input-nome-aeronave').val(data.nome);
        $('#alterar #input-quantidade-fileiras-aeronave')
            .val(data.quantidadeFileiras);
        $('#alterar #input-quantidade-assentos-fileira-aeronave')
            .val(data.quantidadeAssentosFileira);
    });

    $('form#alterar').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.submitForm(this, formAtualizarCallback);
    });

});

var assignVariables = function(aeronave) {
    return window.tableRowPartial
        .replace(new RegExp('{{id}}', 'g'), aeronave.id)
        .replace(new RegExp('{{codigo}}', 'g'), aeronave.codigo)
        .replace(new RegExp('{{nome}}', 'g'), aeronave.nome)
        .replace(
            new RegExp('{{quantidadeFileiras}}', 'g'),
            aeronave.quantidadeFileiras
        )
        .replace(
            new RegExp('{{quantidadeAssentosFileira}}', 'g'),
            aeronave.quantidadeAssentosFileira
        );
};

var insertCallback = function(response) {
    console.log(response);
    if (response.status === true) {
        window.location = window.BASE_PATH + '/home.jsp';
    } else {
        alert('Aconteceu algum erro.');
    }
};

var appendTableRows = function(response) {
    if (response.length > 0) {
        var tableBody = $('#consultar-result tbody').html('');
        $.each(response, function(i, aeronave) {
            if (window.tableRowPartial === null) {
                $.ajax({
                    url: window.BASE_PATH + '/aeronave/partials/alterar-consultar-table-row.html',
                    method: 'GET',
                    dataType: 'html',
                    success: function(partial) {
                        window.tableRowPartial = partial;
                        tableBody.append(
                            assignVariables(aeronave)
                        );
                    },
                    error: AsynchronousRequestHandler.error
                });
            } else {
                tableBody.append(
                    assignVariables(aeronave)
                );
            }
        });
    }
};

var serializePath = function(self) {
    var serial = $(self).serializeArray();

    var pathParams = '';
    $.each(serial, function(i, input) {
        console.log(i, input.name, input.value);
        pathParams += input.value + '/';
    });
    return pathParams;
};

var formAtualizarCallback = function(response) {
    if (response.status === true) {
        clearAtualizarFormData();
        $('#alterar-success-alert')
            .text('Aeronave alterada com sucesso.')
            .removeClass('hide');
    }
};

var clearAtualizarFormData = function() {
    $('#input-id-aeronave').val('');
    $('#input-codigo-aeronave').val('');
    $('#input-nome-aeronave').val('');
    $('#input-quantidade-fileiras-aeronave').val('');
    $('#input-quantidade-assentos-fileira-aeronave').val('');
}
