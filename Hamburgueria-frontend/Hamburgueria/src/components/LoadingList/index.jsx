import styles from "./style.module.scss";

export const LoadingList = () => {
  return (
    <div className="container">
      <div className={styles.loadingList}>
        <div></div>
        <div></div>
        <div></div>
        <div></div>
        <div></div>
        <div></div>
      </div>
    </div>
  );
};
