$('.js-check-zipcode').on('keyup', function(e) {
    const $this = $(e.currentTarget);
    const zipCode = $this.val();

    if (zipCode.length === 8) {
        const getAddress = getAddressByZipCode(zipCode);

        getAddress.done(function(result) {
            if (!result.erro) {
                const streetField = $('.js-complete-street');
                const districtField = $('.js-complete-district');
                const cityField = $('.js-complete-city');
                const stateField = $('.js-complete-state');

                if (result.bairro !== "") {
                    districtField.val(result.bairro);
                }

                if (result.logradouro !== "") {
                    streetField.val(result.logradouro);
                }

                if (result.localidade !== "") {
                    cityField.val(result.localidade);
                }

                if (result.uf !== "") {
                    stateField.val(result.uf);
                }
            }

        });
    }
});


function getAddressByZipCode(userZipCode) {
    const requestURL = `https://viaCep.com.br/ws/${userZipCode}/json`;

    return $.ajax(requestURL, {
        method: 'GET',
        dataType: 'json',
    });
}