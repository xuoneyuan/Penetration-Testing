//支持指定白名单
var xssFilter = function(html){
    if(!html) return '';

    var xss = require('xss');
    var ret = xss(html, {
        whiteList:{
            img: ['src'],
            a: ['href'],
            font: ['size', 'color']
        },
        onIgnoreTag: function(){
            return '';
        }
    });


    console.log(html, ret);

    return ret;
};
