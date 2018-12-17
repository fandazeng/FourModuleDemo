package zeng.fanda.com.fourmoduledemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zeng.fanda.com.fourmoduledemo.MainActivity;
import zeng.fanda.com.fourmoduledemo.R;


/**
 * @author 曾凡达
 * @date 2018/11/27
 */
public class LifeFirstFragment extends Fragment {

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.i("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.i("onCreateView");
        View view = inflater.inflate(R.layout.fragment_life_frist,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.i("onViewCreated");
        unbinder = ButterKnife.bind(this, view);
    }

    @OnClick({R.id.tv_navigation_to_home})
    public void onClick(View view){
            switch (view.getId()){
                case R.id.tv_navigation_to_home:
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                    startActivity(new Intent(getActivity(),MainActivity.class));
                    break;
                default:
                    break;
            }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Logger.i("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.i("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.i("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.i("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.i("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.i("onDestroyView");
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.i("onDetach");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //横屏2,竖屏1
        Logger.i("onConfigurationChanged"+ newConfig.orientation );
    }
}
