function getData() {
    console.log("Hello world!");
    $.ajax({
        url: "http://localhost:8080/api/tables/list",
        type: "get",
        success: function(table) {
            // On successful get, reload the datatable with new data.
            console.log("This is the data: " + table);
            $('#myTable').DataTable().clear();
            $('#myTable').DataTable().rows.add(table);
            $('#myTable').DataTable().columns.adjust().draw();
        }
    });
}

function deleteTable(tableNR) {
    console.log(tableNR);
    $.ajax({
        url: "http://localhost:8080/api/tables/delete/" + tableNR,
        type: "DELETE",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
            console.log("success Delete data!");
            getData();
        }
    });
}

function postData() {
    console.log("posting data...");

    // Get values from html.
    var number = $("#inputTableNR").val();
    var capacity = $("#inputCapacity").val();

    // Create JS object with data.
    var newTable = {
        number: number,
        capacity: capacity
    };
    console.log(newTable);

    // Convert JS object to JSON.
    var validJsonTable = JSON.stringify(newTable);
    console.log(validJsonTable);

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/tables/post",
        type: "post",
        data: validJsonTable,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
            console.log("success post data!");
            getData();
        }
    });
}

$(document).ready(function() {

    // Modal submit.
    $("#newTableForm").on('submit', function(e) {
        console.log("Submitted new Table form");

        // Post the data from the modal.
        postData();

        // Reset modal to hide and no values.
        $('#newTableModal').modal('hide');
        $("#inputTableNR").val("");
    });

    $('#myTable').DataTable({
        columns: [
            { data: "number" },
            { data: "capacity" },
            {
                data: function() {
                    return '<button type="button" class="btn btn-primary">Update</button>' + '<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },





        ]
    });
    getData();
})
