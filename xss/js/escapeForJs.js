//转义”\”或者替换成json
var escapeForJs = function(str){
 if(!str) return '';
 str = str.replace(/\\/g,'\\\\');
 str = str.replace(/"/g,'\\"');
}
