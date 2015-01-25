var b = new java.math.BigInteger('1234567890987654321');
print(b); // => 1234567890987654400
var m = b.mod(java.math.BigInteger.TEN);
print(m); // => 1
