package other.template;

/**
 * @author by dsy
 * @Classname DingAlarm
 * @Description TODO
 * @Date 2022/10/24 11:13
 */
public class DingAlarm implements Alarm {
    @Override
    public void alarmMsg(String text) {
        System.out.println("钉钉警告");
    }
}
