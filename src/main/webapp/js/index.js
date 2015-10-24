jQuery(function($) {

    $('#authentication').submit(function(e) {
        e.preventDefault();

        $.ajax({
            url: $(this).attr('action'),
            method: $(this).attr('method'),
            data: $(this).serialize(),
            dataType: 'json',
            success: function(response) {
                if (response.status) {
                    window.location = 'home.jsp';
                } else {
                    $('#error-alert')
                        .text('Erro de authenticação.')
                        .removeClass('hide');
                }
            },
            error: function(jqxhr, error, status) {
                console.error(jqxhr, error, status);
            }
        });
    });

});
