export const render = (product, value) => {
  const mainList = document.querySelector('.render-cards__list');

  mainList.innerHTML = '';

  product.forEach((product) => {
    if (product.price <= value) {
      const card = createCard(product);

      mainList.appendChild(card);
    }
  });
};

const createCard = ({ img, title, band, year, price }) => {
  const cardContainer = document.createElement('li');
  const cardImage = document.createElement('img');
  const divCard2 = document.createElement('div');
  const divCard1 = document.createElement('div');
  const cardBandName = document.createElement('p');
  const cardBandYear = document.createElement('p');
  const cardTitleAlbum = document.createElement('h2');
  const cardPrice = document.createElement('p');
  const cardButton = document.createElement('button');

  cardContainer.classList.add('card__container');
  divCard1.classList.add('div-card-1__container');
  divCard2.classList.add('div-card-2__container');

  cardImage.classList.add('card__image');
  cardImage.src = img;

  cardBandName.classList.add('card-band__name');
  cardBandName.innerText = band;

  cardBandYear.classList.add('card-band__year');
  cardBandYear.innerText = year;

  cardTitleAlbum.classList.add('card-title__album');
  cardTitleAlbum.innerText = title;

  cardPrice.classList.add('card__price');
  cardPrice.innerText = `R$${price.toFixed(2)}`;

  cardButton.classList.add('card__button');
  cardButton.innerText = `Comprar`;

  divCard1.append(cardBandName, cardBandYear);
  divCard2.append(cardTitleAlbum, cardPrice);
  cardContainer.append(cardImage, divCard1, divCard2, cardButton);

  return cardContainer;
};

export const renderButtonsCategories = (categorie) => {
  const categorieList = document.querySelector('.gender__buttons');

  categorieList.innerHTML = '';

  categorie.forEach((categorie) => {
    const categorieButton = createCategorieButton(categorie);
    categorieList.appendChild(categorieButton);
  });
};

const createCategorieButton = (categorie) => {
  const buttonGender = document.createElement('button');

  buttonGender.innerText = categorie;

  buttonGender.classList.add('buttonsGender');

  return buttonGender;
};
