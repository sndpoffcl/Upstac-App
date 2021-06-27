import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  profileContainer: {
    display: "flex",
    justifyContent: "center",
    height: "100%",
    alignItems: "center",
    padding: "5%",
  },
  paper: {
    padding: theme.spacing(4),
    maxWidth: 324,
    width: 324,
    border: "1px solid lightgray",
    borderRadius: "1%",
  },
  head: {
    color: "gray",
  },
  personal: {
    display: "flex",
    justifyContent: "space-between",
  },
}));

export default useStyles;
