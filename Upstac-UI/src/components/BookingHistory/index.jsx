import React from "react";
import { booking } from "../../utils/dummyData";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";

import useStyles from "./styles";
import { Box } from "@material-ui/core";

export default function BookingHistory() {
  const classes = useStyles();
  const { bookings } = booking;
  return (
    <div className={classes.container}>
      {bookings.map((book) => {
        return (
          <Card className={classes.root} elevation={0}>
            <CardContent>
              <Box pb={2}>
                <Typography
                  className={classes.title}
                  color="textSecondary"
                  gutterBottom
                >
                  <Box fontWeight="fontWeightBold">Test Name</Box>
                </Typography>
                <Typography variant="h5" component="h2">
                  <Box fontWeight="fontWeightBold">{book.testName}</Box>
                </Typography>
              </Box>
              <Box className={classes.displayRow} pb={1}>
                <Box>
                  <Typography className={classes.pos}>
                    <Typography color="textSecondary" variant="body2">
                      <Box fontWeight="fontWeightBold">Test Id</Box>
                    </Typography>
                    <Box fontWeight="fontWeightBold">{book.testId}</Box>
                  </Typography>
                </Box>
                <Box>
                  <Typography className={classes.pos}>
                    <Typography color="textSecondary" variant="body2">
                      <Box fontWeight="fontWeightBold">Test Cost</Box>
                    </Typography>
                    <Box fontWeight="fontWeightBold">{book.cost}</Box>
                  </Typography>
                </Box>
              </Box>
              <Box pb={1}>
                <Typography className={classes.pos}>
                  <Typography color="textSecondary" variant="body2">
                    <Box fontWeight="fontWeightBold">Status</Box>
                  </Typography>
                  <Box fontWeight="fontWeightBold">{book.status}</Box>
                </Typography>
              </Box>
              <Box pb={1}>
                <Typography className={classes.pos}>
                  <Typography color="textSecondary" variant="body2">
                    <Box fontWeight="fontWeightBold">Test Result</Box>
                  </Typography>
                  <Box fontWeight="fontWeightBold">{book.testResults}</Box>
                </Typography>
              </Box>
              <Box>
                <Typography className={classes.pos}>
                  <Typography color="textSecondary" variant="body2">
                    <Box fontWeight="fontWeightBold">Feedback</Box>
                  </Typography>
                  <Box fontWeight="fontWeightBold">{book.feedback}</Box>
                </Typography>
              </Box>
            </CardContent>
          </Card>
        );
      })}
    </div>
  );
}
