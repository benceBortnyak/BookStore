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
    xhr.addEventListener('load',
        function () {
            onOrderResponse(xhr);
        });
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'details');
    xhr.send(params);
}

function addUserDetails() {
    const detailsForm = document.forms['detailsForm'];
    const cityForm = detailsForm.querySelector('input[name="city"]');
    const streetForm = detailsForm.querySelector('input[name="street"]');
    const zipCodeForm = detailsForm.querySelector('input[name="ZipCode"]');
    const streetNoForm = detailsForm.querySelector('input[name="streetNumber"]');

    const cityValue = cityForm.value;
    const streetValue = streetForm.value;
    const zipCodeValue = zipCodeForm.value;
    const streetNoValue = streetNoForm.value;

    const params = new URLSearchParams();
    params.append('city',cityValue);
    params.append('street',streetValue);
    params.append('zip',zipCodeValue);
    params.append('streetNo',streetNoValue);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load',displayUserDetails);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'details');
    console.log(params);
    xhr.send(params);



}
function displayUserDetails() {
    let details = JSON.parse(this.responseText);
    const displayDiv = document.getElementById('display');
    removeAllChildren(displayDiv);
    const city = details.userCity;
    const street = details.userStreet;
    const zip= details.userZipcode;
    const streetNo= details.userStreetNumber;
    const open = document.createElement('ul');
    open.setAttribute("style", "list-style-type:none;");

    displayDiv.appendChild(open);

    const cityLi =document.createElement('li');
    cityLi.textContent = 'City :' + city;
    open.appendChild(cityLi);

    const streetLi = document.createElement('li');
    streetLi.textContent = 'Street :' + street;
    open.appendChild(streetLi);

    const zipLi = document.createElement('li');
    zipLi.textContent = 'Zip Code :' + zip;
    open.appendChild(zipLi);

    const streetNoLi = document.createElement('li');
    streetNoLi.textContent = 'Street Number :' + streetNo;
    open.appendChild(streetNoLi);

    showContents(['main', 'cartDiv','display','userDetails','orderButtonDiv']);

}
function onOrderResponse(xhr) {
    if(xhr.status === BAD_REQUEST){
        const detailsBtn = document.getElementById('detailsButton');
        detailsBtn.addEventListener('click',addUserDetails);
        showContents(['main', 'cartDiv','userDetails','userForm']);
    }else {
        displayUserDetails();
    }
}
function onOrderBookLoad() {
    getUserDetails(getCurrentUser());

}
function onOrderButtonClicked() {
    let books = getBooksFromSessionStorage();

    const params = new URLSearchParams();
    params.append('books',JSON.stringify(books));
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load',onOrderLoad);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'order');
    console.log(params);
    xhr.send(params);


}

function onOrderLoad() {
    alert('Order OK!');
}

