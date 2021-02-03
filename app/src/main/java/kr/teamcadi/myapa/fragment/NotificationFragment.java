package kr.teamcadi.myapa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.activity.MainActivity;

// 화면 설명 : 내 알림 화면 -> MainActivity로 연결
// Author : Jaey, Last Modified : 2021.01.16
public class NotificationFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_bottom_notification, container, false);

        return view;
    }
}
