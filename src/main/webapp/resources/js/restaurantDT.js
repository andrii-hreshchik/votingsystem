function format(table_id) {
    return '<table class="table table-striped" id="restaurant_datatable_' + table_id + '">' +
        '<thead>' +
        '<tr>' +
        '<th>Description</th>' +
        '<th>Price</th>' +
        '</tr>' +
        '</thead>' +
        '</table>';
}

var iTableCounter = 1;
var oInnerTable;
var table;

$(document).ready(function () {
    table = $('#restaurant_datatable').DataTable({
        ajax: {
            url: '/ajax/restaurants',
            dataSrc: ''
        },
        rowId: 'id',
        initComplete: makeEditable(),
        columns: [
            {data: 'title'},
            {data: 'description'},
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
                className: 'details-control',
                orderable: false,
                data: null,
                defaultContent: ''
            },
            {
                className: 'cursor',
                render: voteBtn,
                data: null,
                defaultContent: ''
            }
        ],
        order: [[0, 'asc']]
    });
    $('#restaurant_datatable tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);
        if (row.child.isShown()) {
            //  If this row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child(format(iTableCounter)).show();
            tr.addClass('shown');
            var restaurantId = row.data().id;
            oInnerTable = $('#restaurant_datatable_' + iTableCounter).dataTable({
                ajax: {
                    url: '/ajax/meals/today/restaurant/' + restaurantId,
                    dataSrc: ''
                },
                autoWidth: true,
                deferRender: true,
                info: false,
                lengthChange: false,
                ordering: false,
                paging: false,
                scrollX: false,
                scrollY: false,
                searching: false,
                columns: [
                    {data: 'description'},
                    {data: 'price'}
                ]
            });
            iTableCounter = iTableCounter + 1;
        }
    });
});


function voteBtn(data, type, row) {
    if (type === 'display') {
        return "<a onclick='voteRow(" + row.id + ");'><span class='fas fa-check'></span></a>";
    }
}

function voteRow(id) {
    $('#restId').val(id);
    $('#modalVote').modal();
}

function save() {
    var restId = $('#restId').val();
    $.ajax({
        type: 'POST',
        url: '/ajax/votes/create/' + restId
    }).done(function () {
        $('#modalVote').modal('hide');
        updateTable();
    });
}

function updateTable() {
    $.get('/ajax/restaurants', updateTableByData);
}

function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}

function makeEditable() {
    $.ajaxSetup({cache: false});
}