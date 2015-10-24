var RowDataExtractHelper = {
    make: function(self, targetElementSelector, dataIndex) {
        var data = $(self).data();
        console.log('RowDataExtractHelper.make', data);

        if ($(self).hasClass('info')) {
            $(self).removeClass('info');
            $(targetElementSelector).val('');
        } else {
            $(self).closest('.table-responsive').find('tr').removeClass('info');
            $(self).addClass('info');
            $(targetElementSelector).val(data[dataIndex]);
        }
    }
};
