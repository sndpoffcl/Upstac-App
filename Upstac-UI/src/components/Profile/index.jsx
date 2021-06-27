import React from "react";
import { booking } from "../../utils/dummyData";
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Paper";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import useStyles from "./styles";

export default function Profile(props) {
  const classes = useStyles();

  return (
    <div className={classes.profileContainer}>
      <Paper className={classes.paper} elevation={0}>
        <Box pb={3}>
          <Typography component="h1" variant="h5">
            <Box fontWeight="fontWeightBold">User Profile</Box>
          </Typography>
        </Box>
        <Box pb={3}>
          <Typography component="p" variant="body1">
            <Box className={classes.head}>Name</Box>
            <Box fontWeight="fontWeightBold">{booking.name}</Box>
          </Typography>
        </Box>
        <Box pb={3}>
          <Typography component="p" variant="body1">
            <Box className={classes.head}>Address</Box>
            <Box fontWeight="fontWeightBold">{booking.address}</Box>
          </Typography>
        </Box>
        <Box className={classes.personal} pb={4}>
          <Typography component="p" variant="body1">
            <Box className={classes.head}>Age</Box>
            <Box fontWeight="fontWeightBold">{booking.age}</Box>
          </Typography>
          <Typography component="p" variant="body1">
            <Box className={classes.head}>Gender</Box>
            <Box fontWeight="fontWeightBold">{booking.gender}</Box>
          </Typography>
        </Box>
        <Box className={classes.personal} pb={4}>
          <Typography component="p" variant="body1">
            <Box className={classes.head}>Password</Box>
            <Box fontWeight="fontWeightBold">{booking.password}</Box>
          </Typography>
        </Box>
        <Button
          fullWidth
          variant="contained"
          color="secondary"
          disableElevation
          onClick={() => {
            props.history.push("/bookinghistory");
          }}
        >
          Booking History
        </Button>
      </Paper>
    </div>
  );
}
