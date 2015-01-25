function assert(expr, msg) {
  msg = msg || ''
  if (!expr)
    throw new Error('assert: ' + msg);
}

var testThread = function() {
  var str;
  var th = new java.lang.Thread(function() {
    str = 'hoge'
    assert(th.isAlive());
  });
  th.start();
  th.join();

  assert(str == 'hoge');
  assert(!th.isAlive());
}

testThread();
