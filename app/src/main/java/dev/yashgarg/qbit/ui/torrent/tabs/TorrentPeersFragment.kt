package dev.yashgarg.qbit.ui.torrent.tabs

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.composethemeadapter3.Mdc3Theme
import dev.yashgarg.qbit.R
import dev.yashgarg.qbit.databinding.TorrentPeersFragmentBinding
import dev.yashgarg.qbit.ui.torrent.TorrentDetailsViewModel
import dev.yashgarg.qbit.utils.viewBinding
import qbittorrent.models.TorrentPeers

class TorrentPeersFragment : Fragment(R.layout.torrent_peers_fragment) {
    private val binding by viewBinding(TorrentPeersFragmentBinding::bind)
    private val viewModel by
        viewModels<TorrentDetailsViewModel>(ownerProducer = { requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.peersComposeView.setContent {
            val state by viewModel.uiState.collectAsState()
            Mdc3Theme { PeersListView(state.peers) }
        }
    }
}

@Composable
fun PeersListView(peers: TorrentPeers?) {
    // TODO: Impl a Lazy list view here
}
