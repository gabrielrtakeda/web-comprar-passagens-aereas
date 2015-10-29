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

window.vooData = null;
window.passagemData = null;

jQuery(function($) {

    VooConsultaHelper.initDateTimePicker();

    $('#consultar-voo').submit(function(e) {
        e.preventDefault();
        AsynchronousRequestHandler.get(
            this,
            Serializer.serializePath($(this).serializeArray()),
            VooConsultaHelper.appendTableRowsDataonly,
            '/api/voo/list'
        );
    });

    $('#select-tipo-passageiro').submit(function(e) {
        e.preventDefault();
        window.passagemData = getPassagemData(this);

        $(window).on('get-calculo-valor', function(e) {
            e.stopPropagation();
            e.stopImmediatePropagation();
            AlertHelper.hideError();

            if (countPassageiros.total === 0) {
                if (window.passagemData.tipoPassageiro == 'Adulto')
                    getCadastrarPassageiroResponsavelPartial(window.passagemData);
                else
                    AlertHelper.initError('O passageiro responsável pela compra \
                        deve ser o primeiro a ser cadastrado. Por favor, selecione \
                        o tipo de passageiro "Adulto" para continuar com o cadastro \
                        dos demais passageiros.');
            } else
                getCadastrarPassageiroPartial(window.passagemData);
        });
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
        window.vooData = RowDataExtractHelper.make(e, this, '#voo-id', 'id');
    });

    $('form#comprar-passagem').submit(function(e) {
        e.preventDefault();

        if (validateComprarPassagemFormSubmit(this))
            AsynchronousRequestHandler.put(
                this,
                $(this).serializeObject(),
                CadastroCompraPassagemHelper.put
            );
    });

});

var validateComprarPassagemFormSubmit = function(self) {
    var data = $(self).serializeObject();

    if (!hasVooSelected(self)) return false;
    return true;
}

var hasVooSelected = function(self) {
    var data = $(self).serializeObject();
    if (!data.vooId.trim()) {
        AlertHelper.initError('Por favor, selecione o Vôo.');
        return false;
    }
    return true;
}

var getCadastrarPassageiroResponsavelPartial = function(data) {
    if (window.partials.passageiroResponsavel.html === null) {
        $.ajax({
            url: BASE_PATH + window.partials.passageiroResponsavel.path,
            method: 'GET',
            dataType: 'html',
            success: function(partial) {
                window.partials.passageiroResponsavel.html = partial;
                $(window).trigger('get-passageiro-partial');
            }
        });
    } else
        $(window).trigger('get-passageiro-partial');

    $(window).on('get-passageiro-partial', function(e) {
        e.stopPropagation();
        e.stopImmediatePropagation();
        appendPassageiro(
            window.partials.passageiroResponsavel.html,
            data
        );
    });
}

var getCadastrarPassageiroPartial = function(data) {
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

var getPassagemData = function(self) {
    var data = $(self).serializeObject();
    data.index = countPassageiros.total;
    data.voo = window.vooData;
    getValorPassagem(data);
    return data;
}

var hydratePassageiroPartial = function(partial, data) {
    return partial
        .replace(new RegExp('{{index}}', 'g'), data.index)
        .replace(new RegExp('{{vooId}}', 'g'), data.voo.id)
        .replace(new RegExp('{{valorPassagem}}', 'g'), data.valorPassagem)
        .replace(new RegExp('{{valorPassagemText}}', 'g'), currency(data.valorPassagem))
        .replace(new RegExp('{{tipoPassageiro}}', 'g'), data.tipoPassageiro);
}

var appendPassageiro = function(partial, data) {
    $('#passageiros-container').append(
        hydratePassageiroPartial(partial, data)
    );

    sumValorTotal();
    incrementPassageiroCount(data.tipoPassageiro);
    initDateTimePicker();
    initInputMask();
}

var getValorPassagem = function(data) {
    AsynchronousRequestHandler.get(
        this,
        '/{tipoPassageiro}/{valor}'
            .replace('{tipoPassageiro}', data.tipoPassageiro)
            .replace('{valor}', data.voo.valor),
        function(response) {
            window.passagemData.valorPassagem = response;
            $(window).trigger('get-calculo-valor');
        },
        '/api/passagem/calculo-valor'
    );
}

var sumValorTotal = function() {
    var valorTotalObject = $('#valor-total');
    valorTotalObject.val(
        $.number(
              parseFloat(valorTotalObject.val())
            + parseFloat(window.passagemData.valorPassagem),
            2, '.', ''
        )
    );
}

var incrementPassageiroCount = function(tipoPassageiro) {
    var tipoPassageiroIndex = getTipoPassageiroIndex(tipoPassageiro);
    countPassageiros.total++;
    countPassageiros[tipoPassageiroIndex]++;
    $('#quantidade-' + tipoPassageiroIndex).text(
        countPassageiros[tipoPassageiroIndex]
    );
}

var decrementPassageiroCount = function(tipoPassageiro) {
    var tipoPassageiroIndex = getTipoPassageiroIndex(tipoPassageiro);
    countPassageiros.total--;
    countPassageiros[tipoPassageiroIndex]--;
    $('#quantidade-' + tipoPassageiroIndex).text(
        countPassageiros[tipoPassageiroIndex]
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

var getTipoPassageiroIndex = function(tipoPassageiro) {
    var index = 'adulto';

    switch (tipoPassageiro) {
        case 'Bebê': index = 'bebe';
        break;

        case 'Criança': index = 'crianca';
        break;
    }

    return index;
}
