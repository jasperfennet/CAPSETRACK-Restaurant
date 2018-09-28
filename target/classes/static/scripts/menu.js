    function getData() {
        console.log("Hello world!");
        $.ajax({
            url: "http://localhost:8080/api/menuItem/list",
            type: "get",
            success: function (menuItem) {
                // On successful get, reload the datatable with new data.
                console.log("This is the data: " + menuItem);
                $('#myTable').DataTable().clear();
                $('#myTable').DataTable().rows.add(menuItem);
                $('#myTable').DataTable().columns.adjust().draw();
            }
        });
    }

    function deleteTable(menuItemNR) {
        console.log(menuItemNR);
        $.ajax({
            url: "http://localhost:8080/api/menuItem/delete/" + menuItemNR,
            type: "DELETE",
            success: function (result) {
                // On successful post, reload data to get the added one as well.
                console.log("success Delete data!");
                getData();
            }
        });
    }

    function postData() {
        console.log("posting data...");

        // Get values from html.
        var number = $("#inputMenuNR").val();
        var name = $("#inputMenuName").val();
        var description = $("#inputMenuDescription").val();
        var ingredients = $("#inputRecipe").val();

        // Create JS object with data.
        var newMenu = {
            id: number,
            name: name,
            menuDescription: description,
            ingredients: null
        };
        console.log(newMenu);

        // Convert JS object to JSON.
        var validJsonMenu = JSON.stringify(newMenu);
        console.log(validJsonMenu);

        // Post JSON to endpoint.
        $.ajax({
            url: "http://localhost:8080/api/menuItem/post",
            type: "post",
            data: validJsonMenu,
            contentType: "application/json",
            success: function (result) {
                // On successful post, reload data to get the added one as well.
                console.log("success post data!");
                getData();
            }
        });
    }

    $(document).ready(function () {

        // Modal submit.
        $("#newMenuForm").on('submit', function (e) {
            console.log("Submitted new Menu form");

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
                { data: function() {
                        return '<button type="button" class="btn btn-primary">Update</button>'+'<button onclick="deleteTable(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Delete</button>'
                    }
                },





            ]
        });
        getData();
    })