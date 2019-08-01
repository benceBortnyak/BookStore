
function onLoginResponse() {
    if (this.status === OK) {
        const user = JSON.parse(this.responseText);
        setAuthorization(user);
        removeLogin();
        onBookLoad();
        console.log('logged in');
    } else {
        alert('Login Failed');
    }
}

function onLoginButtonClicked() {
    const loginFormEl = document.forms['loginForm'];

    const emailInputEl = loginFormEl.querySelector('input[name="email"]');
    const passwordInputEl = loginFormEl.querySelector('input[name="password"]');

    const email = emailInputEl.value;
    const password = passwordInputEl.value;

    const params = new URLSearchParams();
    params.append('email', email);
    params.append('password', password);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLoginResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'login');
    console.log(params);
    xhr.send(params);
}

function removeLogin() {
    document.getElementById('loginDiv').setAttribute('class','hidden content');
    document.getElementById('register').setAttribute('class','hidden content');
    document.getElementById('logoutBtn').removeAttribute('class');
    const topNav = document.getElementById('navBarList');
    const currentUser = JSON.parse(localStorage.getItem('user')).secondName;
    const welcome = document.getElementById('welcomeLi');
    const innerWelcome = document.createElement('a');
    welcome.removeAttribute('class');
    innerWelcome.textContent = 'Welcome: ' + currentUser;
    welcome.append(innerWelcome);
    topNav.append(welcome);
}