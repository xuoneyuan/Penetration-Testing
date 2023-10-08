//转义”\”或者替换成json
var escapeHtmlProperty = function(str){
  str = str.replace(/"/g, '&quto;');
  str = str.replace(/'/g, '&#39;');
  str = str.replace(/ /g, '&#32;');
  return str;
}

escapeHtml(content);
