var mysql = require('mysql');
var pool = mysql.createPool({
  host: '127.0.0.1',
  port: 3306,
  user: 'deanmarsh',
  password: 'Testing123',
  database: 'hrapp',
  connectionLimit: 20,
  queueLimit: 100,
  waitForConnections: true
});


pool.getConnection(function(error, connection) {
  if (error) {
    return console.error(error.message);
  }
  console.log('successfully connected!');

  // Drop the table if it exists
  var dropSql = 'DROP TABLE IF EXISTS Presidents';
  connection.query(dropSql, function(error, results) {
    if (error) {
      return console.error(error.message);
    }
    console.log('Table dropped!');

    // Create the table
    var createSql = 'CREATE TABLE Presidents (' +
              'Id INT UNSIGNED NOT NULL AUTO_INCREMENT,' +
              'Name VARCHAR(100) NOT NULL,' +
              'Terms INT UNSIGNED NOT NULL,' +
              'PRIMARY KEY(Id))';
    connection.query(createSql, function(error, results) {
      if (error) {
        return console.log(error.message);
      }
      console.log('successfully created table!');

        // Insert some data
        var insertSql = 'INSERT INTO Presidents (Name, Terms) VALUES' +
                        '(\'Bill Clinton\', 2),' +
                        '(\'George W bush\', 2)';
        connection.query(insertSql, function(error, results) {
          if (error) {
            return console.error(error.message);
          }

        var selectSql = 'SELECT * from Presidents';
        connection.query(selectSql, function(error, results) {
          if (error) {
            return console.log(error.message);
          }
          console.log('results of SELECT:');
          console.log(JSON.stringify(results, null, 2));

          if (this.connection) {
            connection.release();
          }

          process.exit();
        });
      });
    });
  });
});
