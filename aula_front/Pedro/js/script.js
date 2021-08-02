$('.js-check-zipcode').on('keyup', function(e){
    const $this = $(e.currentTarget);
    const zipCode = $this.val();

    if(zipCode.length === 8){
        const getAdress = getAdressByZipCode(zipCode);

        getAdress.done(function(result){
            if(!result.erro){
                const streetField = $('js-complete-street'),
                const districtField = $('js-complete-district'),
                const cityField = $('js-complete-city'),
                const stateField = $('js-complete-state');

                if(result.bairro !== ""){
                    districtField.val(result.localidade);
                }

                if(result.rua !== ""){
                    streetField.val(result.rua);
                }

                if(result.localidade !== ""){
                    cityField.val(result.cidade);
                }

                if(result.uf !== ""){
                    stateField.val(result.uf);
                }
            }
            console.log(result);
        });
    }
});

function getAdressByZipCode(userZipCode){
    const requestURL = `https://viacep.com.br/ws/${userZipCode}/json/`;

    return $.ajax(requestURL, {
        method: 'GET',
        dataType: 'json'
    });
}

