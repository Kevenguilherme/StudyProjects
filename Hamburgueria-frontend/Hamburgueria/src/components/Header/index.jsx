import { useState } from "react";
import Logo from "../../assets/Logo.svg";
import { MdSearch, MdShoppingCart } from "react-icons/md";
import styles from "./style.module.scss";

export const Header = ({ setVisible, count }) => {
  return (
    <div className={styles.container}>
      <div className={styles.headerContent}>
        <img src={Logo} alt="Logo Kenzie Burguer" />

        <div>
          <button
            className={styles.cartButton}
            onClick={() => setVisible(true)}
          >
            <MdShoppingCart size={22} />
            <span className={styles.cartCount}>{count}</span>
          </button>
        </div>
      </div>
    </div>
  );
};
