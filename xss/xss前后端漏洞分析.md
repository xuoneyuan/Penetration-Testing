## XSS（Cross Site Scripting）跨站脚本攻击

### XSS原理
- 攻击者对含有漏洞的服务器发起XSS攻击（注入JS代码）
- 诱使受害者打开受到攻击的服务器URL
- 受害者在Web浏览器中打开URL，恶意脚本执行

### XSS分类
1. 反射型（url参数直接注入）
2. 存储型（存储到DB后读取时注入）
3. DOM型 (不经过后端服务处理，不存储数据库)

### XSS注入点
#### HTML节点内容
<div>#{content}</div>

注入点 <div><script>alert(1)</script></div>
#### HTML属性(提前终止属性)
<img src="#{image}" />

注入点<img src="1" οnerrοr="alert(1)"/> 

### XSS简单预防策略
#### 对 html 标签进行字符替换
~~~
replaceAll("<script", "");

存在问题：\
 大小写问题
优化升级：\
  正则表达式\
其他问题：\
 反替换<scr<scriptipt ——> <script
~~~
#### 对 html 字符转义或是半角转全角字符
~~~
{ "<", ">", "\""}
转义：
{ "&lt;", "&gt;", "&quot;"})
全角：
{ "＜", "＞", "\＂"}

新场景：\
 页面中需要根据某个参数生成文字链接\
存在问题：\
 a 标签的 href 属性 javascript：\
其他问题：\
 针对 json 字符串的场景如何公用的问题
~~~
### XSS漏洞预防策略最佳实践
1. 输入环节
- 页面限制输入长度、特殊字符限制，后端代码限制输入长度、处理特殊字符
- Filter 过滤器统一处理（自定义处理规则、使用 Apache Text、使用 Owasp AntiSamy）
2. Cookie 防护
- cookie 设置 httponly，一般 servlet 容器默认 httponly 为 true
- resp.setHeader("SET-COOKIE", "JSESSIONID=" + request.getSession().getId()+ "; HttpOnly");
3. X-Frame-Options 响应头 （是否允许frame、iframe等标记）
- DENY 不允许、SAMEORIGIN 可在相同域名页面的 frame 中展示、ALLOW-FROM uri 可在指定页的 frame 中展示
- add_header X-Frame-Options SAMEORIGIN; //在nginx的 http 或 server 节点中配置即可
- 通过 Filter 设置  resp.setHeader("x-frame-options","SAMEORIGIN");
4. 输出环节
- OWASP ESAPI for Java
- 显示时对字符进行转义处理，各种模板都有相关语法，注意标签的正确使用
eg:\

~~~
thymeleaf
<span th:utext="${ result }"></span>---><span th:text="${ result }"></span>
<!-- utext 与 text 区别 -->

JSP
<c:out value=" ${ content }"  escapeXml="false" />---><c:out value=" ${ content }"/> <!-- escapeXml默认true -->
~~~
### 后端服务编码实践
