//转义”&quto; 即转义掉双引号，'转义掉单引号
var escapeHtmlProperty = function(str){
  str = str.replace(/"/g, '&quto;');
  str = str.replace(/'/g, '&#39;');
  str = str.replace(/ /g, '&#32;');
  return str;
}

escapeHtml(content);
