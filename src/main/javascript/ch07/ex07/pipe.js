var byteArray = Java.type('byte[]');

function pipe(commands) {
  var pb = new java.lang.ProcessBuilder();
  var ps = commands.map(function(e, i, a) {
    return pb.command(e.split(/ /)).start();
  });
  var p = pipeTo(ps);
  plug(p.getInputStream(), java.lang.System.out);
  p.waitFor();
}

function pipeTo(processes) {
  for (var i = 0; i < processes.length - 1; i++) {
    plug(processes[i].getInputStream(), processes[i + 1].getOutputStream());
  }
  return processes.pop();
}

function plug(inputStream, outputStream) {
  new java.lang.Thread(function() {
    var input = new java.io.BufferedInputStream(inputStream);
    var output = new java.io.BufferedOutputStream(outputStream);
    var buf = new byteArray(1024);
    var len;
    try {
      while ((len = input.read(buf)) != -1)
        output.write(buf, 0, len);
    } catch (e) {
      e.printStackTrace();
    } finally {
      output.close();
    }
  }).start();
}


var commands = ['cat pipe.js', 'sort'];
pipe(commands);
