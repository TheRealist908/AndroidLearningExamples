var EventEmitter = require('events').EventEmitter;
var emitter = new EventEmitter();

/* Example of an error that is not handled
emitter.emit('error', new Error('our error is bad and we feel bad'));
*/

// Example of an error that is handled
/*
emitter.on('error', function(error) {
  console.error(error.message);
});

emitter.emit('error', new Error('our error is bad and we feel bad'));
*/

// UncaughtExceptiion Event
process.on('uncaughtException', function(error) {
  console.error(error.message);
  process.exit(-1);
});

emitter.emit('error', new Error('our error is bad and we feel bad'));
