export const handleDarkMode = () => {
  const darkModeButton = document.querySelector('.darkMode__img');
  const htmlTag = document.querySelector('html');
  let theme = JSON.parse(localStorage.getItem('darkmode'));

  if (theme === null) {
    theme = false;
  }

  if (theme) {
    htmlTag.classList.add('dark-mode');
    darkModeButton.src = './src/assets/darkMode/sun.svg';
  }

  darkModeButton.addEventListener('click', () => {
    if (!theme) {
      htmlTag.classList.add('dark-mode');
      darkModeButton.src = './src/assets/darkMode/sun.svg';
      localStorage.setItem('darkmode', 'true');
      theme = !theme;
    } else {
      htmlTag.classList.remove('dark-mode');
      darkModeButton.src = './src/assets/darkMode/moon.svg';
      localStorage.setItem('darkmode', 'false');
      theme = !theme;
    }
  });
};
