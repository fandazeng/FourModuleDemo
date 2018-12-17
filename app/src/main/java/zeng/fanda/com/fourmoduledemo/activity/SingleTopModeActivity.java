package zeng.fanda.com.fourmoduledemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import zeng.fanda.com.fourmoduledemo.R;
import zeng.fanda.com.fourmoduledemo.base.BaseActivity;

/**
 * @author 曾凡达
 * @date 2018/11/29
 */
public class SingleTopModeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_singletop);
        ButterKnife.bind(this);
    }
    
    @OnClick({R.id.tv_navigation_singleTop})
    public void onClick(View view){
            switch (view.getId()){
                case R.id.tv_navigation_singleTop:
                        startActivity(new Intent(this,OtherTaskModeActivity.class));
                    break;
                default:
                    break;
            }
    }
}
