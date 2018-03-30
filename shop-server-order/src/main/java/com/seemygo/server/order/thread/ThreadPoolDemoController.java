package com.seemygo.server.order.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*import com.kuke.auth.regist.domain.UserActionLog;
import com.kuke.auth.regist.domain.UserListenLog;
import com.kuke.auth.regist.service.RegistServiceImpl;
import com.kuke.core.base.action.AbstractActionBean;*/

/**
 * @Author:zxj
 * @Desc:线程池使用示例
 * @Date:Created in 14:11 2018/1/11
 */
@Controller
public class ThreadPoolDemoController{
/*


    private static ExecutorService pool = Executors.newCachedThreadPool();//线程池

    private static List<UserActionLog> userActionList = new ArrayList<UserActionLog>();

    private static List<UserListenLog> userListenList = new ArrayList<UserListenLog>();

    private static List<UserActionLog> tempList;

    private static List<UserListenLog> tempList1;

    @Autowired
    private RegistServiceImpl registServiceImpl;

    */
/**
     *
     * action log
     *//*

    @RequestMapping(value = "/userAction")
    public synchronized void userActionLog(HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        String userId = this.getLoginUser().getUid();

        Map<String, String> params = getParameterMap(request);
        String requestIp = params.get("operator_ip");
        String actionType = params.get("actionType");
        String start_date = params.get("start_date");
        String end_date = params.get("end_date");

        UserActionLog useractionlog = new UserActionLog();
        // useractionlog.setId(IdGenerator.getUUIDHex32());
        useractionlog.setAction_type(actionType);
        useractionlog.setUser_id(userId);
        useractionlog.setStart_state(start_date);
        useractionlog.setEnd_state(end_date);
        useractionlog.setChannel_type("");
        useractionlog.setOperator_ip(requestIp);
        userActionList.add(useractionlog);
        if (userActionList.size() == 100) {
            //          System.out.println("=======1======"+userActionList.size());
            tempList = new ArrayList<UserActionLog>();
            tempList.addAll(userActionList);
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        registServiceImpl.addUseractionlog(tempList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            userActionList.clear();
            userActionList = new ArrayList<UserActionLog>();
        }
    }

    */
/**
     * listen log
     *
     *//*

    @RequestMapping(value = "/userListen")
    public synchronized void userListenLog(HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        String userId = this.getLoginUser().getUid();

        Map<String, String> params = getParameterMap(request);
        String requestIp = params.get("operator_ip");
        String l_code = params.get("l_code");
        String listen_type = params.get("listen_type");
        String listen_date = params.get("listen_date");
        String item_code = params.get("item_code");
        String from_client = params.get("from_client");
        String cname = params.get("cname");
        String ename = params.get("ename");
        String listen_ip = params.get("listen_ip");
        String channel_type = params.get("channel_type");
        String org_user_id = params.get("org_user_id");
        String ischarged = params.get("ischarged");

        UserListenLog userListenLog = new UserListenLog();
        userListenLog.setListen_ip(requestIp);
        userListenLog.setL_code(l_code);
        userListenLog.setListen_type(listen_type);
        userListenLog.setListen_type(l_code);
        userListenLog.setListen_date(listen_date);
        userListenLog.setItem_code(item_code);
        userListenLog.setFrom_client(from_client);
        userListenLog.setCname(cname);
        userListenLog.setEname(ename);
        userListenLog.setListen_ip(listen_ip);
        userListenLog.setChannel_type(channel_type);
        userListenLog.setOrg_user_id(org_user_id);
        userListenLog.setIscharged(ischarged);
        userListenLog.setListen_user_id(userId);
        userListenList.add(userListenLog);
        if (userListenList.size() == 100) {
            System.out.println("=======11======"+userListenList.size());
            tempList1 = new ArrayList<UserListenLog>();
            tempList1.addAll(userListenList);
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        registServiceImpl.addUserListenLog(tempList1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            userListenList.clear();
            userListenList = new ArrayList<UserListenLog>();
        }

    }


*/

}