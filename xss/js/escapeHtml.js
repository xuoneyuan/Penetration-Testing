//转义掉<<和>>
var escapeHtml = function(str){
  str = str.replace(/>/g, '&lt;');
  str = str.replace(/>/g, '&gt;');
  return str;
}

escapeHtml(content);
