#!/usr/bin/env jjs

var env = $ENV;
for (var key in env) {
  print(key + '=' + env[key]);
}
