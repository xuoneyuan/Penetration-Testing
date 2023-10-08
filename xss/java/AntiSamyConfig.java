@Configuration
public class AntiSamyConfig {

    /**
     * 配置xss过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean create() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new XssFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
