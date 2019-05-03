package com.phongbm.musicplayer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.phongbm.musicplayer.R;
import com.phongbm.musicplayer.base.BaseAdapter;
import com.phongbm.musicplayer.base.BaseFragment;
import com.phongbm.musicplayer.databinding.FragmentMusicBinding;
import com.phongbm.musicplayer.model.Music;

public class MusicFragment extends BaseFragment<FragmentMusicBinding> {
    private BaseAdapter<Music> adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter<>(getContext(), R.layout.item_music);
        binding.lvSong.setAdapter(adapter);
        adapter.setData(systemData.getSongs());
    }

    @Override
    public int getTitle() {
        return R.string.music;
    }
}
