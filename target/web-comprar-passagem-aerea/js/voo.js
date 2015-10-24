jQuery(function($) {
    initMaskedInputs();
    initDateTimePicker();
    initSuccessMessage();

    $('form#consultar-aeronave').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.get(
            this,
            Serialize.serializePath(this),
            AeronaveConsultaHelper.appendTableRowsDataonly
        );
        $('#aeronave-id').val('');
    });

    $('#consultar-aeronave .table-responsive').on('click', 'tr', function(e) {
        e.preventDefault();
        RowDataExtractHelper.make(this, '#aeronave-id', 'id');
    });

    $('#cadastrar-voo').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.submitForm(this, formAtualizarCallback);
    });
});

var formAtualizarCallback = function(response) {
    if (response.status === true) {
        sessionStorage.setItem(
            'successMessage',
            'Vôo cadastrado com sucesso!'
        );
        location.reload();
    } else {
        console.log('qqq');
    }
}

var initSuccessMessage = function() {
    var successMessage = sessionStorage.getItem('successMessage') || undefined;
    if (successMessage) {
        $('#success-alert')
            .text(successMessage)
            .removeClass('hide');

        sessionStorage.removeItem('successMessage');
    }
}

var initMaskedInputs = function() {
    $('#valor').maskNumber({decimal: '.', thousands: ''});
}

var initDateTimePicker = function() {
    $('#voo-cadastrar-datetimepicker')
        .datetimepicker({ format: 'YYYY-MM-DD HH:mm:ss' });
}
