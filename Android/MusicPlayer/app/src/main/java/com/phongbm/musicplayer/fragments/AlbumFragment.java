package com.phongbm.musicplayer.fragments;

import android.app.Activity;

import com.phongbm.musicplayer.R;
import com.phongbm.musicplayer.base.BaseFragment;
import com.phongbm.musicplayer.databinding.FragmentAlbumBinding;

public class AlbumFragment extends BaseFragment<FragmentAlbumBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    public int getTitle() {
        return R.string.album;
    }
}
