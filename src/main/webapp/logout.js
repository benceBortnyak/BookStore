function onLogoutButtonClicked() {

    setUnauthorized();
    document.getElementById('loginDiv').removeAttribute('class');
    document.getElementById('register').removeAttribute('class');
    document.getElementById('logoutBtn').setAttribute('class',"content hidden");
    removeAllChildren(document.getElementById('welcomeLi'));

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', loggedOut);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'logout');
    xhr.send();

}
function loggedOut() {
    console.log('logged out');

}

