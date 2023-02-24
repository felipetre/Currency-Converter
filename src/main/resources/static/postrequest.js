// SUBMIT FORM
$(".submit").on('click', function(event) {
	// Prevent the form from submitting via the browser.

	event.preventDefault();
	getAPIresult();

});

function getAPIresult() {
	var name1 = $("#name").val();
	var name2 = $("#name2").val();
	var value = $("#value").val();
	$.ajax({
		type: "GET",
		url: "https://api.apilayer.com/exchangerates_data/convert?to=" + name2 + "&from=" + name1 + "&amount=" + value,
		headers: {
			"apikey": "CBHQdfr9eyHXDSDMuip3IRVVazo6sHHb"
		},
		success: function(result) {
			if (result.message) {
				$('#error').show();
			} else {
				var rounded = result.result;
				rounded = Math.round(rounded * 100) / 100
				$('#result1').text(rounded + " " + name2);
				$("#error").hide();
			}
		},
		error: function(result) {
			$('#error').show();
		}

	})
};
