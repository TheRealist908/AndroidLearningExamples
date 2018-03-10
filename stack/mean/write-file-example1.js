var fs = require('fs');
var data = 'some file data';

// The {flag: 'wx'} is an optional flag: wx = 'error' if overwrite or 'a'
// to append the data to the file
fs.writeFile(__dirname + '/foo.txt', data, {flag: 'wx'}, function(error) {
  if (error) {
    return console.error(error.message);
  }
});
