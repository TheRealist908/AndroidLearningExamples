var fs = require('fs');
var stream = fs.createReadStream('foo.txt');

// data event handler
stream.on('data', function(data) {
  var chunk = data.toString();
  process.stdout.write(chunk);
});

stream.on('end', function() {
  console.log();
});
