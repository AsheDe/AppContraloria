package cu.bellalogica.jnjcuba2019

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.annotation.RawRes
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Util
import cu.edu.uo.informatizacion.contraloria.Portada


class Reproductor(var actividad: AppCompatActivity,
                  var player:SimpleExoPlayer?) : Player.DefaultEventListener() {

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if (playbackState == Player.STATE_ENDED) {
            actividad.startActivity(Intent(actividad,Portada::class.java))
        }

    }

    fun Reproducir(playerView: SimpleExoPlayerView,rawRes: Int ){
        player = ExoPlayerFactory.newSimpleInstance(
                DefaultRenderersFactory(playerView.context),
                DefaultTrackSelector(),
                DefaultLoadControl())
        playerView?.setPlayer(player)

        var datasrc = DefaultDataSourceFactory(playerView.context, Util.getUserAgent(playerView.context,"JNJ CUBA 2019"))
        var mediasrc = ExtractorMediaSource.Factory(datasrc).createMediaSource(RawResourceDataSource.buildRawResourceUri(rawRes))
        player?.prepare(mediasrc)
    }

  /*  fun initializePlayer(playerView : SimpleExoPlayerView ) {
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(
                    DefaultRenderersFactory(contexto),
                    DefaultTrackSelector(),
                    DefaultLoadControl())
            playerView?.setPlayer(player)
         //   var path = "android.resource://${actividad?.packageName}/${R.raw.video_m3}"
            player!!.setPlayWhenReady(true)
            // player.seekTo(currentWindow, playbackPosition)
            //   }
            val mediaSource = buildMediaSource(Uri.parse(path))
            player!!.prepare(mediaSource, true, false)
        }
    }

    private fun buildMediaSource(uri: Uri): MediaSource? {

        val userAgent = "exoplayer-codelab"

        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4")) {
            return ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                    .createMediaSource(uri)
        } //else if (uri.getLastPathSegment().contains("m3u8")) {
            //return HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
              //      .createMediaSource(uri)
         //else {
           // val dashChunkSourceFactory = DefaultDashChunkSource.Factory(
             //       DefaultHttpDataSourceFactory("ua", 100 ))
            //val manifestDataSourceFactory = DefaultHttpDataSourceFactory(userAgent)
            //return DashMediaSource.Factory(dashChunkSourceFactory, manifestDataSourceFactory).createMediaSource(uri)
        //}
        return null
    }*/

    fun releasePlayer() {
        if (player != null) {
          //var  playbackPosition = player.getCurrentPosition()
         //var   currentWindow = player.getCurrentWindowIndex()
         // var  playWhenReady = player.getPlayWhenReady()
            player!!.release()
            player = null
        }
    }
}