import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles({
  root: {
    maxWidth: 345,
  },
  box: {
    border: "1px solid lightgray",
    borderRadius: "1%",
  },
  head: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },
});

export default useStyles;
