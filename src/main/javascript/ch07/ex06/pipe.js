#!/usr/bin/env jjs

function pipe(commands) {
  commands.forEach(function(e, i, a) {
    if ($OUT === undefined)
      $EXEC(e);
    else
      $EXEC(e, $OUT);
  });
  print($OUT);
}


var commands = ['cat pipe.js', 'sort'];
pipe(commands);
