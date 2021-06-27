import React from "react";
import Snackbar from "@material-ui/core/Snackbar";
import MuiAlert from "@material-ui/lab/Alert";

function Alert(props) {
  return <MuiAlert elevation={6} variant="filled" {...props} />;
}

export default function Success(props) {
  <Snackbar open={props.open} autoHideDuration={6000}>
    <Alert severity="success">{props.message}</Alert>
  </Snackbar>;
}
