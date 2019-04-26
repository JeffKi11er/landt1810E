package com.phongbm.musicplayer.fragments;

import com.phongbm.musicplayer.R;
import com.phongbm.musicplayer.base.BaseFragment;
import com.phongbm.musicplayer.databinding.FragmentMusicBinding;

public class MusicFragment extends BaseFragment<FragmentMusicBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music;
    }

    @Override
    public int getTitle() {
        return R.string.music;
    }
}
