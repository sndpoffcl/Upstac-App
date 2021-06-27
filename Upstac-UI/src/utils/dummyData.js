const booking = {
  id: 1,
  name: "John Doe",
  address: "John Doe",
  age: 40,
  gender: "Male",
  phoneNo: "9876543210",
  email: "example@auth.com",
  password: "12345",
  bookings: [
    {
      id: 1,
      trackingNo: "1234ABCD",
      status: "Booked for consultation",
      cost: 1234,
      testName: "BloodTest",
      testId: "AB12",
      testResults: "positive",
      feedback: "drink lots of water",
    },
    {
      id: 1,
      trackingNo: "1234ABCD",
      status: "Booked for consultation",
      cost: 1234,
      testName: "BloodTest",
      testId: "AB12",
      testResults: "positive",
      feedback: "drink lots of water",
    },
  ],
};

const tests = [
  {
    id: "AB231",
    testId: "65",
    name: "BloodTest",
    price: 1234,
    description:
      "Lorem ipsum dolor sit amet consectetur adipiscing elit, integer nam fringilla euismod mauris curae metus, ridiculus sodales fusce ligula molestie consequat.",
    imageUrl: "https://picsum.photos/536/354",
    isActive: true,
  },
  {
    id: "AB232",
    testId: "653",
    name: "BloodTest",
    price: 1234,
    description:
      "Lorem ipsum dolor sit amet consectetur adipiscing elit, integer nam fringilla euismod mauris curae metus.",
    imageUrl: "https://picsum.photos/536/354",
    isActive: true,
  },

  {
    id: "AB233",
    testId: "659",
    name: "BloodTest fail",
    price: 1234,
    description:
      "Lorem ipsum dolor sit amet consectetur adipiscing elit, integer nam fringilla euismod mauris curae metus, ridiculus sodales fusce ligula molestie consequat.",
    imageUrl: "https://picsum.photos/536/354",
    isActive: false,
  },
];

const loginData = {
  status: "SUCCESS",
  result: {
    accessToken: "",
    expiresAt: "2021-06-10 16:30:32",
    refreshToken: "",
    refreshExpiresAt: "2021-06-10 17:30:32",
  },
};

export { tests, booking, loginData };
