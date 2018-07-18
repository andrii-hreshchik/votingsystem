




$(document).ready(function () {
      TableHtml = $('#admin_menu_datatable').html();
    dataTableApi = $('#admin_menu_datatable').DataTable({
        ajax: {
            url: 'ajax/meals/today/' + restaurantId,
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
