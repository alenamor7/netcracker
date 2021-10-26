$(document).ready(function() {
    $('#form').on('submit', function (event) {

        var a = $('#a').val();
        var b = $('#b').val();
        var c = $('#c').val();

        function validation() {
            if (a == "") {
                alert("Please, enter number in field A. Or set it to 0");
                event.preventDefault();
                return false;
            }
            else if (!($.isNumeric(a))) {
                alert("Please, enter number in field A");
                $('#a').val('');
                event.preventDefault();
                return false;
            }
            if (b == "") {
                alert("Please, enter number in field B. Or set it to 0");
                event.preventDefault();
                return false;
            }
            else if (!($.isNumeric(b))) {
                alert("Please, enter number in field B");
                $('#b').val('');
                event.preventDefault();
                return false;
            }
            if (c == "") {
                alert("Please, enter number in field C. Or set it to 0");
                event.preventDefault();
                return false;
            }
            else if (!($.isNumeric(c))) {
                alert("Please, enter number in field C");
                $('#c').val('');
                event.preventDefault();
                return false;
            }
            return true;
        }


        if (validation()) {
            $.post('CalculatingCoeffs',
                {
                    coeffA: a,
                    coeffB: b,
                    coeffC: c
                }, function (response) {
                    $('#resultTable tbody').append('<tr><td>' + a + '</td><td>' + b + '</td><td>' + c +
                        '</td><td>' + response + '</td></tr>');
                    $('#a').val('');
                    $('#b').val('');
                    $('#c').val('');
                })
            event.preventDefault();
        }

        $('#resultTable tbody tr').on('click', function () {
            if (confirm("Do you want to delete this result?")) {
                $(this).remove();
            }
        });
    })
})
