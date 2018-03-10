var mongoose = require('mongoose');
var dbUrl = 'mongodb://localhost:27017/hrapp';

mongoose.connect(dbUrl);

// Cloos the Mongoose connection on Control+C
process.on('SIGINT', function() {
  mongoose.connection.close(function () {
    console.log('Mongoose default connection disconnected');
    process.exit(0);
  });
});

require('../models/employee');
require('../models/team');
