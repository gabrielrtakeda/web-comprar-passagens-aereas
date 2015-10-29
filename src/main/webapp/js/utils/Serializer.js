var Serializer = {

    serializePath: function(serializedArray) {
        var pathParams = '';

        for (var serialized of serializedArray)
            pathParams += '/' + serialized.value;

        return pathParams;
    }
};
