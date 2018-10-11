function getData() {
     
    $.ajax({
        url: "http://localhost:8080/api/table/list",
        type: "get",
        success: function(table) {
            // On successful get, reload the datatable with new data.
             
            $('#myTable').DataTable().clear();
            $('#myTable').DataTable().rows.add(table);
            $('#myTable').DataTable().columns.adjust().draw();
        }
    });
}

function deleteTable(tableNR) {
     
    $.ajax({
        url: "http://localhost:8080/api/table/delete/" + tableNR,
        type: "DELETE",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
             
            getData();
        }
    });
}

function postData() {
     

    // Get values from html.
    var number = $("#inputTableNR").val();
    var capacity = $("#inputCapacity").val();

    // Create JS object with data.
    var newTable = {
        number: number,
        capacity: capacity
    };
     

    // Convert JS object to JSON.
    var validJsonTable = JSON.stringify(newTable);
     

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/table/post",
        type: "post",
        data: validJsonTable,
        contentType: "application/json",
        success: function(result) {
            // On successful post, reload data to get the added one as well.
             
            getData();
        }
    });
}

$(document).ready(function() {

    // Modal submit.
    $("#newTableForm").on('submit', function(e) {
         

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
            { data: "status" },
            {
                data: function() {
                    return '<button type="button" class="btn btn-primary">Update</button>' + '<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },





        ]
    });
    getData();
})
