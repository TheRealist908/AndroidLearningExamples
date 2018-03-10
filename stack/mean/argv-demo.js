process.argv.forEach(function(value, index, args) {
  console.log('process.argv[' + index + '] = ' + value);
});
console.log('Currently executing file is ' + __filename);
console.log('It is located in '+ __dirname);

console.log('Starting in ' + process.cwd());
try {
  process.chdir('/');
} catch (error) {
  console.error('chdir: ' + error.message);
}

console.log('Current working directory is now ' + process.cwd());
