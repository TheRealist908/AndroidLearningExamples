var mongoose = require('mongoose');
mongoose.set('debug', true);
var db = mongoose.connection;
var dbUrl = 'mongodb://localhost:27017/humanresources';
var Schema = mongoose.Schema;

var TeamSchema = new Schema({
  name: {
    type: String,
    required: true
  }
});

var Team = mongoose.model('Team',TeamSchema);

var EmployeeSchema = new Schema({
  name: {
    first: {
      type: String,
      required: true
    },
    last: {
      type: String,
      required: true
    }
  },
  team: {
    type: Schema.Types.ObjectId,
    ref: 'Team'
  },
  image: {
    type: String,
    default: 'images/user.png'
  },
  address: {
    lines: {
      type: [String]
    },
    zip: {
      type: String
    }
  }
});
var Employee = mongoose.model('Employee', EmployeeSchema);

function getTeam(teamId) {
  db.on('error', function () {
    if (err) {
      return console.log('Problem connecting to database ' + error);
    }
  });
}

function printEmployee(employee) {
  console.log('employee is %s %s', employee.name.first, employee.name.last);
}
mongoose.connect(dbUrl, function(err) {
  if (err) {
    return console.log('there was a problem connecting to the database' + err);
  }
  Employee.findOne({'name.first' : /J/i}, function(err, data) {
    if (err) return console.log(err);
    console.log('%s %s is in team %s', data.name.first, data.name.last, data.team);
    db.close();
  });
  Employee.find({'name.first' : /J/i}, function(err,data) {
    if (err) return console.log(err);
    data.forEach(printEmployee);
    data.forEach(function (employee) {
      Team.findById({_id: employee.team.toString()}, function(err, result) {
        if (err) return console.log(err);
        console.log(result.name.type);
      });
    });
    db.close();
    process.exit();
  });
})
