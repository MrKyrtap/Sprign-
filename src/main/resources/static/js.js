/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
function crunchifyAjax() {
    var x = $('#txt').val();
    console.log(x);
    $.ajax({
        url : '/ajax/'+x,
        success : function(data) {
            var names="";
            for (var i = 0; i < data.length; ++i) {
                names=names+" <br/>"+data[i].name;
            }
            $('#result').html(names);
        }
    });
}