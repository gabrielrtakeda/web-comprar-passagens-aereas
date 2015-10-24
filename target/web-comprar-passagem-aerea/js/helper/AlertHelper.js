var errorAlert = $('#error-alert');

var AlertHelper = {
    initError: function(message) {
        errorAlert
            .removeClass('hide')
            .find('#message')
            .text(message);

        $('html, body').animate({scrollTop: errorAlert.offset().top});
    },

    hideError: function() {
        errorAlert
            .addClass('hide')
            .find('#message').text('');
    }
};
