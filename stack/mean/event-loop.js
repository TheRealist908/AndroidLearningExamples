console.log('one event loop cycle');
setTimeout(function() {
  console.log('different cycle');
}, 100);
console.log('same cycle');
