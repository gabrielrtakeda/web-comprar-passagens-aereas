var clock = function() {
    var date = new Date();
    $('#clock').html(date);
    setTimeout("clock()", 1000);
}

var currency = function(price) {
    return 'R$ ' + $.number(price, 2, ',', '.');
}

var goHome = function() {
    window.location = BASE_PATH + '/home.jsp';
}

var date = {
    format: {
        mysql: function(dateString) {
            return moment(dateString)
                    .format('YYYY-MM-DD HH:mm:ss')
        },
        java: function(dateString) {
            return moment(dateString)
                    .format('YYYY-MM-DD HH:mm:ss.S')
        }
    }
};

var initialized = false;
var articleProperties = function() {
    var headerHeight = $('body>header').outerHeight();
    var articleHeight = $('body>article').outerHeight();
    var fullscreenHeight = $('.fullscreen-background').outerHeight();
    var unknowHeightProperty = 15;

    $('body>article').css({
        maxHeight: fullscreenHeight - headerHeight - unknowHeightProperty
    });
}


$(function() {
    $('.fullscreen-background').backgroundcover();

    $('body').ready(clock);
    $('body').ready(articleProperties);
    $(window).resize(articleProperties);

    var navChildActive = $('body>header').data().active;
    var navChild = $('body>header .dropdown.' + navChildActive);
    if (navChild) navChild.addClass('active');
});
