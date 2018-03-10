var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var db = mongoose.connection;
var dbUrl = 'mongodb://localhost:27017/humanresources';

var TeamSchema = new Schema({
  name: {
    type: String,
    required: true
  }
});

var Team = mongoose.model('Team', TeamSchema);

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

function insertTeams(callback) {
  Team.create([{
    name: 'Product Development'
  }, {
    name: 'Dev Ops'
  }, {
    name: 'Accounting'
  }], function (error, pd, devops, acct) {
    if (error) {
      return callback(error);
    } else {
      console.info('teams successfully added');
      callback(null, pd, devops, acct);
    }
  });
}

function insertEmployees (pd, devops, acct, callback) {
  Employee.create([{
    name: {
      first: 'John',
      last: 'Adams'
    },
    team: pd[0]._id,
    address: {
      lines: ['2 Lincoln Memorial Cir NW'],
      zip: 20037
    }
    }, {
    name: {
      first: 'Thomas',
      last: 'Jefferson'
    },
    team: pd[1]._id,
    // team: devops._id,
    address: {
      lines: ['1600 Pennsylvania Avenue', 'White House'],
      zip: 20500
    }
    }, {
    name: {
      first: 'James',
      last: 'Madison'
    },
    team: pd[2]._id,
    address: {
      lines: ['2 15th St NW', 'PO Box 8675309'],
      zip: 20007
    }
    }, {
    name: {
      first: 'James',
      last: 'Monroe'
    },
    team: pd[2]._id,
    address: {
      lines: ['1850 West Basin Dr SW', 'Suite 210'],
      zip: 20242
    }
    }], function (error, johnadams) {
    if (error) {
      return callback(error);
    } else {
      console.log('employees successfully added');
      callback(null, {
        team: pd,
        employee: johnadams
      });
    }
  })
}

/* function retrieveEmployees({
  Employee.find({
    'name.first' : /J/i
  }, function (error,results) {
    if (error) {
      return callback(error);
    } else {
      console.log('*** Multiple Employees Result ***');
      console.dir(results);
      callback(null, data);
    }
  });
}

function retrieveEmployee(data, callback) {
  db.on('error', function () {
    if (err) {
      return console.log('Problem connecting to database ' + error);
    }
  });

  Employee.findOne({
    _id: data.Employee._id
  }).populate('team').exec(function(error, result) {
    if (error) {
      return callback (error);
    } else {
      console.log('*** Single Employee Result ***');
      console.dir(result);
      callback(null, data);
    }
  });
}*/

db.on('error', function() {
  if (err) {
    return console.log('there was a problem connecting to the database!' + err);
  }
});

mongoose.connect(dbUrl, function (err) {
  if (err) {
    return console.log('there was a problem connecting to the database!' + err);
  }
  console.log('connected');

  insertTeams(function (err, pd, devops, acct) {
    if (err) {
      return console.log(err)
    }
    insertEmployees(pd, devops, acct, function (err, result) {
      if (err) {
        console.error(err);
      } else {
        console.info('database activity complete')
      }
      db.close();
      process.exit();
    });
  });

  /*retrieveEmployee(function (err, result) {
    retrieveEmployees(result, function (err, result) {
      if (err) {
        console.error(err);
      } else {
        console.info('database activity complete');
      }
    });
    db.close();
    process.exit();
  });*/
});
