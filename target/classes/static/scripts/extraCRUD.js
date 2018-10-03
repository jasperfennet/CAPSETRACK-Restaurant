function getData() {
    console.log("Hello world!");
    $.ajax({
        url: "http://localhost:8080/api/extra/list",
        type: "get",
        success: function(extra) {
            // On successful get, reload the datatable with new data.
            console.log("This is the data: " + extra);
            $('#myTable').DataTable().clear();
            $('#myTable').DataTable().rows.add(extra);
            $('#myTable').DataTable().columns.adjust().draw();
        }
    });
}

function deleteTable(tableNR) {
    console.log(tableNR);
    $.ajax({
        url: "http://localhost:8080/api/extra/delete/" + tableNR,
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
    var name = $("#inputExtraName").val();
    var price = $("#inputCost").val();

    // Create JS object with data.
    var newExtra = {
        name: name,
        price: price
    };
    console.log(newExtra);

    // Convert JS object to JSON.
    var validJsonExtra = JSON.stringify(newExtra);
    console.log(validJsonExtra);

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/extra/post",
        type: "post",
        data: validJsonExtra,
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
    $("#newExtraForm").on('submit', function(e) {
        console.log("Submitted new Extra form");

        // Post the data from the modal.
        postData();

        // Reset modal to hide and no values.
        $('#newExtraModal').modal('hide');
        $("#inputExtraName").val("");
        $("#inputCost").val("10.00");
    });

    $('#myTable').DataTable({
        columns: [
            { data: "name" },
            { data: "price" },
            {
                data: function() {
                    return '<button type="button" class="btn btn-primary">Update</button>' + '<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },
        ]
    });
    getData();
})
