$('.js-check-zipcode').on('keyup', function(e){
	const $this = $(e.currentTarget);
	const zipCode = $this.val();

	if (zipCode.length === 8){
		const getAdress = getAddressByZipCode(zipCode);

		getAdress.done(function(result){
			if(!result.erro);
			const streetField =	$('.js-complete-street')
			const districtField =	$('.js-complete-district')
			const cityField =$('.js-complete-city')
			const stateField =$('.js-complete-state');
		});


	}
});


function getAddressByZipCode(userZipCode) {
	const requestURL = `https://viacep.com.br/ws/${userZipCode}/json/`;

	return $.ajax(requestURL,{
		method: 'GET',
		dataType: 'json'
	});

}
