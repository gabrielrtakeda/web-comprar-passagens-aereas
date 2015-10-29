jQuery(function($) {

    var formaPagamentoModel = new FormaPagamentoModel();
    $('.forma-pagamento-selection').click(formaPagamentoModel.initFormaPagamento);
    $('.forma-pagamento input[type="radio"]').change(formaPagamentoModel.initDadosPagamento);

    $('#dados-pagamento-credito').submit(formaPagamentoModel.credito.put.request);
    $('#dados-pagamento-debito').submit(formaPagamentoModel.debito.put.request);

    var compra = JSON.parse(sessionStorage.getItem('compra'));
    var compraList = manipulateCompra.getGroupTipoPassageiro(compra.passagens);

    manipulateCompra.initDistribution(compraList);
    manipulateCompra.total.listCountCompras(compraList);

});

var manipulateCompra = {
    getGroupTipoPassageiro: function(passagens) {
        var list = {
            adultos: [],
            criancas: [],
            bebes: []
        };
        for (var passagem of passagens) {
            if (passagem.tipoPassageiro == 'Adulto') {
                list.adultos.push(passagem);

            } else if (passagem.tipoPassageiro == 'Criança') {
                list.criancas.push(passagem);

            } else if (passagem.tipoPassageiro == 'Bebê') {
                list.bebes.push(passagem);
            }
        }
        return list;
    },

    initDistribution: function(list) {
        manipulateCompra.distributeAdultosTableRows(list.adultos);
        manipulateCompra.distributeCriancasTableRows(list.criancas);
        manipulateCompra.distributeBebesTableRows(list.bebes);
    },

    distributeAdultosTableRows: function(adultos) {
        for (adulto of adultos) {
            $('table#adultos tbody').append(
                manipulateCompra.buildRow(adulto)
            )
        }
    },

    distributeCriancasTableRows: function(adultos) {
        for (adulto of adultos) {
            $('table#criancas tbody').append(
                manipulateCompra.buildRow(adulto)
            )
        }
    },

    distributeBebesTableRows: function(adultos) {
        for (adulto of adultos) {
            $('table#bebes tbody').append(
                manipulateCompra.buildRow(adulto)
            )
        }
    },

    total: {
        listCountCompras: function(list) {
            $('table#subtotal')
                .append(manipulateCompra.total.buildSubtotalRow(list.adultos))
                .append(manipulateCompra.total.buildSubtotalRow(list.criancas))
                .append(manipulateCompra.total.buildSubtotalRow(list.bebes));

            $('table#total')
                .append(manipulateCompra.total.buildTotalRow(list));
        },

        buildSubtotalRow: function(type) {
            return type.length <= 0 ? ''
                : $('<tr />')
                    .append($('<td />', {text: type[0].tipoPassageiro}))
                    .append($('<td />', {text: currency(type[0].valorPassagem)}))
                    .append($('<td />', {text: type.length}))
                    .append($('<td />', {text: currency(type.length * parseFloat(type[0].valorPassagem))}));
        },

        buildTotalRow: function(list) {
            var valorTotalAdultos = list.adultos.length <= 0 ? 0
                : list.adultos.length * parseFloat(list.adultos[0].valorPassagem);

            var valorTotalCriancas = list.criancas.length <= 0 ? 0
                : list.criancas.length * parseFloat(list.criancas[0].valorPassagem);

            var valorTotalBebes = list.bebes.length <= 0 ? 0
                : list.bebes.length * parseFloat(list.bebes[0].valorPassagem);

            return $('<tr />')
                .append($('<td />', {text: currency(
                      valorTotalAdultos
                    + valorTotalCriancas
                    + valorTotalBebes
                )}))
        },
    },

    buildRow: function(passagem) {
        return $('<tr />')
            .append($('<td />', {text: passagem.nome + ' ' + passagem.sobrenome}))
            .append($('<td />', {text: currency(passagem.valorPassagem)}));
    }
};
