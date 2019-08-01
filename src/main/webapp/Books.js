let booksDivElement;

function appendBooks() {
    removeAllChildren(booksDivElement);
    setFocus('home');
    let books = JSON.parse(this.responseText);
    console.log(books);
    for (let i = 0; i < books.length; i++) {
        const book = books[i];
        console.log(book);
        const bookEle = document.createElement("div");
        bookEle.setAttribute("id", book.bookId);
        booksDivElement.appendChild(bookEle);
        const listOpen = document.createElement("ul");
        listOpen.setAttribute("style","list-style-type:none;");
        bookEle.appendChild(listOpen);
        const title = document.createElement("li");
        title.textContent = 'title: ' + book.bookTitle;
        listOpen.appendChild(title);
        const author = document.createElement("li");
        author.textContent = 'author: ' + book.bookAuthor;
        listOpen.appendChild(author);
        const pages = document.createElement("li");
        pages.textContent = 'pages: ' + book.bookPage;
        listOpen.appendChild(pages);
        const price = document.createElement("li");
        price.textContent = 'price: ' + book.bookPrice;
        listOpen.appendChild(price);
        let addToCartButton;
        if(!checkIfInCart(book)) {
            addToCartButton = document.createElement('input');
            addToCartButton.setAttribute('type', 'button');
            addToCartButton.setAttribute('id', book.bookId + book.bookTitle);
            addToCartButton.setAttribute('value', 'Add to cart');
            addToCartButton.addEventListener('click', function () {
                addToSessionStorage(book);
            });
            bookEle.appendChild(addToCartButton);
        }
    }
}
function checkIfInCart(book) {
    for (const key of Object.keys(sessionStorage)) {
        if(key === book.bookId+'book'){
            return true;
        }
    }
    return false;
}


function addToSessionStorage(book) {
    if(hasAuthorization()) {
        const name = book.bookId + book.bookTitle;
        sessionStorage.setItem(name, JSON.stringify(book));
        const button = book.bookId + book.bookTitle;
        document.getElementById(button).remove();
    }else{
        alert('You have to login if you want to add something to your cart');
    }
}


function onBookLoad() {
    booksDivElement = document.getElementById("booksDiv");
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('error', onNetworkError);
    xhr.addEventListener('load', appendBooks);
    xhr.open('GET', 'Books');
    xhr.send();
    showContents(['main', 'booksDiv']);
}
