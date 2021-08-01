$('.js-check-zipcode').on('keyup', function(e){
	const $this = $(e.currentTarget);
	const zipCode = $this.val();

	if (zipCode.length === 8){
		const getAdress = getAddressByZipCode(zipCode);

		getAdress.done(function(result){
			console.log(result);
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
