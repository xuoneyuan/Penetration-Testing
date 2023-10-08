@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 表单
     * @param user
     * @return
     */
    @PostMapping("save")
    public String save(User user) {
        log.info("name={}, age={}", user.getName(), user.getAge());
        return JSON.toJSONString(user);
    }

    /**
     * json数据格式请求体
     * @param user
     * @return
     */
    @PostMapping("json")
    public String saveJson(@RequestBody User user) {
        log.info("user={}", user.toString());
        return JSON.toJSONString(user);
    }
}
