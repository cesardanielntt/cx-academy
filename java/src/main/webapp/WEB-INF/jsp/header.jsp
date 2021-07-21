<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script>
    $(document).ready(function () {
        $('.cep').mask("00.000-000");
    })
</script>

<style>
    * {
        font-family: 'Arial';
        background-color: #ffffff;
    }
    input, select, option, textarea {
        margin: 10px auto;
        border: none;
        padding: 15px;
        background-color: #f1f1f1;
        border-radius: 10px;
        width: 100%;
    }
    button {
        margin: 10px auto;
        border: none;
        padding: 15px;
        text-align: center;
        width: 100%;
        background-color: #4bceff;
        border-radius: 10px;
        color: #fff;
        font-size: 18px;
    }
    .error {
        color: red;
        margin-bottom: 15px;
    }
    form {
        width: 400px;
        text-align: left;
        margin: 0 auto;
    }
    .row {
        display: block;
    }
    .content-form {
        width: 400px;
        text-align: center;
        margin: 0 auto;
    }
    .content {
        width: 80%;
        margin: 0 auto;
        border-radius: 10px;
        padding: 2px;
    }
    .table {
        width: 100%;
        margin: 0 auto;
        border: solid 0.5px #ccc;
        border-radius: 10px;
        padding: 2px;
    }
    table {
        width: 100%;
        margin: 0 auto;
        border-radius: 50px;
    }
    tr:last-child {
        border-bottom: solid 1px #ccc;
        width: 16%;
        padding: 15px;
    }

    th {
        border-bottom: solid 0.5px #ccc;
        width: 16%;
        padding: 15px;
    }
    td {
        border-bottom: solid 0.5px #ccc;
        border-right: solid 0.5px #ccc;
        padding: 10px;
    }
    td:last-child {
        border-right: none;
        padding: 10px;
    }
    tr:last-child td {
        border-bottom: none;
    }
    .id-collum {
        width: 5%;
    }
    .register-button {
        width: auto;
    }
    .radio {
        width: 200px;
    }
</style>
