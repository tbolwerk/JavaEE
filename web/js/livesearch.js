function searchInfo() {
    var key = document.getElementById('key').value;
    var xhttp;
    if (window.XMLHttpRequest) {
        // code for modern browsers
        xhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            for (var i = 0; i < 3; i++) {
                document.getElementById("livesearch"+i).innerHTML = this.responseText;
            }

        }
    };
    xhttp.open('GET', 'livesearch?key=' + key, true);
    xhttp.send();
}



