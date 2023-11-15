import { ProductCard } from "./ProductCard";
import styles from "./style.module.scss";

export const ProductList = ({ productList, addFavorite }) => {
  return (
    <section>
      <div>
        <ul className={styles.productList}>
          {productList.map((product) => (
            <ProductCard
              key={product.id}
              product={product}
              addFavorite={addFavorite}
            />
          ))}
        </ul>
      </div>
    </section>
  );
};
