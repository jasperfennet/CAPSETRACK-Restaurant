function getData() {

    $.ajax({
        url: "http://localhost:8080/api/booking/list",
        type: "get",
        success: function(booking) {
            $('#bookings').DataTable().clear();
            $('#bookings').DataTable().rows.add(booking);
            $('#bookings').DataTable().columns.adjust().draw();
        }
    });
}

function postData() {
    // Get values from html.
    var date = $("#inputDate").val();
    var amount = $("#inputNumberPersons").val();
    var guest = $("#inputGuest").val();
    var table = $("#inputTable").val();

    // Create JS object with data.
    var newBooking = {
        date: date,
        amountOfPersons: amount,
        //guest: guest,
        table: [{
                    id: table
               }]
    };


    // Convert JS object to JSON.
    var validJsonBooking = JSON.stringify(newBooking);
    console.log(validJsonBooking);

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/booking/post",
        type: "post",
        data: validJsonBooking,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well and update the dropdown
            getData();
            populateTablesDropdown();
        }
    });
}

function updateData() {
    // Get values from html.
    var id = $("#IdToUpdate").text();
    var updatedDate = $("#updateDate").val();
    var updatedAmount = $("#updateNumberPersons").val();
    var updatedFirstName = $("#updateFirstName").val();
    var updatedLastName = $("#updatedLastName").val();
    var updatedTable = $("#updateTable").val();

    // Create JS object with data.
    var updatedBooking = {
        date: updatedDate,
        amountOfPersons: updatedAmount,
//        guest: {
//                    firstName: updatedFirstName,
//                    lastName: updatedLastName
//               }
        table: [{
                    id: updatedTable
               }]
        };

    // Convert JS object to JSON.
    var validJsonBooking = JSON.stringify(updatedBooking);
    console.log("valid jsonbooking: " + validJsonBooking);

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/booking/update/" + id,
        type: "put",
        data: validJsonBooking,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well and repopulate the dropdown with updated tables.
            getData();
            populateTablesDropdown();
        }
    });
}


function fillUpdateModal(values) {
    var id = values[0].innerText;
    var currentDate = values[1].innerText;
    var currentFirstName = values[2].innerText;
    var currentLastName = values[3].innerText;
    var currentAmount = values[4].innerText;
    var currentTable = values[5].innerText;
    $("#IdToUpdate").text(id);
    $("#updateDate").val(currentDate);
    $("#updateFirstName").val(currentFirstName);
    $("#updateLastName").val(currentLastName);
    $("#updateNumberPersons").val(currentAmount);
    $("#updateTable").val(currentTable);
}

function populateTablesDropdown(){

	$.ajax({
		url: "http://localhost:8080/api/table/get/available",
		type: "get",
		success: function(data){
			let dropdown1 = $("#updateTable");
			let dropdown2 = $("#inputTable");
            dropdown1.empty();
            dropdown2.empty();
			$.each(data, function(index, value){
                dropdown1.append($("<option></option>")
                                 .attr("value",value.id)
                                 .text(value.number));
                dropdown2.append($("<option></option>")
                                 .attr("value",value.id)
                                 .text(value.number));
			});
		},
		error: function(error){
			console.log("Error: " + error);
		}
	});
}

$(document).ready(function() {
    // Modal new booking submit.
    $("#newBookingModal").on('submit', function(e) {
        postData();
        // Reset modal to hide and no values.
        $('#newBookingModal').modal('hide');
        $("#inputDate").val("");
        $("#inputGuest").val("");
        $("#inputNumberPersons").val("");
        $("#inputTable").val("");
    });

    // Modal update booking submit.
    $("#updateBookingModal").on('submit', function(e) {
        updateData();
        // Reset modal to hide and no values.
        $('#updateBookingModal').modal('hide');
        $("#updateDate").val("");
        $("#updateFirstName").val("");
        $("#updateLastName").val("");
        $("#updateNumberPersons").val("");
        $("#updateTable").val("");
    });

    $('#bookings').DataTable({
        columns: [
            { data: "id" },
            { data: "date" },
            { data: "guest.firstName" },
            { data: "guest.lastName" },
            { data: "amountOfPersons" },
            { data: function(data){
                        var tables = "";
                        $.each(data.table, function(index, value){
                            console.log(value);
                            if(tables == ""){
                                tables = tables + value.number;
                            }
                            else{
                                tables = tables + ", " + value.number;
                            }
                            console.log(tables);
                        });
                        return tables;
                    }
            },
            { data: function() {
                    return '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateBookingModal" onclick="fillUpdateModal(this.parentElement.parentElement.children)">Update</button>' + '<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },
        ]
    });
    getData();

    populateTablesDropdown();
})
