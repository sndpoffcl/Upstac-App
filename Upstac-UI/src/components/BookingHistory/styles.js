import { makeStyles } from "@material-ui/core/styles";
const useStyles = makeStyles({
  container: {
    display: "flex",
    flexWrap: "wrap",
  },
  root: {
    maxWidth: 324,
    minWidth: 310,
    margin: 10,
    border: "1px solid lightgray",
    borderRadius: "5px",
  },
  displayRow: {
    display: "flex",
    justifyContent: "space-between",
  },
  title: {
    fontSize: 14,
  },
  pos: {
    marginBottom: 12,
  },
});

export default useStyles;
