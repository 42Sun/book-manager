function post() {
    const questionId = $("#question_id").val();
    const commentContent = $("#comment_content").val();

    $.ajax({
        type: "post",
        url: "/comment",
        data: JSON.stringify({
                parentId: questionId,
                content: commentContent,
                type: 1
            }
        ),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (response) {
            if (response.code === 200) {
                location.reload()
            } else {
                alert(response.message)
            }
        }
    })
    ;
}

function subPost(id) {
    const commentId = $("#comment" + id).val();
    const subcommentContent = $("#content" + id).val();

    $.ajax({
        type: "post",
        url: "/comment",
        data: JSON.stringify({
                parentId: commentId,
                content: subcommentContent,
                type: 2
            }
        ),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (response) {
            if (response.code === 200) {
                location.reload()
            } else {
                alert(response.message)
            }
        }
    })
    ;
}