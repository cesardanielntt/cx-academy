
$('.js-check-zipcode').on('keyup', function (e) {
    const $this = $(e.currentTarget);
    const zipCode = $this.val();

    if (zipCode.length === 8) {
        const getAddress = getAddressByZipCode(zipCode);

        getAddress.done(function (result) {
            if (!result.erro) {
                const streetField = $('.js-complete-street');
                    const districtField = $('.js-complete-district');
                    const cityField = $('.js-complete-city');
                    const stateField = $('.js-complete-state');

                if (result.logradouro !== "") {
                    streetField.val(result.logradouro);
                }
                if (result.bairro !== "") {
                    districtField.val(result.bairro);
                }

                if (result.cidade !== "") {
                    cityField.val(result.localidade);
                }
                if (result.uf !== "") {
                    stateField.val(result.uf);
                }
                $this.val(result.cep);
            }
        });

        
    }


});

function getAddressByZipCode(userZipCode) {
    const requestURL = `https://viacep.com.br/ws/${userZipCode}/json/`;

    return $.ajax(requestURL, {
        method: 'GET',
        dataType: 'json'
    });

}