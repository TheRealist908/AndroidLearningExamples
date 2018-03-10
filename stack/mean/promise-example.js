var fs = require('fs');
var promise = new Promise(function(resolve, reject) {
  fs.readFile('README.txt', 'utf8',function(error, data) {
    if (error) {
      return reject(error);
    } else if (data.length < 1) {
      return reject('no data found');
    }
    resolve(data);
    // Since the length of the file is greater than 0 bytes
    // the 'then' method is called. Chaining the 'then' results in
    // multiple calls to do something.
    promise.then(function(result) {
      console.log(result);
      return 'THE END!';
    }).then(function(result) {
      console.log(result);
      return 'THE FINAL END!';
    }).then(function(result) {
      console.log(result);
    }).catch(function(error) {
      console.error(error.message);
    });
  });
});
