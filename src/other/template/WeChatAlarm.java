package other.template;

/**
 * @author by dsy
 * @Classname WeChatAlarm
 * @Description TODO
 * @Date 2022/10/24 11:13
 */
public class WeChatAlarm implements Alarm {
    @Override
    public void alarmMsg(String text) {
        System.out.println("微信警告！");
    }
}
