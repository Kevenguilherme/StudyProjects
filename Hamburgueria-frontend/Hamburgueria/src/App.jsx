import { useEffect, useState } from "react";
import { HomePage } from "./pages/HomePage";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./styles/index.scss";

function App() {
  const localFavorites = localStorage.getItem("@CARTLIST");

  const [cartList, setCartList] = useState(
    localFavorites ? JSON.parse(localFavorites) : []
  );
  const [count, setCount] = useState(0);

  const addFavorite = (productAdd) => {
    const hasProducts = cartList.some((cart) => cart.id === productAdd.id);

    if (!hasProducts) {
      setCartList([...cartList, productAdd]);
      setCount((count) => count + 1);
      toast.success("Produto adicionado aos favoritos!");
    } else {
      toast.error("Produto já  adicionado aos favoritos!");
    }
  };

  const closeModal = () => {
    setModalProduct(null);
  };

  const removeFavorite = (productId) => {
    const newProductsFavorites = cartList.filter(
      (productFav) => productFav.id !== productId
    );
    setCartList(newProductsFavorites);

    setCount((count) => count - 1);

    toast.success("Item removido!");
  };

  useEffect(() => {
    localStorage.setItem("@CARTLIST", JSON.stringify(cartList));
  }, [cartList]);

  return (
    <>
      <HomePage
        addFavorite={addFavorite}
        cartList={cartList}
        setCartList={setCartList}
        count={count}
        setCount={setCount}
        removeFavorite={removeFavorite}
      />

      <ToastContainer position="bottom-right" />
    </>
  );
}

export default App;
