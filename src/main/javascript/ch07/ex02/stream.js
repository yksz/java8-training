var String = java.lang.String;
var StandardCharsets = java.nio.charset.StandardCharsets;
var Files = java.nio.file.Files;
var Paths = java.nio.file.Paths;
var Arrays = java.util.Arrays;

var contents = new String(Files.readAllBytes(Paths.get('alice.txt')), StandardCharsets.UTF_8);
var words = Arrays.asList(contents.split(/[^a-zA-Z]/));
var count = words.stream()
                 .filter(function(w) { return w.length() > 12; })
                 .sorted()
                 .distinct()
                 .forEach(function(w) { print(w) });
