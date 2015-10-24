var Serialize = {

    serializePath: function(self) {
        var serial = $(self).serializeArray();

        var pathParams = '';
        $.each(serial, function(i, input) {
            console.log(i, input.name, input.value);
            pathParams += input.value + '/';
        });
        return pathParams;
    }
};
