$(document).ready(function () {

    function cleanForm() {
        $("#rua").val("");
        $("#bairro").val("");
        $("#cidade").val("");
        $("#uf").val("");
    }

    $("#cep").blur(function () {
        var cep = $(this).val().replace(/\D/g, '');

        if (cep != "") {

            var validateCep = /^[0-9]{8}$/;
            if (validateCep.test(cep)) {

                $("#rua").val("...");
                $("#bairro").val("...");
                $("#cidade").val("...");
                $("#uf").val("...");


                $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (data) {

                    if (!("erro" in data)) {

                        $("#rua").val(data.logradouro);
                        $("#bairro").val(data.bairro);
                        $("#cidade").val(data.localidade);
                        $("#uf").val(data.uf);
                    }
                    else {
                        cleanForm();
                    }
                });
            }
            else {
                cleanForm();
            }
        }
    });
});