    function getData() {
         
        $.ajax({
            url: "http://localhost:8080/api/menuItem/list",
            type: "get",
            success: function (menuItem) {
                // On successful get, reload the datatable with new data.
                 
                $('#myTable').DataTable().clear();
                $('#myTable').DataTable().rows.add(menuItem);
                $('#myTable').DataTable().columns.adjust().draw();
            }
        });
    }

    function deleteTable(menuItemNR) {
         
        $.ajax({
            url: "http://localhost:8080/api/menuItem/delete/" + menuItemNR,
            type: "DELETE",
            success: function (result) {
                // On successful post, reload data to get the added one as well.
                 
                getData();
            }
        });
    }

    function postData() {
         

        // Get values from html.
        var number = $("#inputMenuNR").val();
        var name = $("#inputMenuName").val();
        var description = $("#inputMenuDescription").val();
        var price = $("#inputMenuPrice").val();
        var ingredients = $("#inputRecipe").val();

        // Create JS object with data.
        var newMenu = {
            id: number,
            name: name,
            menuDescription: description,
            price: price,
            ingredients: null
        };
         

        // Convert JS object to JSON.
        var validJsonMenu = JSON.stringify(newMenu);
         

        // Post JSON to endpoint.
        $.ajax({
            url: "http://localhost:8080/api/menuItem/post",
            type: "post",
            data: validJsonMenu,
            contentType: "application/json",
            success: function (result) {
                // On successful post, reload data to get the added one as well.
                 
                getData();
            }
        });
    }

    $(document).ready(function () {

        // Modal submit.
        $("#newMenuForm").on('submit', function (e) {
             

            // Post the data from the modal.
            postData();

            // Reset modal to hide and no values.
            $('#newMenuModal').modal('hide');
            $("#inputMenuNR").val("");
        });

        $('#myTable').DataTable({
            columns: [
                { data: "id" },
                { data: "name" },
                { data: "menuDescription" },
                { data: "price" },
                { data: function() {
                        return '<button type="button" class="btn btn-primary">Update</button>'+'<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                    }
                },





            ]
        });
        getData();
    })