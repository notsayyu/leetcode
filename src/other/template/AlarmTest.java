package other.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by dsy
 * @Classname AlarmTest
 * @Description TODO
 * @Date 2022/10/24 11:14
 */
public class AlarmTest {

    public static void main(String[] args) {
        List<Alarm> alarmList = new ArrayList<>();
        Alarm wechat = new WeChatAlarm();
        Alarm ding = new DingAlarm();
        alarmList.add(wechat);
        alarmList.add(ding);
        for (Alarm alarm : alarmList) {
            alarm.alarmMsg("test");
        }
        System.out.println("====");
    }
}
