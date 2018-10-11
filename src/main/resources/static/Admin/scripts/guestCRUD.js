function getData() {
    $.ajax({
        url: "http://localhost:8080/api/guest/list",
        type: "get",
        success: function(guests) {
            console.log(guests);
            $('#guests').DataTable().clear();
            $('#guests').DataTable().rows.add(guests);
            $('#guests').DataTable().columns.adjust().draw();
        }
    });
}

function deleteData(id){
    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/guest/delete/" + id,
        type: "delete",
        success: function(result) {
            // On successful post, reload data to get the added one as well and repopulate the dropdown with updated tables.
            getData();
        }
    });
}

function confirmDelete(id){
    var conf = confirm("Are you sure you want to delete this person?");
    if(conf == true){
        deleteData(id);
    }
}


$(document).ready(function() {
    $('#guests').DataTable({
        columns: [
            { data: "id" },
            { data: "firstName" },
            { data: "lastName" },
            { data: "emailAddress" },
            { data: function(data){
                        return data.phoneCountryCode + "-" + data.phoneNumber;
                    } },
            { data: "userName"},
            { data: "newsLetter" },
            { data: function() {
                    return '<button type="button" class="btn btn-primary">Update</button>' + '<button onclick="confirmDelete(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                }
            },
        ]
    });
    getData();
})
