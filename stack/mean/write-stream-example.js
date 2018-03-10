var fs = require('fs');
var readStream = fs.createReadStream('foo.txt');
var writeStream = fs.createWriteStream('bar.txt');
// Essentially is creating a copy of a file.
readStream.pipe(writeStream);
