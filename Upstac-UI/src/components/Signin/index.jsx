import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import Error from "./../Alert/error";
import useStyles from "./styles";
import auth from "../../auth/auth";
import { LOGIN_API } from "../../utils/apis";
import axios from "axios";

export default function Signin(props) {
  const classes = useStyles();
  const [error, setError] = React.useState(false);

  function showErrorAlert(status) {
    setError(status);
    setTimeout(() => {
      setError(false);
    }, 4000);
  }

  async function submitLoginForm(e) {
    e.preventDefault();
    const data = {
      emailId: e.target.emailId.value,
      password: e.target.password.value,
    };

    const res = await axios
      .post(LOGIN_API, data, {
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
      auth.login(res.data.jwtToken);
      props.history.push("/dashboard");
    } else {
      showErrorAlert(true);
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
        <div className={classes.paper}>
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <form
            className={classes.form}
            onSubmit={(e) => {
              submitLoginForm(e);
            }}
          >
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
              Sign In
            </Button>
            <Grid container>
              <Grid item>
                <Link href="/signup" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </form>
        </div>
      </Container>
      {error ? (
        <Error open={error} message="Please provide valid credentials!" />
      ) : null}
    </React.Fragment>
  );
}
