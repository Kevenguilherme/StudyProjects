import styles from "./style.module.scss";
export const ProductCard = ({ product, addFavorite }) => {
  const { img, name, category, price } = product;
  return (
    <div>
      <li className={styles.card}>
        <div className={styles.imgBox}>
          <img className={styles.image} src={img} alt={name} />
        </div>
        <div className={styles.box}>
          <h2 className="title two">{name}</h2>
          <span className="paragraph color">{category}</span>
          <span className=" color">
            {price.toLocaleString("pt-BR", {
              style: "currency",
              currency: "BRL",
            })}
          </span>
          <button className="medium " onClick={() => addFavorite(product)}>
            Adicionar
          </button>
        </div>
      </li>
    </div>
  );
};
