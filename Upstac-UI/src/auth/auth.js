const TOKEN_NAME = "jwtToken";

class Auth {
  constructor() {
    let token = sessionStorage.getItem(TOKEN_NAME);
    if (token) {
      this.authenticated = true;
    } else {
      this.authenticated = false;
    }
  }

  login(jwtToken, cb = () => {}) {
    let token = sessionStorage.getItem(TOKEN_NAME);
    if (!token) {
      sessionStorage.setItem(TOKEN_NAME, jwtToken);
    }
    this.authenticated = true;
    cb();
  }

  signup(jwtToken, cb = () => {}) {
    sessionStorage.setItem(TOKEN_NAME, jwtToken);
    this.authenticated = true;
    cb();
  }

  logout(cb = () => {}) {
    sessionStorage.removeItem(TOKEN_NAME);
    this.authenticated = false;
    cb();
  }

  getToken() {
    if (this.authenticated) {
      return sessionStorage.getItem(TOKEN_NAME);
    }
    return null;
  }

  isAuthenticated() {
    return this.authenticated;
  }
}

export default new Auth();
