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

                if (result.street !== "") {
                    streetField.val(result.street);
                }
                if (result.district !== "") {
                    districtField.val(result.district);
                }

                if (result.city !== "") {
                    cityField.val(result.city);
                }
                if (result.state !== "") {
                    stateField.val(result.state);
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