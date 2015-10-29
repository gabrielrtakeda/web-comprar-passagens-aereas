var AsynchronousRequestHandler = {
    post: function(self, successCallback, dataType) {
        dataType = dataType || 'json';

        console.log($(self).serialize());
        $.ajax({
            url: $(self).attr('action'),
            method: $(self).attr('method'),
            data: $(self).serialize(),
            dataType: dataType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    put: function(self, dataJSON, successCallback, contentType, dataType) {
        contentType = contentType || 'text/plain';
        dataType = dataType || 'json';

        console.log(JSON.stringify(dataJSON));
        $.ajax({
            url: $(self).attr('action'),
            method: 'PUT',
            data: JSON.stringify(dataJSON),
            dataType: dataType,
            contentType: contentType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    get: function(self, pathParams, successCallback, url, dataType) {
        dataType = dataType || 'json';

        console.log('method: GET');
        console.log(url + pathParams);

        $.ajax({
            url: BASE_PATH + url + pathParams,
            method: 'GET',
            dataType: dataType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    delete: function(pathParams, successCallback, url, dataType) {
        dataType = dataType || 'json';

        console.log('method: DELETE');
        console.log(url + pathParams);

        $.ajax({
            url: BASE_PATH + url + pathParams,
            method: 'DELETE',
            dataType: dataType,
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    partial: function(url, successCallback) {
        console.log('partial(url, successCallback)');
        console.log(url);
        $.ajax({
            url: BASE_PATH + url,
            method: 'GET',
            dataType: 'html',
            success: successCallback,
            error: AsynchronousRequestHandler.error
        });
    },

    error: function(jqxhr, error, status) {
        console.error(jqxhr, error, status);
    }
};
