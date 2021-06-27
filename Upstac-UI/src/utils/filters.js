function filterTest(tests, testId) {
  return tests.filter((test) => test.id.includes(testId));
}
