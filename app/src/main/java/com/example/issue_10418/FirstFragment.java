package com.example.issue_10418;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.issue_10418.databinding.FragmentFirstBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

public class FirstFragment extends Fragment {

  private FragmentFirstBinding binding;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {

    binding = FragmentFirstBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ExoPlayer player = new ExoPlayer.Builder(requireContext()).build();
    binding.playerView.setPlayer(player);

    player.addMediaItem(MediaItem.fromUri("https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd"));
    player.prepare();
    player.play();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}