import { useState } from "react";
import { Header } from "../../components/Header";
import { ProductList } from "../../components/ProductList";
import { useEffect } from "react";
import { productApi } from "../../services/api";
import { LoadingList } from "../../components/LoadingList";
import { CartModal } from "../../components/CartModal";
import { toast } from "react-toastify";

export const HomePage = ({
  addFavorite,
  cartList,
  setCartList,
  count,
  setCount,
  removeFavorite,
}) => {
  const [isVisible, setVisible] = useState(false);

  const [loading, setLoading] = useState(false);
  const [productList, setProductList] = useState([]);

  useEffect(() => {
    const getProduct = async () => {
      try {
        setLoading(true);
        const { data } = await productApi.get("/products");
        setProductList(data);
      } catch (error) {
        toast.error("Erro no servidor");
      } finally {
        setLoading(false);
      }
    };

    getProduct();
  }, []);

  const handleClick = () => {
    setCartList([]);
    localStorage.clear();
    setVisible(false);
    setCount(0);

    toast.success("Item removido com sucesso!");
  };

  return (
    <>
      {isVisible ? (
        <CartModal
          cartList={cartList}
          setVisible={setVisible}
          removeFavorite={removeFavorite}
          setCount={setCount}
          handleClick={handleClick}
        />
      ) : null}
      <Header setVisible={setVisible} cartList={cartList} count={count} />
      <main className="container">
        {loading ? (
          <LoadingList />
        ) : (
          <ProductList productList={productList} addFavorite={addFavorite} />
        )}
      </main>
    </>
  );
};
