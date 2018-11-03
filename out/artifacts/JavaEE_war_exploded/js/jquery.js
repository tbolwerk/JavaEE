$("#key").keyup(function(){
    $(document).ready(function() {
        $('#userName').blur(function() {
            $.ajax({
                url : 'livesearch',
                data : {
                    key : $('#key').val()
                },
                success : function(responseText) {

                    $('#livesearch').text(responseText);

                }
            });
        });
    });
});