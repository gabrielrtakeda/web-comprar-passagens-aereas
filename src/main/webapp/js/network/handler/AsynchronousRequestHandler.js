var AsynchronousRequestHandler = {
    submitForm: function(self, successCallback, dataType) {
        dataType = dataType || 'json';

        $.ajax({
            url: $(self).attr('action'),
            method: $(self).attr('method'),
            data: $(self).serialize(),
            dataType: dataType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    put: function(self, dataJSON, successCallback, dataType) {
        dataType = dataType || 'json';

        $.ajax({
            url: $(self).attr('action'),
            method: 'PUT',
            data: JSON.stringify(dataJSON),
            dataType: dataType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    get: function(self, pathParams, successCallback, dataType) {
        dataType = dataType || 'json';

        console.log($(self).attr('action') + pathParams);

        $.ajax({
            url: $(self).attr('action') + pathParams,
            method: $(self).attr('method'),
            dataType: dataType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    error: function(jqxhr, error, status) {
        console.error(jqxhr, error, status);
    }
};
