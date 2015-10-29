window.tableRowPartial = null;
window.alterarFormPartial = null;

jQuery(function($) {

    // Cadastrar
    $('form#insert').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.post(this, insertCallback);
    });

    // Alterar
    $('form#consultar').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.get(
            this,
            Serializer.serializePath($(this).serializeArray()),
            appendTableRows,
            '/api/aeronave/list'
        );
    });

    $('#consultar-result tbody').on('click', 'tr', aeronave.consultar.table.row.click);

    $('form#aeronave-alterar').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.post(this, formAtualizarCallback);
    });

    $('#consultar-result').on('click', '.aeronave-delete', function(e) {
        e.preventDefault();
        aeronave.delete.rowObject = $(this).closest('tr');
        swal(
            aeronave.delete.confirmAttributes,
            aeronave.delete.confirmCallback
        );
    });

});

var aeronave = {
    delete: {
        rowObject: null,

        confirmAttributes: {
            title: 'Você tem certeza?',
            text: 'Não será possível reverter esta ação. Deseja continuar com \
                    a exclusão da aeronave?',
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sim, deletar!",
            cancelButtonText: "Não, cancele por favor!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
        confirmCallback: function(isConfirm) {
            if (isConfirm)
                aeronave.delete.request();
            else
                swal('Cancelado', 'A exclusão da aeronave foi cancelada.', 'error');
        },
        request: function() {
            AsynchronousRequestHandler.delete(
                Serializer.serializePath([{
                    name: 'id',
                    value: aeronave.delete.rowObject.data().id
                }]),
                aeronave.delete.response,
                '/api/aeronave'
            );
        },
        response: function(response) {
            if (response.statusOperation === true) {
                swal('Deletado', response.successMessage, 'success');
                aeronave.delete.rowObject.remove();
            } else
                swal('Erro', response.errorMessage, 'error');
        }
    },
    consultar: {
        table: {
            row: {
                click: function(e) {
                    e.preventDefault();
                    RowDataExtractHelper.assemble(e, this,
                        aeronave.consultar.get.deliverData,
                        clearAtualizarFormData);
                }
            }
        },
        get: {
            deliverData: function(data) {
                $('form#aeronave-alterar #input-id-aeronave').val(data.id);
                $('form#aeronave-alterar #input-codigo-aeronave').val(data.codigo);
                $('form#aeronave-alterar #input-nome-aeronave').val(data.nome);
                $('form#aeronave-alterar #input-quantidade-fileiras-aeronave')
                    .val(data.quantidadeFileiras);
                $('form#aeronave-alterar #input-quantidade-assentos-fileira-aeronave')
                    .val(data.quantidadeAssentosFileira);
            }
        }
    }
};

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
        sessionStorage.setItem('successMessage', 'Aeronave cadastrada com \
            sucesso!');
        goHome();
    } else
        AlertHelper.initError('Ops! Ocorreu algum erro. Aguarde alguns \
            instantes e tente novamente.');
};

var appendTableRows = function(response) {
    if (response.length > 0) {
        var tableBody = $('#consultar-result tbody').html('');
        $.each(response, function(i, aeronave) {
            if (window.tableRowPartial === null) {
                AsynchronousRequestHandler.partial(
                    '/aeronave/partials/alterar-consultar-table-row.html',
                    function(partial) {
                        window.tableRowPartial = partial;
                        tableBody.append(
                            assignVariables(aeronave)
                        );
                    }
                );
            } else {
                tableBody.append(
                    assignVariables(aeronave)
                );
            }
        });
    }
};

var formAtualizarCallback = function(response) {
    console.log(response);
    if (response.statusOperation === true) {
        clearAtualizarFormData();
        AlertHelper.initSuccess(response.successMessage);
    } else
        AlertHelper.initError(response.errorMessage);
};

var clearAtualizarFormData = function() {
    $('#input-id-aeronave').val('');
    $('#input-codigo-aeronave').val('');
    $('#input-nome-aeronave').val('');
    $('#input-quantidade-fileiras-aeronave').val('');
    $('#input-quantidade-assentos-fileira-aeronave').val('');
}
