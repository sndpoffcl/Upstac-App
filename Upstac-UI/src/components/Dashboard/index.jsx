import React from "react";
//import { tests } from "./../../utils/dummyData";
import TestCard from "../TestCard";
import Dialog from "../Dialog";
import { GET_ALL_TEST_API } from "../../utils/apis";
import auth from "../../auth/auth";
import axios from "axios";
import "./dashboard.css";

function Dashboard(props) {
  const [tests, setTests] = React.useState([]);
  const [bookingTest, setBookingTest] = React.useState({});
  const [dialogStatus, setDialogStatus] = React.useState(false);
  const [isLoading, setIsLoading] = React.useState(false);

  function bookTest(test) {
    setBookingTest(test);
    setDialogStatus(true);
  }

  React.useEffect(() => {
    setIsLoading(true);
    axios
      .get(GET_ALL_TEST_API, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${auth.getToken()}`,
        },
      })
      .then((res) => {
        setTests(res.data);
        setIsLoading(false);
      })
      .catch((err) => {
        console.log("API ERROR");
        setIsLoading(false);
        new Error(err);
      });
  }, []);

  return (
    <div>
      {isLoading ? (
        "Loading..."
      ) : (
        <div className="dashboard-container">
          {tests &&
            tests.map((test) => {
              if (test.available) {
                return (
                  <TestCard key={test.id} test={test} booktest={bookTest} />
                );
              }
              return null;
            })}
        </div>
      )}
      <Dialog
        test={bookingTest}
        dialogStatus={dialogStatus}
        setDialogStatus={setDialogStatus}
      />
    </div>
  );
}

export default Dashboard;
