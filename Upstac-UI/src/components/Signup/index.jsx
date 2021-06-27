import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import useStyles from "./styles";
import auth from "../../auth/auth";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";
import Error from "./../Alert/error";

import { REGISTER_API } from "../../utils/apis";
import axios from "axios";
axios.defaults.headers.post["Content-Type"] =
  "application/x-www-form-urlencoded";

export default function Signup(props) {
  const classes = useStyles();
  const [error, setError] = React.useState(false);
  const [gender, setGender] = React.useState("female");

  function showErrorAlert(status) {
    setError(status);
    setTimeout(() => {
      setError(false);
    }, 4000);
  }

  async function registerUser(e) {
    e.preventDefault();
    const data = {
      name: e.target.name.value,
      address: e.target.address.value,
      phoneNumber: e.target.phoneNumber.value,
      gender: gender,
      emailId: e.target.emailId.value,
      password: e.target.password.value,
      active: true,
      roles: "customer, admin",
    };
    const res = await axios
      .post(REGISTER_API, data, {
        headers: {
          "Content-Type": "application/json",
          //"Access-Control-Allow-Origin": "*",
        },
      })
      .catch((err) => {
        showErrorAlert(true);
        new Error(err);
      });

    if (res && res.data && res.data.jwtToken) {
      auth.signup(res.data.jwtToken);
      props.history.push("/dashboard");
    } else {
      showErrorAlert(true);
      new Error("error!");
    }
  }

  React.useEffect(() => {
    if (auth.isAuthenticated()) {
      props.history.push("/dashboard");
    }
  }, [props.history]);

  return (
    <React.Fragment>
      <Container className="container" component="main" maxWidth="xs">
        <div className={classes.paper} onSubmit={(e) => registerUser(e)}>
          <Typography component="h1" variant="h5">
            Sign Up
          </Typography>
          <form className={classes.form}>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="name"
              label="Full Name"
              name="name"
              color="primary"
              autoFocus
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="address"
              label="Address"
              name="address"
              color="primary"
              autoComplete="address"
              autoFocus
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="phoneNumber"
              label="Phone No."
              name="phoneNumber"
              color="primary"
              autoComplete="phone"
              autoFocus
            />
            <FormControl component="fieldset">
              <FormLabel component="legend">Gender</FormLabel>
              <RadioGroup
                aria-label="gender"
                name="gender"
                value={gender}
                onChange={(e) => {
                  setGender(e.target.value);
                }}
              >
                <FormControlLabel
                  value="female"
                  control={<Radio />}
                  label="Female"
                />
                <FormControlLabel
                  value="male"
                  control={<Radio />}
                  label="Male"
                />
                <FormControlLabel
                  value="other"
                  control={<Radio />}
                  label="Other"
                />
              </RadioGroup>
            </FormControl>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="emailId"
              label="Email Address"
              name="emailId"
              color="primary"
              autoComplete="email"
              autoFocus
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              className={classes.submit}
              color="secondary"
              disableElevation
            >
              Sign Up
            </Button>
            <Grid container>
              <Grid item>
                <Link href="/" variant="body2">
                  {"Already have an account? Sign in"}
                </Link>
              </Grid>
            </Grid>
          </form>
        </div>
      </Container>
      <Error
        open={error}
        message="Error! Please check information or it's a server error"
      />
    </React.Fragment>
  );
}
