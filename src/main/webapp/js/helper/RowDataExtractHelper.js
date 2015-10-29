var RowDataExtractHelper = {
    make: function(event, self, targetElementSelector, dataIndex) {
        var data = $(self).data();
        console.log('RowDataExtractHelper.make', data);

        if (!$(event.target).is('button')) {
            if ($(self).hasClass('info')) {
                $(self).removeClass('info');
                $(targetElementSelector).val('');
            } else {
                $(self).closest('.table-responsive').find('tr').removeClass('info');
                $(self).addClass('info');
                $(targetElementSelector).val(data[dataIndex]);
            }
        }

        return $(self).data();
    },

    assemble: function(event, self, callback, toggleCallback) {
        toggleCallback = toggleCallback || function(data) {};

        if (!$(event.target).is('button')) {
            if ($(self).hasClass('info')) {
                $(self).removeClass('info');
                toggleCallback($(self).data());
            } else {
                $(self).closest('.table-responsive').find('tr').removeClass('info');
                $(self).addClass('info');
                callback($(self).data());
            }
        }
    }
};
