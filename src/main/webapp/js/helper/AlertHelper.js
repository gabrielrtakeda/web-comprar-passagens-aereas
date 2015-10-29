var errorAlert = $('#error-alert');
var successAlert = $('#success-alert');
var animationTime = 500;

var AlertHelper = {
    initError: function(message) {
        errorAlert
            .fadeIn(animationTime)
            .find('#message')
            .text(message);

        Scrollator.move(errorAlert);
        AlertHelper.setAutoClose(errorAlert, 5000);
        sessionStorage.removeItem('errorMessage');
    },

    hideError: function() {
        errorAlert
            .hide()
            .find('#message').text('');
    },

    initSuccess: function(message) {
        successAlert
            .fadeIn(animationTime)
            .find('#message')
            .text(message);

        Scrollator.move(successAlert);
        AlertHelper.setAutoClose(successAlert, 5000);
        sessionStorage.removeItem('successMessage');
    },

    hideSuccess: function() {
        successAlert
            .hide()
            .find('#message').text('');
    },

    setAutoClose: function(alertObject, delay) {
        setTimeout(function() { alertObject.fadeOut(animationTime); }, delay);
    }
};

AlertHelper.hideError();
AlertHelper.hideSuccess();
