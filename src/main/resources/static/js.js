/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
function crunchifyAjax() {
    var x = $('#title').val();
    console.log(x);
    $.ajax({
        url : '/ajax/'+x,
        success : function(data) {

            var options = '';

            for (var i = 0; i < data.names.length; ++i) {
                options += '<option value="'+data.names[i].title+'" />';
            }
            if(data.names.length==0){
                $('#bt_submit').attr("disabled", false);

            }
            else{
                $('#bt_submit').attr("disabled", true);
            }
           $('#result').html(data.message.description);

            document.getElementById('anrede').innerHTML = options;
        }
    });
}