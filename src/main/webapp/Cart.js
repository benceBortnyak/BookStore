let cartElement;

function getItemsFromLocalStorage() {
    removeAllChildren(cartElement);
    if(hasAuthorization()) {
        if (sessionStorage.length === 0) {
            onBookLoad();
            alert('Cart is empty');
        } else {
            setFocus('cart');
            for (const key of Object.keys(sessionStorage)) {
                const book = JSON.parse(sessionStorage.getItem(key));
                const bookEle = document.createElement("div");
                bookEle.setAttribute("id", book.bookId + 'cart');
                cartElement.appendChild(bookEle);
                const listOpen = document.createElement("ul");
                listOpen.setAttribute("style", "list-style-type:none;");
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
                const bookId = book.bookId + book.bookTitle;
                const addToCartButton = document.createElement('input');
                addToCartButton.setAttribute('type', 'button');
                addToCartButton.setAttribute('id', bookId);
                addToCartButton.setAttribute('value', 'Remove from cart');
                addToCartButton.addEventListener('click', function () {
                    removeFromStorage(bookId);
                });
                bookEle.appendChild(addToCartButton);
            }
            onOrderBookLoad();
            showContents(['main', 'cartDiv']);
        }
    }else{
        alert('You have to login to use your cart');
    }
}
function removeFromStorage(bookId) {
    sessionStorage.removeItem(bookId);
    getItemsFromLocalStorage();
}

function onCartClicked() {
    cartElement = document.getElementById('cartDiv');
    getItemsFromLocalStorage();

}