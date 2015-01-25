var String = java.lang.String;
var StandardCharsets = java.nio.charset.StandardCharsets;
var Files = java.nio.file.Files;
var Paths = java.nio.file.Paths;
var FXCollections = javafx.collections.FXCollections;
var PieChart = javafx.scene.chart.PieChart;

var contents = new String(Files.readAllBytes(Paths.get('data.json')), StandardCharsets.UTF_8);
var data = [];
JSON.parse(contents).forEach(function(e, i, a) {
  data.push(new PieChart.Data(e.name, parseInt(e.value)));
});
var pieChartData = FXCollections.observableArrayList(data);
var chart = new PieChart(pieChartData);
chart.setTitle("Imported Fruits");

$STAGE.scene = new javafx.scene.Scene(chart);
$STAGE.title = 'Imported Fruits';
$STAGE.width = 500;
$STAGE.height = 500;
