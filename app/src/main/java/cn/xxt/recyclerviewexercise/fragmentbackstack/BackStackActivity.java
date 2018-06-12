package cn.xxt.recyclerviewexercise.fragmentbackstack;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import cn.xxt.recyclerviewexercise.R;
/**
 * Fragment回退栈测试
 * @author zhq
 * @date 2018/5/23 下午4:49
 */
public class BackStackActivity extends AppCompatActivity {

    /** 控制页面显示状态的静态常量 */
    /** 显示h5布置天天练列表页面 */
    public static final int SHOW_WEB_VIEW_PAGE = 1;
    /** 显示选择联系人页面 */
    public static final int SHOW_ASSIGNMENT_CONTACTS_CHOOSER = 2;
    /** 显示原生布置天天练页面 */
    public static final int SHOW_TTL_ASSIGN = 3;

    private TtlListFragment ttlListFragment;

    private ContactsChooseFragment contactsChooseFragment;

    private TtlAssignFragment ttlAssignFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack);

        ttlListFragment = new TtlListFragment();
        contactsChooseFragment = new ContactsChooseFragment();
        ttlAssignFragment = new TtlAssignFragment();

        initUiWithData(null, SHOW_WEB_VIEW_PAGE);
    }

    public void initUiWithData(Bundle bundle, int status) {
        //开启事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (status) {
            case SHOW_WEB_VIEW_PAGE:
                //展示该Fragment
                transaction.add(R.id.fl_content, ttlListFragment, TtlListFragment.class.getName());
                break;
            case SHOW_ASSIGNMENT_CONTACTS_CHOOSER:
                transaction.add(R.id.fl_content, contactsChooseFragment
                        , ContactsChooseFragment.class.getName())
                        .hide(ttlListFragment);
                break;

            case SHOW_TTL_ASSIGN:
                transaction.add(R.id.fl_content, ttlAssignFragment, TtlAssignFragment.class.getName())
                        .hide(contactsChooseFragment)
                        .hide(ttlListFragment);
                break;
            default:
                break;
        }
        //提交事务
        transaction.addToBackStack(null)
                .commitAllowingStateLoss();
    }
}
