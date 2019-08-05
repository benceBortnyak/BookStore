const OK = 200;
const BAD_REQUEST = 400;
const UNAUTHORIZED = 401;
const NOT_FOUND = 404;
const INTERNAL_SERVER_ERROR = 500;
let buttons = [];
let loginContentDivEl;



function newInfo(targetEl, message) {
    newMessage(targetEl, 'info', message);
}

function newError(targetEl, message) {
    newMessage(targetEl, 'error', message);
}

function newMessage(targetEl, cssClass, message) {
    clearMessages();

    const pEl = document.createElement('p');
    pEl.classList.add('message');
    pEl.classList.add(cssClass);
    pEl.textContent = message;

    targetEl.appendChild(pEl);
}

function clearMessages() {
    const messageEls = document.getElementsByClassName('message');
    for (let i = 0; i < messageEls.length; i++) {
        const messageEl = messageEls[i];
        messageEl.remove();
    }
}

function showContents(ids) {
    const contentEls = document.getElementsByClassName('content');
    for (let i = 0; i < contentEls.length; i++) {
        const contentEl = contentEls[i];
        if (ids.includes(contentEl.id)) {
            contentEl.classList.remove('hidden');
        } else {
            contentEl.classList.add('hidden');
        }
    }
}
function setFocus(focus) {
    let getButton;
    for (let i = 0; i < buttons.length; i++) {
        getButton = document.getElementById(buttons[i]);
        if(!(getButton == null)){
            getButton.removeAttribute('class');
        }
    }
    document.getElementById(focus).setAttribute('class','active');
}

function removeAllChildren(el) {
    while (el.firstChild) {
        el.removeChild(el.firstChild);
    }
}

function onNetworkError(response) {
    document.body.remove();
    const bodyEl = document.createElement('body');
    document.appendChild(bodyEl);
    newError(bodyEl, 'Network error, please try reloaing the page');
}

function onOtherResponse(targetEl, xhr) {
    if (xhr.status === NOT_FOUND) {
        newError(targetEl, 'Not found');
        console.error(xhr);
    } else {
        const json = JSON.parse(xhr.responseText);
        if (xhr.status === INTERNAL_SERVER_ERROR) {
            newError(targetEl, `Server error: ${json.message}`);
        } else if (xhr.status === UNAUTHORIZED || xhr.status === BAD_REQUEST) {
            newError(targetEl, json.message);
        } else {
            newError(targetEl, `Unknown error: ${json.message}`);
        }
    }
}

function hasAuthorization() {
    return localStorage.getItem('user') !== null;
}

function setAuthorization(user) {
    return localStorage.setItem('user', JSON.stringify(user));
}

function getAuthorization() {
    return JSON.parse(localStorage.getItem('user'));
}

function setUnauthorized() {
    return localStorage.removeItem('user');
}
function deleteStorage() {
    localStorage.clear();
    sessionStorage.clear();
}

function onLoad() {
    deleteStorage();
    buttons = ['home','cart','login','logout'];
    addEventListener("load",onBookLoad);
    const homeButton = document.getElementById('home');
    homeButton.addEventListener('click',onBookLoad);
    const cartButton= document.getElementById('cart');
    cartButton.addEventListener('click',onCartClicked);
    loginContentDivEl = document.getElementById('loginRegisterDiv');
    const loginButton = document.getElementById('loginButton');
    loginButton.addEventListener('click',onLoginButtonClicked);
    const logoutButton = document.getElementById('logoutBtn');
    logoutButton.addEventListener('click',onLogoutButtonClicked);
    const registerButton = document.getElementById('register');
    registerButton.addEventListener('click',onRegisterButtonClicked);
    const registerFormButton = document.getElementById('submitButton');
    registerFormButton.addEventListener('click',onRegisterFormButtonClicked);
    const orderBtn = document.getElementById('orderButton');
    orderBtn.addEventListener('click',onOrderButtonClicked);
}

document.addEventListener('DOMContentLoaded', onLoad);
