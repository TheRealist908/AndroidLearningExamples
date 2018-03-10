var mongoose = require('mongoose');
var Employee = mongoose.model('Employee');

// Export functions
exports.getEmployees = getEmployees;
exports.getEmployee = getEmployee;

// getEmployees
function getEmployees (callback) {
  Employee.find().sort('name.last').exec(callback);
}

// getEmployee
function getEmployee (employeeId, callback) {
  Employee.findOne({
    id: employeeId
  }).populate('team').exec(callback);
}
