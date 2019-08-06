function onAddBookButtonClicked() {
    const addBookForm = document.forms['bookForm'];
    const titleForm = addBookForm.querySelector('input[name=title]');
    const authorForm = addBookForm.querySelector('input[name=author]');
    const  pagesForm = addBookForm.querySelector('input[name=pages]');

    const titleVal = titleForm.value;
    const authorValue = authorForm.value;
    const pagesValue = pagesForm.value;

    const params = new URLSearchParams();
    params.append('title', titleVal);
    params.append('author', authorValue);
    params.append('pages', pagesValue);


    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', function () {
        alert('Book added');
    });
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'admin');
    console.log(params);
    xhr.send(params);
}
