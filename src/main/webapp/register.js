function onRegisterButtonClicked() {
    setFocus('register');
    showContents(['main','registerDiv']);

}
function onRegisterResponse() {
    const user = JSON.parse(this.responseText);
    setAuthorization(user);
    onBookLoad();
    removeLogin();
    alert('registered');
}
function onRegisterFormButtonClicked() {
    const registerForm = document.forms['signUp-form'];
    const foreNameRegister = registerForm.querySelector('input[name=foreName]');
    const secondNameRegister = registerForm.querySelector('input[name=lastName]');
    const emailRegister = registerForm.querySelector('input[name=emailReg]');
    const passwordRegister = registerForm.querySelector('input[name=passwordReg]');
    const passwordReRegister = registerForm.querySelector('input[name=passwordRegRe]');

    const foreName = foreNameRegister.value;
    const secondName = secondNameRegister.value;
    const email = emailRegister.value;
    const password = passwordRegister.value;
    const passwordRe = passwordReRegister.value;

    const params = new URLSearchParams();
    params.append('email', email);
    params.append('foreName', foreName);
    params.append('secondName',secondName);
    params.append('password', password);
    params.append('rePassword',passwordRe);


    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onRegisterResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'register');
    console.log(params);
    xhr.send(params);

}