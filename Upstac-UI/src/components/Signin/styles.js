import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    padding: "5%",
    border: "1px solid lightgray",
    borderRadius: "1%",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: "#ed3d35",
  },
  form: {
    width: "100%",
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    color: "white",
  },
}));

export default useStyles;
