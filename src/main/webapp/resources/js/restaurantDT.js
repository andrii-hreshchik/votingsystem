function format(table_id) {
    return '<table class="table table-striped" id="restaurant_datatable_' + table_id + '">' +
        '<thead><tr><th>ID</th><th>Description</th><th>Price</th></tr></thead>' +
        '</table>';
}

var iTableCounter = 1;
var oInnerTable;


$(document).ready(function () {
    TableHtml = $('#restaurant_datatable').html();
    var table = $('#restaurant_datatable').DataTable({
        ajax: {
            url: '/ajax/restaurants',
            dataSrc: ''
        },
        rowId: 'id',
        columns: [
            {
                className: 'details-control',
                orderable: false,
                data: null,
                defaultContent: ''
            },
            {data: 'id'},
            {data: 'title'},
            {data: 'description'}
        ],
        order: [[1, 'asc']]
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
            oInnerTable = $('#restaurant_datatable_' + iTableCounter).dataTable({
                ajax: {
                    url: '/ajax/meals/',
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
                    {data: 'id'},
                    {data: 'description'},
                    {data: 'price'}
                ]
            });
            iTableCounter = iTableCounter + 1;
        }
    });
});