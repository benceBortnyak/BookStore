function getBooksFromSessionStorage() {
    let books = new Array();
    for (let i = 1; i <sessionStorage.length ; i++) {
        books.push(JSON.parse(sessionStorage.getItem(i + 'book')));
    }
    return books;
}
function getCurrentUser() {
    return JSON.stringify(localStorage.getItem('user'));
}

function getUserDetails(userId){
    const params = new URLSearchParams();
    params.append('userId', userId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onOrderResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'order');
    xhr.send(params);
}

function addUserDetails() {


}
function onOrderResponse() {


}