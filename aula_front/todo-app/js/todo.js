//$("#sortable").sortable();

getTaskList();
countTodos();

// all done btn
$("#checkAll").click(function() {
    AllDone();
});

//create todo
$('.add-todo').on('keypress', function(e) {
    e.preventDefault
    if (e.which == 13) {
        if ($(this).val() != '') {
            var todo = $(this).val();
            createTodo(todo);
            countTodos();
        } else {
            // some validation
        }
    }
});
// mark task as done
$(document).on('change', '.js-form-check-input', function() {
    if ($(this).prop('checked')) {
        var doneItem = $(this).parent().parent().find('label').text();
        $(this).parent().parent().addClass('remove');
        done(doneItem);
        countTodos();
    }
});

//delete done task from "already done"
$('.todolist').on('click', '.remove-item', function() {
    removeItem(this);
});

function getTaskList() {
    requestURL = 'js/todo.json';

    $.ajax(requestURL, {
        method: 'GET',
        dataType: 'json',
        success: function(response) {
            var data = response.data;
            for (let i = 0; i < data.length; i++) {
                createTodo(data[i].task);
            }

            countTodos();
        }
    });
}

// count tasks
function countTodos() {
    var count = $("#sortable li").length;
    $('.js-count-todos').html(count);
}

//create task
function createTodo(text) {
    var markup = '<li class="list-group-item"> <div class="form-check"> <input class="js-form-check-input form-check-input" type="checkbox" value=""> <label class="form-check-label" >' + text + ' </label> </div> </li>'
    $('#sortable').append(markup);
    $('.add-todo').val('');
}

//mark task as done
function done(doneItem) {
    var done = doneItem;
    var markup = '<li>' + done + '<button type="button" class="close btn btn-default btn-xs pull-right  remove-item" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>';
    $('#done-items').append(markup);
    $('.remove').remove();
}

//mark all tasks as done
function AllDone() {
    var myArray = [];

    $('#sortable li').each(function() {
        myArray.push($(this).text());
    });

    // add to done
    for (i = 0; i < myArray.length; i++) {
        $('#done-items').append('<li>' + myArray[i] + '<button class="btn btn-default btn-xs pull-right  remove-item"><span class="glyphicon glyphicon-remove"></span></button></li>');
    }

    // myArray
    $('#sortable li').remove();
    countTodos();
}

//remove done task from list
function removeItem(element) {
    $(element).parent().remove();
}