var fs = require('fs');
var fname;

// Add 'utf8' after the __filename variable to print in plain text
// Add {encoding: 'utf8'} after the __filename variable (more appropriate)
// I added using the arguments or defaulting to the current file if
// the argument was not found
if (process.argv[2] === undefined) {
  fname = __filename;
} else {
  fname = process.argv[2];
}
fs.readFile(fname, {encoding: 'utf8'}, function(error, data) {
  if (error) {
    return console.error(error.message);
  }
  console.log(data);
});
