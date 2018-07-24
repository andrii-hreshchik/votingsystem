var ajaxMealsUrl = '/ajax/meals/';


$(document).ready(function () {
       dataTableApi = $('#admin_menu_datatable').DataTable({
        ajax: {
            url: 'ajax/meals/today/restaurant/' + restaurantId,
            dataSrc: ''
        },
        rowId: 'id',
        initComplete: makeEditable(),
        columns: [
            {data: 'description'},
            {data: 'price'},
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

function createMeal() {
    form.find(":input").val("");
    $('#modalTitle').html("Create meal");
    $('#editRow').modal();
}

function makeEditable() {
    form = $('#detailsForm');
    $.ajaxSetup({cache: false});
}

function deleteRow(id) {
    $.ajax({
        type: "DELETE",
        url: ajaxMealsUrl + id
    }).done(function () {
        updateTable();
    });
}

function updateRow(id) {
    $('#modalTitle').html("Update meal");
    $.get(ajaxMealsUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxMealsUrl + restaurantId,
        data: form.serialize()
    }).done(function () {
        $('#editRow').modal('hide');
        updateTable();
    });
}

function updateTable() {
    $.get('ajax/meals/today/restaurant/' + restaurantId, updateTableByData);
}


function updateTableByData(data) {
    dataTableApi.clear().rows.add(data).draw();
}
