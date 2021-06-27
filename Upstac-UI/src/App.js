import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Signin from "./components/Signin";
import Dashboard from "./components/Dashboard";
import Signup from "./components/Signup";
import Profile from "./components/Profile";
import BookingHistory from "./components/BookingHistory";
import ProtectedRoute from "./utils/protectedRoute";
import { ThemeProvider } from "@material-ui/core";
import Navbar from "./components/Navbar";
import theme from "./theme/theme";
import "./styles/index.css";

function App() {
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <Router>
          <Switch>
            <Route path="/" exact component={Signin} />
            <ProtectedRoute
              path="/dashboard"
              exact
              component={(props) => (
                <React.Fragment>
                  <Navbar {...props} />
                  <Dashboard {...props} />
                </React.Fragment>
              )}
            />
            <ProtectedRoute
              path="/profile"
              exact
              component={(props) => (
                <React.Fragment>
                  <Navbar {...props} />
                  <Profile {...props} />
                </React.Fragment>
              )}
            />
            <ProtectedRoute
              path="/bookinghistory"
              exact
              component={(props) => (
                <React.Fragment>
                  <Navbar {...props} />
                  <BookingHistory {...props} />
                </React.Fragment>
              )}
            />
            <Route path="/signup" exact component={Signup} />
            <Route path="*" exact component={() => "404 Page not found!"} />
          </Switch>
        </Router>
      </ThemeProvider>
    </div>
  );
}

export default App;
