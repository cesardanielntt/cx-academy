
$('.js-check-cep').on("keyup", (e) => {
    const $this = $(e.currentTarget);
    const zipCode = $this.val();

    if(zipCode.length === 8) {
        console.log(zipCode)

        const getAddress = getAddressByZipCode(zipCode);

        getAddress.done((result) => {
            console.log(result);
            if(!result.erro) {

                const bairro = $(".js-check-bairro");
                const cidade = $(".js-check-cidade");
                const compl = $(".js-check-compl");
                const estado = $(".js-check-estado");
                const rua = $(".js-check-rua");


                if(result.bairro !== "")  {
                    bairro.val(result.bairro)
                }

                if(result.rua !== "")  {
                    cidade.val(result.logradouro)
                }

                if(result.localidade !== "")  {
                    cidade.val(result.localidade)
                }

                if(result.x !== "")  {
                    bairro.val(result.bairro)
                }

            }
        });
    }
})

function getAddressByZipCode(userZipCode) {
    let requestURL = `https://viacep.com.br/ws/${userZipCode}/json/`;
    
    return $.ajax(requestURL, {
        method: 'GET',
        dataType: 'json'
    });
}

