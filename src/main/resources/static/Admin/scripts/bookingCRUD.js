function getData() {
    console.log("Getting data...");
    $.ajax({
        url: "http://localhost:8080/api/booking/list",
        type: "get",
        success: function(booking) {
            // On successful get, reload the datatable with new data.
             console.log("data received");
             $.each(booking, function(index, booking) {
                console.log(booking.id + " " + booking.date + " " + booking.guest + " " + booking.numberOfPersons);
            });
            $('#bookings').DataTable().clear();
            $('#bookings').DataTable().rows.add(booking);
            $('#bookings').DataTable().columns.adjust().draw();
        }
    });
}

$(document).ready(function() {
    $('#bookings').DataTable({
        columns: [
            { data: "id" },
            { data: "date" },
            { data: "guest.firstName" },
            { data: "guest.lastName" },
            { data: "amountOfPersons" },
            {
                data: function() {
                    return '<button type="button" class="btn btn-primary">Update</button>' + '<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },
        ]
    });
    getData();
})
