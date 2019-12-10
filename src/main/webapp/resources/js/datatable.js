$(document).ready(function() {
    var table = $('#productosTable').DataTable({
        "sAjaxSource": "/api/productos",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "descripcion" },
        ]
    })
});

$(document).ready(function() {
    var table = $('#personasTable').DataTable({
        "sAjaxSource": "/api/personas",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "apellido" },
            { "mData": "telefono" },
        ]
    })
});


$(document).ready(function() {
    var table = $('#proveedorTable').DataTable({
        "sAjaxSource": "/api/proveedores",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "direccion" },
            { "mData": "telefono" },
        ]
    })
});

$(document).ready(function() {
    var table = $('#ventaTable').DataTable({
        "sAjaxSource": "/api/ventas",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "descripcion" },
            { "mData": "precio" },
        ]
    })
});


$(document).ready(function() {
    var table = $('#trabajadorTable').DataTable({
        "sAjaxSource": "/api/trabajadores",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "direccion" },
            { "mData": "turno" },
        ]
    })
});
