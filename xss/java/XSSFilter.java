public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        //注解配置的是urlPatterns="/*"(过滤所有请求),所以这里对不需要过滤的静态资源url,作忽略处理(大家可以依照具体需求配置)
        String[] exclusionsUrls = {".js", ".gif", ".jpg", ".png", ".css", ".ico"};
        for (String str : exclusionsUrls) {
            if (path.contains(str)) {
                chain.doFilter(request, response);
                return;
            }
        }
        chain.doFilter(new XssRequestWrapper(httpServletRequest), response);
    }
}
