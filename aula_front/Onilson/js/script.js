$('.js-check-zipcode').on('Keyup', function(e) {
const $this = $(e.currentTarget);
const zipCode = $this.val();

if(zipCode.length === 8) {
	const getAddress = getAddressByZipCode(zipCode);

	getAddress.done (function(result) { 
		console.log(result);
	
	 });
	}
  });

function getAddressByZipCode(userZipCode) {
	const requestURL = `https://viacep.com.br/ws/${userZipCode}/json/`;

	return $.ajax(resquestURL, {
		method: 'GET',
		dataType: 'json',
	});
}