var escapeForJs = function(str){
 if(!str) return '';
 str = str.replace(/\\/g,'\\\\');
 str = str.replace(/"/g,'\\"');
}
