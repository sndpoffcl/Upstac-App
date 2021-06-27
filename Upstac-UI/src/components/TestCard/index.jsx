import React from "react";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import useStyles from "./styles";

export default function TestCard(props) {
  const classes = useStyles();
  const { test } = props;
  return (
    <Box className={classes.box} key={test.id} m={1}>
      <Card className={classes.root} elevation={0}>
        <CardMedia
          component="img"
          alt={test.name}
          height="200"
          image={test.imageURL}
          title={test.name}
        />
        <CardContent>
          <Box className={classes.head}>
            <Typography gutterBottom variant="h5" component="h2">
              <Box fontWeight="fontWeightBold">{test.name}</Box>
            </Typography>
            <Box pb={2}>
              <Typography variant="body2" color="textSecondary" component="p">
                <Box fontWeight="fontWeightBold">Test Id</Box>
              </Typography>
              <Typography color="primary" variant="h5" component="h2">
                <Box fontWeight="fontWeightBold">{test.testCode}</Box>
              </Typography>
            </Box>
          </Box>
          <Typography
            gutterBottom
            variant="body2"
            color="textSecondary"
            component="p"
          >
            {test.description}
          </Typography>
          <Box pt={2}>
            <Typography variant="body2" color="textSecondary" component="p">
              <Box fontWeight="fontWeightBold">Test Cost</Box>
            </Typography>
            <Typography variant="h5" component="h2">
              <Box fontWeight="fontWeightBold">{test.price}</Box>
            </Typography>
          </Box>
        </CardContent>
        <CardActions>
          <Button
            size="small"
            variant="contained"
            color="secondary"
            onClick={() => {
              props.booktest(test);
            }}
            disableElevation
          >
            Book Now
          </Button>
        </CardActions>
      </Card>
    </Box>
  );
}
