import React from "react";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";
import useMediaQuery from "@material-ui/core/useMediaQuery";
import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import { useTheme } from "@material-ui/core/styles";

import useStyles from "./styles";

export default function ResponsiveDialog(props) {
  const theme = useTheme();
  const classes = useStyles();
  const fullScreen = useMediaQuery(theme.breakpoints.down("sm"));
  const { test } = props;
  return (
    <div>
      <Dialog
        classes={{ paper: classes.dialogContainer }}
        fullScreen={fullScreen}
        open={props.dialogStatus}
        onClose={() => props.setDialogStatus(false)}
        aria-labelledby="responsive-dialog-title"
      >
        <DialogTitle id="responsive-dialog-title">
          Booking Confirmation!
        </DialogTitle>
        <DialogContent>
          <DialogContentText>
            <Box className={classes.displyRow} pb={2}>
              <Box pb={2}>
                <Typography variant="body2" component="p">
                  <Box fontWeight="fontWeightBold">Test Name</Box>
                </Typography>
                <Typography color="primary" variant="h5" component="h2">
                  <Box fontWeight="fontWeightBold">{test.name}</Box>
                </Typography>
              </Box>
              <Box pb={2}>
                <Typography variant="body2" component="p">
                  <Box fontWeight="fontWeightBold">Test Id</Box>
                </Typography>
                <Typography color="primary" variant="h5" component="h2">
                  <Box fontWeight="fontWeightBold">{test.testId}</Box>
                </Typography>
              </Box>
            </Box>
            <Box pb={2}>
              <Typography variant="body2" component="p">
                <Box fontWeight="fontWeightBold">Test Price</Box>
              </Typography>
              <Typography color="primary" variant="h5" component="h2">
                <Box fontWeight="fontWeightBold">{test.price}</Box>
              </Typography>
            </Box>
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button
            autoFocus
            onClick={() => props.setDialogStatus(false)}
            color="primary"
          >
            Close
          </Button>
          <Button autoFocus variant="contained" elevation={0} color="secondary">
            Book
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
