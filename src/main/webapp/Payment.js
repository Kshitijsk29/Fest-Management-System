document.getElementById('payment-form').addEventListener('submit', function(event) {
    event.preventDefault();// Prevent form submission

    // Validate and process form data

    // For example, log the form data to the console
    var cardNumber = document.getElementById('card-number').value;
    var cardHolder = document.getElementById('card-holder').value;
    var expiryDate = document.getElementById('expiry-date').value;
    var cvv = document.getElementById('cvv').value;

    console.log('Card Number:', cardNumber);
    console.log('Card Holder:', cardHolder);
    console.log('Expiry Date:', expiryDate);
    console.log('CVV:', cvv);



    // Show payment successful popup
   // document.getElementById('payment-successful-popup').style.display = 'block';
});
