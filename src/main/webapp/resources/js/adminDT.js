var ajaxRestaurantsUrl = '/ajax/restaurants/';
var form;
var dataTableApi;

// http://api.jquery.com/jQuery.ajax/#using-converters
$.ajaxSetup({
    converters: {
        'text json': function (stringData) {
            var json = JSON.parse(stringData);
            $(json).each(function () {
                this.date = this.date.replace('T', ' ').substr(0, 16);
            });
            return json;
        }
    }
});

$(document).ready(function () {
    dataTableApi = $('#admin_datatable').DataTable({
        ajax: {
            url: ajaxRestaurantsUrl,
            dataSrc: ''
        },
        rowId: 'id',
        initComplete: makeEditable(),
        columns: [
            {data: 'title'},
            {data: 'description'},
            {data: 'date'},
            {
                data: 'todayMenuPrice',
                defaultContent: 'No menu for today'
            },
            {
                data: 'todayRating',
                defaultContent: '0'
            },
            {
                data: 'overallRating',
                defaultContent: '0'
            },

            {
                render: menuBtn,
                data: null,
                defaultContent: ''
            },
            {
                render: editBtn,
                data: null,
                defaultContent: ''
            },
            {
                render: deleteBtn,
                data: null,
                defaultContent: ''
            }
        ],
        order: [[1, 'asc']]
    });

});

function menuBtn(data, type, row) {
    if (type === 'display') {
        return "<a onclick='goToMenu(" + row.id + ");'><span class='fas fa-bars'></span></a>";
    }
}

function editBtn(data, type, row) {
    if (type === 'display') {
        return "<a onclick='updateRow(" + row.id + ");'><span class='far fa-edit'></span></a>";
    }
}

function deleteBtn(data, type, row) {
    if (type === 'display') {
        return "<a onclick='deleteRow(" + row.id + ");'><span class='far fa-trash-alt'></span></a>";
    }

}

function goToMenu(id) {
    document.location = "/updateMenu?id=" + id;
}

function updateRow(id) {
    $('#modalTitle').html("Update restaurant");
    $.get(ajaxRestaurantsUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}


function createRestaurant() {
    form.find(":input").val("");
    $('#modalTitle').html("Create restaurant");
    $('#editRow').modal();
}

function deleteRow(id) {
    $.ajax({
        type: "DELETE",
        url: ajaxRestaurantsUrl + id
    }).done(function () {
        updateTable();
    });
}

function makeEditable() {
    form = $('#detailsForm');
    $.ajaxSetup({cache: false});
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxRestaurantsUrl,
        data: form.serialize()
    }).done(function () {
        $('#editRow').modal('hide');
        updateTable();
    });
}

function updateTable() {
    $.get(ajaxRestaurantsUrl, updateTableByData);
}


function updateTableByData(data) {
    dataTableApi.clear().rows.add(data).draw();
}
