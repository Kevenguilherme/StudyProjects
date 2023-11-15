import { MdDelete } from "react-icons/md";
import styles from "./styles.module.scss";

export const CartItemCard = ({ product, setCount, removeFavorite }) => {
  const { id, img, name, price } = product;

  return (
    <li className={styles.cartContainer}>
      <div className={styles.image}>
        <img src={img} alt={name} />
      </div>
      <div className={styles.cartBox}>
        <h3 className="title bold">{name}</h3>
        <span className=" color">
          {price.toLocaleString("pt-BR", {
            style: "currency",
            currency: "BRL",
          })}
        </span>
      </div>
      <button
        className={styles.boxBtn}
        onClick={() => removeFavorite(id)}
        aria-label="delete"
        title="Remover item"
      >
        <MdDelete size={18} />
      </button>
    </li>
  );
};
