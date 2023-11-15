import { MdClose } from "react-icons/md";
import { CartItemCard } from "./CartItemCard";
import styles from "./style.module.scss";

export const CartModal = ({
  cartList,
  setVisible,
  removeFavorite,
  setCount,
  handleClick,
}) => {
  const total = cartList.reduce((prevValue, product) => {
    return prevValue + product.price;
  }, 0);

  return (
    <div role="dialog" className={styles.dialog}>
      <div className={styles.container}>
        <div className={styles.header}>
          <h3 className="title three">Carrinho de compras</h3>
          <button
            aria-label="close"
            title="Fechar"
            onClick={() => setVisible(false)}
          >
            <MdClose size={20} />
          </button>
        </div>
        <div>
          <ul className={styles.listContent}>
            {cartList.map((product) => (
              <CartItemCard
                key={product.id}
                product={product}
                setCount={setCount}
                removeFavorite={removeFavorite}
              />
            ))}
          </ul>
        </div>
        <div className={styles.separator}></div>
        <div className={styles.box}>
          <div className={styles.card}>
            <span>Total</span>
            <span className=" colorPriceTwo">
              {total.toLocaleString("pt-BR", {
                style: "currency",
                currency: "BRL",
              })}
            </span>
          </div>
          <button onClick={handleClick}>Remover todos</button>
        </div>
      </div>
    </div>
  );
};
