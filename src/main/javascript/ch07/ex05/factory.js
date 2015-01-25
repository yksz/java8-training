function newArrayList() {
  var arr = new (Java.extend(java.util.ArrayList)) {
    add: function(x) {
      print('Adding ' + x);
      return Java.super(arr).add(x);
    }
  }
  return arr;
}

function assert(expr, msg) {
  msg = msg || ''
  if (!expr)
    throw new Error('assert: ' + msg);
}


var arr1 = newArrayList();
arr1.add(1);
assert(arr1.size() == 1);
assert(arr1[0] == 1);

var arr2 = newArrayList();
arr2.add(1);
arr2.add(2);
assert(arr2.size() == 2);
assert(arr2[0] == 1);
assert(arr2[1] == 2);
