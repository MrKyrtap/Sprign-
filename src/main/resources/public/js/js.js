/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
function crunchifyAjax() {

    $.ajax({
        url : '/ajax',
        success : function(data) {
            for (var i = 0; i < data.length; ++i) {
                console.log(data[i].name);
            }
        }
    });
}