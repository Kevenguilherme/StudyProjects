import { categories, products } from './productsData.js';
import { render } from './render.js';
import { renderButtonsCategories } from './render.js';
import { handleDarkMode } from './theme.js';

let arrayFilter = products;
let filterValue = 200;

const buttonFilterCategorie = (categorie, product) => {
  const buttonFilter = document.querySelectorAll('.buttonsGender');

  buttonFilter.forEach((button) => {
    button.addEventListener('click', (event) => {
      const buttonEvent = event.target.innerText;

      const buttonIndex = categorie.findIndex(
        (categorie) => categorie === buttonEvent
      );

      if (buttonIndex === 0) {
        arrayFilter = products;

        render(arrayFilter, filterValue);
      } else {
        arrayFilter = product.filter(
          (product) => product.category === Number(buttonIndex)
        );
        render(arrayFilter, filterValue);
      }
    });
  });
};

const filterByRange = () => {
  const inputRange = document.querySelector('#rangeInput');

  inputRange.addEventListener('input', () => {
    const priceP = document.querySelector('#search__price');

    filterValue = Number(inputRange.value).toFixed(2);

    priceP.innerText = `Até R$ ${filterValue}`;

    render(arrayFilter, filterValue);
  });
};

render(arrayFilter, filterValue);
renderButtonsCategories(categories);
buttonFilterCategorie(categories, products);
filterByRange();
handleDarkMode();
