jQuery(function($) {

    $(document).ready(function() {
        var successMessage = sessionStorage.getItem('successMessage');
        var errorMessage = sessionStorage.getItem('errorMessage');

        if (successMessage)
            AlertHelper.initSuccess(successMessage);

        else if (errorMessage)
            AlertHelper.initError(errorMessage);
    });

});
