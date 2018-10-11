function postBooking() {


    // Get values from html.
    var firstname = $("#inputFirstname").val();
    var lastname = $("#inputLastname").val();
    var username = $("#inputUsername").val();
    var password = $("#inputPassword").val();

    var date = $("#inputDate").val();
    var time = $("#inputTime").val();
    var people = $("#inputPeople").val();
    var phonenr = $("#inputPhone").val();
    var email = $("#inputEmail").val();



    // Create JS object with data.
    var newBooking = {
        date: date + "T" + time,
        guest: {
            firstName: firstname,
            lastName: lastname,
            emailAddress: email,
            phoneNumber: phonenr,
            userName: username,
            password: password,
        },
        amountOfPersons: people,
    };


    // Convert JS object to JSON.
    var validJsonTable = JSON.stringify(newBooking);


    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/booking/post",
        type: "post",
        data: validJsonTable,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
            alert("Booking Placed");
        }
    });
}

$(document).ready(function() {

    // Modal submit.
    $("#newBookingForm").on('submit', function(e) {
        postBooking();
    });

})