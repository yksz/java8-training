#!/usr/bin/env jjs

var BufferedReader = java.io.BufferedReader;
var InputStreamReader = java.io.InputStreamReader;
var System = java.lang.System;

var input;
if (arguments[0] !== undefined) {
  input = arguments[0];
} else if ($ENV.AGE !== undefined) {
  input = $ENV.AGE;
} else {
  print('Please enter your age?');
  var r = new BufferedReader(new InputStreamReader(System.in));
  input = r.readLine();
}

var age = parseInt(input);
if (isNaN(age) || age < 0) {
  throw new Error("Unknown age: ${input}");
}
print("Next year, you will be ${age + 1} years old");
