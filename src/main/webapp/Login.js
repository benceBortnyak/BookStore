
function onLoginResponse() {
    if (this.status === OK) {
        const user = JSON.parse(this.responseText);
        setAuthorization(user);

        showContents(['main', 'cart']);
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
function onLoginNavBarButtonClicked() {
    showContents(['main','loginRegisterDiv']);
}