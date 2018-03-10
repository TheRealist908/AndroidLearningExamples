var fs = require('fs');
var data;

try {
  // Add 'utf8' after the __filename variable to print in plain text
  data = fs.readFileSync(__filename);
  console.log(data);
} catch (error) {
  console.error(error.message);
}
