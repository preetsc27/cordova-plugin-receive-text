var exec = require("cordova/exec");

var preet = function() {};

preet.prototype.listenForTextIntents = function(arg0, success, error) {
  exec(success, error, "textReceive", "listenForTextIntents", [arg0]);
};
preet.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins = new preet();
  return window.plugins;
};
cordova.addConstructor(preet.install);
