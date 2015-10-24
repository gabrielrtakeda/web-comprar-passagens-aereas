var countPassageiros = {
    adulto: 0,
    crianca: 0,
    bebe: 0,
    total: 0
};

window.partials = {
    passageiroResponsavel: {
        path: '/passagem/partials/cadastrar-form-content-passageiro-responsavel.jsp',
        html: null
    },
    passageiro: {
        path: '/passagem/partials/cadastrar-form-content-passageiro.jsp',
        html: null
    }

};

jQuery(function($) {

    VooConsultaHelper.initDateTimePicker();

    $('#consultar-voo').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.get(
            this,
            Serialize.serializePath(this),
            VooConsultaHelper.appendTableRowsDataonly
        );
    });

    $('#select-tipo-passageiro').submit(function(e) {
        e.preventDefault();
        var data = getPassageiroData(this);

        AlertHelper.hideError();

        if (countPassageiros.total === 0) {
            if (data.tipoPassageiro == 'Adulto')
                getCadastrarPassageiroResponsavelPartial(this);
            else
                AlertHelper.initError('O passageiro responsável pela compra \
                    deve ser o primeiro a ser cadastrado. Por favor, selecione \
                    o tipo de passageiro "Adulto" para continuar com o cadastro \
                    dos demais passageiros.');
        } else
            getCadastrarPassageiroPartial(this);
    });

    $('#passageiros-container').on('click', '.remover-passageiro', function(e) {
        e.preventDefault();
        var container = $(this).closest('.passageiro-container');
        var data = container.data();

        container.remove();
        decrementPassageiroCount(data.tipoPassageiro);
    });

    $('#consultar-voo #consultar-result').on('click', 'tr', function(e) {
        e.preventDefault();
        RowDataExtractHelper.make(this, '#voo-id', 'id');
    });

    $('form#comprar-passagem').submit(function(e) {
        e.preventDefault();

        console.log($(this).serializeObject());
        if (validateComprarPassagemFormSubmit(this))
            AsynchronousRequestHandler.put(
                this,
                $(this).serializeObject(),
                CadastroCompraPassagemHelper.insert
            );
    });

});

var validateComprarPassagemFormSubmit = function(self) {
    var data = $(self).serializeObject();

    if (!data.vooId.trim()) {
        AlertHelper.initError('Por favor, selecione o Vôo.');
        return false;
    }
    return true;
}

var getCadastrarPassageiroResponsavelPartial = function(self) {
    var data = getPassageiroData(self);
    if (window.partials.passageiroResponsavel.html === null) {
        $.ajax({
            url: BASE_PATH + window.partials.passageiroResponsavel.path,
            method: 'GET',
            dataType: 'html',
            success: function(partial) {
                window.partials.passageiroResponsavel.html = partial;
                appendPassageiro(partial, data);
                return partial;
            }
        });
    } else
        appendPassageiro(window.partials.passageiroResponsavel.html, data);
}

var getCadastrarPassageiroPartial = function(self) {
    var data = getPassageiroData(self);
    if (window.partials.passageiro.html === null) {
        $.ajax({
            url: BASE_PATH + window.partials.passageiro.path,
            method: 'GET',
            dataType: 'html',
            success: function(partial) {
                window.partials.passageiro.html = partial;
                appendPassageiro(partial, data);
                return partial;
            }
        });
    } else
        appendPassageiro(window.partials.passageiro.html, data);
}

var getPassageiroData = function(self) {
    var data = $(self).serializeObject();
    data.index = countPassageiros.total;
    return data;
}

var hydratePassageiroPartial = function(partial, data) {
    return partial
        .replace(new RegExp('{{index}}', 'g'), data.index)
        .replace(new RegExp('{{tipoPassageiro}}', 'g'), data.tipoPassageiro);
}

var appendPassageiro = function(partial, data) {
    $('#passageiros-container').append(
        hydratePassageiroPartial(partial, data)
    );

    incrementPassageiroCount(data.tipoPassageiro);
    initDateTimePicker();
    initInputMask();
}

var incrementPassageiroCount = function(tipoPassageiro) {
    countPassageiros.total++;
    countPassageiros[tipoPassageiro]++;
    $('#quantidade-' + tipoPassageiro).text(
        countPassageiros[tipoPassageiro]
    );
}

var decrementPassageiroCount = function(tipoPassageiro) {
    countPassageiros.total--;
    countPassageiros[tipoPassageiro]--;
    $('#quantidade-' + tipoPassageiro).text(
        countPassageiros[tipoPassageiro]
    );
}

var initDateTimePicker = function() {
    $('.voo-cadastrar-passageiro-nascimento-datetimepicker')
        .datetimepicker({
            format: 'YYYY-MM-DD',
            viewMode: 'years'
        });
}

var initInputMask = function() {
    $('.passageiro-ddd').mask("99");
    $('.passageiro-telefone').mask("9999-99999");
}
