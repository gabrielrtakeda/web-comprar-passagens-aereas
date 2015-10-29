var Scrollator = {
    move: function(targetElement) {
        var deferred = $.Deferred();
        $('body>article').animate({
            scrollTop: $('body>article').scrollTop()
                + targetElement.position().top
        }).promise().done(function() {
            deferred.resolve();
        });
        return deferred.promise();
    }
};
