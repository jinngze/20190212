package gsp.com.homework_threen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import gsp.com.homework_threen.ui.Rxactivity;
import gsp.com.homework_threen.ui.Shactivity;
import gsp.com.homework_threen.ui.Tjactivity;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.button1)
    RadioButton button1;
    @BindView(R.id.button2)
    RadioButton button2;
    @BindView(R.id.button3)
    RadioButton button3;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.fram)
    FrameLayout fram;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Tjactivity tjactivity;
    private Rxactivity rxactivity;
    private Shactivity shactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        tjactivity = new Tjactivity();
        rxactivity = new Rxactivity();
        shactivity = new Shactivity();

        transaction.add(R.id.fram,tjactivity);
        transaction.add(R.id.fram,rxactivity);
        transaction.add(R.id.fram,shactivity);

        transaction.show(tjactivity).hide(rxactivity).hide(shactivity);

        transaction.commit();
        group.check(group.getChildAt(0).getId());
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.button1:
                        fragmentTransaction.show(tjactivity).hide(rxactivity).hide(shactivity).commit();
                        break;
                    case R.id.button2:
                        fragmentTransaction.show(rxactivity).hide(tjactivity).hide(shactivity).commit();
                        break;
                    case R.id.button3:
                        fragmentTransaction.show(shactivity).hide(rxactivity).hide(tjactivity).commit();
                        break;
                }
            }
        });
    }
}
