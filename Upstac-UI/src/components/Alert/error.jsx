import React from "react";
import Snackbar from "@material-ui/core/Snackbar";
import MuiAlert from "@material-ui/lab/Alert";

function Alert(props) {
  return <MuiAlert elevation={6} variant="filled" {...props} />;
}

export default function Success(props) {
  return (
    <Snackbar open={props.open} autoHideDuration={4000}>
      <Alert severity="error">{props.message}</Alert>
    </Snackbar>
  );
}
